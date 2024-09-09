package br.ufscar.dc.compiladores.itinerarioViagem;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class ItinerarioToHtml extends itinerarioViagemBaseVisitor<Object> {
    public StringBuilder finalCode;
    private Map<String, List<String>> atividadesPorDia;

    //Construtor
    public ItinerarioToHtml() {
        finalCode = new StringBuilder();
        atividadesPorDia = new HashMap<>();
    }

    //Declaração inicial da página, adiciona headers, estilos, começo do corpo e o título de acordo com o título no algoritmo
    @Override
    public Object visitItinerario(itinerarioViagemParser.ItinerarioContext ctx) {
        finalCode.append("<!DOCTYPE html>\n");
        finalCode.append("<html>\n");
        finalCode.append("<head>\n");
        finalCode.append("<meta charset=\"UTF-8\">\n");
        finalCode.append("<title>Itinerário de Viagem</title>\n");
        finalCode.append("<style>\n");
        finalCode.append("body { font-family: Arial, sans-serif; margin: 20px; background-color: #f4f4f4; }\n");
        finalCode.append("h1 { color: #0056b3; border-bottom: 2px solid #0056b3; padding-bottom: 10px; }\n");
        finalCode.append("h2 { color: #007acc; border-bottom: 1px solid #007acc; padding-bottom: 5px; }\n");
        finalCode.append("ul { list-style-type: none; padding: 0; }\n");
        finalCode.append("li { margin-bottom: 15px; }\n");
        finalCode.append("strong { color: #333; }\n");
        finalCode.append(".dia { background-color: #e1e1e1; padding: 10px; border-radius: 5px; margin-bottom: 10px; }\n");
        finalCode.append(".atividade { background-color: #ffffff; padding: 10px; border: 1px solid #ddd; border-radius: 5px; margin-bottom: 5px; }\n");
        finalCode.append("</style>\n");
        finalCode.append("</head>\n");
        finalCode.append("<body>\n");
        finalCode.append("<h1>" + removeQuotes(ctx.STRING().getText()) + "</h1>\n");
        return super.visitItinerario(ctx);
    }

    //Define as informações da viagem no arquivo final
    @Override
    public Object visitViagem_info(itinerarioViagemParser.Viagem_infoContext ctx) {
        finalCode.append("<h2>Informações da Viagem</h2>\n");
        finalCode.append("<ul>\n");
        finalCode.append("<li><strong>Data de Início da Viagem:</strong> " + removeQuotes(ctx.data(0).getText()) + "</li>\n");
        finalCode.append("<li><strong>Data de Fim da Viagem:</strong> " + removeQuotes(ctx.data(1).getText()) + "</li>\n");
        finalCode.append("<li><strong>Destino:</strong> " + removeQuotes(ctx.STRING().getText()) + "</li>\n");
        finalCode.append("</ul>\n");
        return super.visitViagem_info(ctx);
    }

    //Anota informações da Hospedagem
    @Override
    public Object visitHospedagem_info(itinerarioViagemParser.Hospedagem_infoContext ctx) {
        finalCode.append("<h2>Informações sobre a Hospedagem</h2>\n");
        finalCode.append("<ul>\n");
        finalCode.append("<li><strong>Tipo:</strong> " + removeQuotes(ctx.STRING(0).getText()) + "</li>\n");
        finalCode.append("<li><strong>Nome:</strong> " + removeQuotes(ctx.STRING(1).getText()) + "</li>\n");
        finalCode.append("<li><strong>Check In:</strong> " + removeQuotes(ctx.data(0).getText()) + "</li>\n");
        finalCode.append("<li><strong>Check Out:</strong> " + removeQuotes(ctx.data(1).getText()) + "</li>\n");
        finalCode.append("</ul>\n");
        return super.visitHospedagem_info(ctx);
    }

    //Anota informações de transporte
    @Override
    public Object visitTransporte_info(itinerarioViagemParser.Transporte_infoContext ctx) {
        finalCode.append("<h2>Informações de Transporte</h2>\n");
        finalCode.append("<ul>\n");
        finalCode.append("<li><strong>Tipo:</strong> " + removeQuotes(ctx.STRING(0).getText()) + "</li>\n");
        finalCode.append("<li><strong>Companhia:</strong> " + removeQuotes(ctx.STRING(1).getText()) + "</li>\n");
        finalCode.append("</ul>\n");
        return super.visitTransporte_info(ctx);
    }

    //Gera informações das atividades que podem ser realizadas na viagem
    @Override
    public Object visitAtividades_info(itinerarioViagemParser.Atividades_infoContext ctx) {
        finalCode.append("<h2>Atividades</h2>\n");
        finalCode.append("<ul>\n");

        //Agrupamento das viagens de acordo com o dia de cada uma
        for (itinerarioViagemParser.Atividade_itemContext ai : ctx.atividade_list().atividade_item()) {
            String dia = removeQuotes(ai.data().getText());
            String atividade = removeQuotes(ai.STRING(0).getText());
            String local = removeQuotes(ai.STRING(1).getText());
            String duracao = ai.TEMPO().getText();

            String atividadeInfo = "<div class=\"atividade\">\n" +
                                   "<p><strong>Atividade:</strong> " + atividade + "</p>\n" +
                                   "<p><strong>Local:</strong> " + local + "</p>\n" +
                                   "<p><strong>Duração:</strong> " + duracao + "</p>\n" +
                                   "</div>\n";
            //Se o dia ainda não está presente no hash map de dias, adiciona-o
            if (!atividadesPorDia.containsKey(dia)) {
                atividadesPorDia.put(dia, new ArrayList<String>());
            }
            atividadesPorDia.get(dia).add(atividadeInfo);
        }

        //Gera as atividades de acordo commo elas estão agrupadas por dias
        for (Map.Entry<String, List<String>> entry : atividadesPorDia.entrySet()) {
            String dia = entry.getKey();
            List<String> atividades = entry.getValue();

            finalCode.append("<li class=\"dia\"><strong>Dia:</strong> " + dia + "<div>\n");
            for (String atividade : atividades) {
                finalCode.append(atividade);
            }
            finalCode.append("</div></li>\n");
        }

        finalCode.append("</ul>\n");
        finalCode.append("</body>\n");
        finalCode.append("</html>\n");
        return super.visitAtividades_info(ctx);
    }

    private String removeQuotes(String text) {
        // Remove aspas duplas do início e do final da string, se existirem
        if (text.length() > 1 && text.startsWith("\"") && text.endsWith("\"")) {
            return text.substring(1, text.length() - 1);
        }
        return text;
    }
}
