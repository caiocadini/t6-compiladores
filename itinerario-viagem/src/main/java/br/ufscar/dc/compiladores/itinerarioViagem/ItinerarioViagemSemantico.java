package br.ufscar.dc.compiladores.itinerarioViagem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


import br.ufscar.dc.compiladores.itinerarioViagem.itinerarioViagemParser.Viagem_infoContext;

public class ItinerarioViagemSemantico extends itinerarioViagemBaseVisitor<Void>{

    private TabelaDeSimbolos tabelaDuracao = new TabelaDeSimbolos();

    @Override
    public Void visitViagem_info (itinerarioViagemParser.Viagem_infoContext ctx){
        LocalDate dataInicio;
        LocalDate dataFim;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String dataInicioStr = ctx.data(0).getText();
        String dataFimStr = ctx.data(1).getText();

        dataInicio = LocalDate.parse(dataInicioStr, formatter);
        dataFim = LocalDate.parse(dataFimStr, formatter);

        if (dataInicio.isAfter(dataFim)) {
            String mensagem = "Erro semântico: DATA_INICIO não pode ser maior que DATA_FIM";
            ItinerarioViagemSemanticoUtils.adicionarErroSemantico(ctx.data(0).getStart(), mensagem);
        }

        return super.visitViagem_info(ctx);
    }

    @Override
    public Void visitData(itinerarioViagemParser.DataContext ctx){
        //Validar o campo dia e o campo mês
        //Pegar DIAMES(0) DIAMES(1) e validar

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
        else if(mesValor > 12){
            ItinerarioViagemSemanticoUtils.adicionarErroSemantico(ctx.getStart(), "Valor do mês incorreto ");
        }
        else if(mesValor == 2){//Fevereiro
            if(anoValor%4 == 0){
                //Ano bissexto
                if(diaValor > 29){
                    ItinerarioViagemSemanticoUtils.adicionarErroSemantico(ctx.getStart(), "Valor de dia incorreto para o ano bissexto");
                }
            }else{
                //Não é bissexto
                if(diaValor > 28){
                    ItinerarioViagemSemanticoUtils.adicionarErroSemantico(ctx.getStart(), "Valor de dia incorreto para o mês" + mesString );
                }
            }
        }
        else if (mesValor%2 == 0) {
            //Meses pares
            if(diaValor>30){
                ItinerarioViagemSemanticoUtils.adicionarErroSemantico(ctx.getStart(), "Valor de dia incorreto para o mês" + mesString );
            }
        }
        else{
            if(diaValor>31){
                ItinerarioViagemSemanticoUtils.adicionarErroSemantico(ctx.getStart(), "Valor de dia incorreto para o mês" + mesString );
            }
        }
        return super.visitData(ctx);
    }

    @Override
    public Void visitAtividade_list(itinerarioViagemParser.Atividade_listContext ctx){
        for(itinerarioViagemParser.Atividade_itemContext ai : ctx.atividade_item()){
            String diaString = ai.data().getText();
            String duracaoString = ai.TEMPO().getText();
            int duracaoValor = ItinerarioViagemSemanticoUtils.converterTempo(duracaoString);
            if(tabelaDuracao.existe(diaString)){
                int duracaoExistente = tabelaDuracao.verificar(diaString);
                int somaDuracao = duracaoValor + duracaoExistente;
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
