package br.ufscar.dc.compiladores.itinerarioViagem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


import br.ufscar.dc.compiladores.itinerarioViagem.itinerarioViagemParser.Viagem_infoContext;

public class ItinerarioViagemSemantico extends itinerarioViagemBaseVisitor<Void>{

    private TabelaDeSimbolos tabelaDuracao = new TabelaDeSimbolos();
    //Definição de variáveis no escopo geral da classe para realizar análises semânticas entre datas de início da viagem e data de chekc-in
    //e data de fim da viagem e data de check-out
    private LocalDate dataInicioViagem;
    private LocalDate dataFimViagem;
    
    @Override
    public Void visitViagem_info (itinerarioViagemParser.Viagem_infoContext ctx){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String dataInicioStr = ctx.data(0).getText();
        String dataFimStr = ctx.data(1).getText();

        dataInicioViagem = LocalDate.parse(dataInicioStr, formatter);
        dataFimViagem = LocalDate.parse(dataFimStr, formatter);
        //Validação para conferir se a data de fim da viagem não acontece antes da de início
        if (dataInicioViagem.isAfter(dataFimViagem)) {
            String mensagem = "Data de início não pode ser maior que a Data de fim";
            ItinerarioViagemSemanticoUtils.adicionarErroSemantico(ctx.data(0).getStart(), mensagem);
        }
        return super.visitViagem_info(ctx);
    }

    @Override
    public Void visitHospedagem_info (itinerarioViagemParser.Hospedagem_infoContext ctx){
        LocalDate dataInicio;
        LocalDate dataFim;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String dataInicioStr = ctx.data(0).getText();
        String dataFimStr = ctx.data(1).getText();

        dataInicio = LocalDate.parse(dataInicioStr, formatter);
        dataFim = LocalDate.parse(dataFimStr, formatter);
        //Validação se a data de check-in não está como depois da data de check-out
        if (dataInicio.isAfter(dataFim)) {
            String mensagem = "Data de check-in não pode ser maior que Data de check-out";
            ItinerarioViagemSemanticoUtils.adicionarErroSemantico(ctx.data(0).getStart(), mensagem);
        }
        //Comparação para verificar se a data de check-in é anterior à data de início da viagem
        if(dataInicio.isBefore(dataInicioViagem)){
            ItinerarioViagemSemanticoUtils.adicionarErroSemantico(ctx.data(0).getStart(), "Data de check-in não pode ser anterior à data de início da viagem");
        }
        //verificação se a data de check-out é anterior à data de fim da viagem
        if(dataFim.isAfter(dataFimViagem)){
            ItinerarioViagemSemanticoUtils.adicionarErroSemantico(ctx.data(1).getStart(), "Data de check-out não pode ser posterior à data de fim da viagem");
        }

        return super.visitHospedagem_info(ctx);
    }



    @Override
    public Void visitData(itinerarioViagemParser.DataContext ctx){
        //Validar o campo dia e o campo mês

        String mesString = ctx.DIA_MES(1).getText();
        int mesValor = Integer.parseInt(mesString);

        String anoString = ctx.ANO().getText();
        int anoValor = Integer.parseInt(anoString);

        String diaString = ctx.DIA_MES(0).getText();
        int diaValor = Integer.parseInt(diaString);

        //Dia ou mês nulo
        if( diaValor==0 || mesValor == 0){
            ItinerarioViagemSemanticoUtils.adicionarErroSemantico(ctx.getStart(), "Mês ou dia não podem ter valor nulo");
        }
        //Mês que não existe
        else if(mesValor > 12){
            ItinerarioViagemSemanticoUtils.adicionarErroSemantico(ctx.getStart(), "Valor do mês incorreto ");
        }
        else if(mesValor == 2){//Fevereiro
            if(anoValor%4 == 0){
                //Ano bissexto: Pode ir até dia 29
                if(diaValor > 29){
                    ItinerarioViagemSemanticoUtils.adicionarErroSemantico(ctx.getStart(), "Valor de dia incorreto para o ano bissexto");
                }
            }else{
                //Não é bissexto: apenas até dia 28
                if(diaValor > 28){
                    ItinerarioViagemSemanticoUtils.adicionarErroSemantico(ctx.getStart(), "Valor de dia incorreto para o mês" + mesString );
                }
            }
        }
        else if (mesValor%2 == 0) {
            //Meses pares tem até 30 dias apenas
            if(diaValor>30){
                ItinerarioViagemSemanticoUtils.adicionarErroSemantico(ctx.getStart(), "Valor de dia incorreto para o mês" + mesString );
            }
        }
        else{
            //Meses ímpares tem até 31 dias
            if(diaValor>31){
                ItinerarioViagemSemanticoUtils.adicionarErroSemantico(ctx.getStart(), "Valor de dia incorreto para o mês" + mesString );
            }
        }
        return super.visitData(ctx);
    }
    //Análise semântica da duração das atividades
    @Override
    public Void visitAtividade_list(itinerarioViagemParser.Atividade_listContext ctx){
        for(itinerarioViagemParser.Atividade_itemContext ai : ctx.atividade_item()){
            String diaString = ai.data().getText();
            String duracaoString = ai.TEMPO().getText();
            int duracaoValor = ItinerarioViagemSemanticoUtils.converterTempo(duracaoString);
            //Se já existe informações a respeito da tabela
            if(tabelaDuracao.existe(diaString)){
                int duracaoExistente = tabelaDuracao.verificar(diaString);
                int somaDuracao = duracaoValor + duracaoExistente;
                //Duração de todas as atividades no dia é maior do que 24 horas
                if(somaDuracao > 1440){
                    ItinerarioViagemSemanticoUtils.adicionarErroSemantico(ai.getStart(), "A duração das atividades para o dia " + diaString + " é maior do que 24 horas");
                }else{
                    tabelaDuracao.modificar(diaString, somaDuracao);
                } 
            }else{
                tabelaDuracao.adicionar(diaString, duracaoValor);
            }
        }
        return super.visitAtividade_list(ctx);
    }
}
