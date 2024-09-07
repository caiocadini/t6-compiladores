package br.ufscar.dc.compiladores.itinerarioViagem;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;

public class ItinerarioViagemSemanticoUtils {
    public static List<String> errosSemanticos = new ArrayList<>();

    public static void adicionarErroSemantico(Token t, String mensagem) {
        // Obtém a linha do token
        int linha = t.getLine();

        // Adiciona a mensagem de erro formatada
        errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
    }

    public static int converterTempo(String tempo) {
        // Separar horas e minutos de cada tempo
        String[] partesTempo = tempo.split(":");

        int horas = Integer.parseInt(partesTempo[0]);
        int minutos = Integer.parseInt(partesTempo[1]);

        // Converter cada tempo para minutos totais
        int totalMinutos = horas * 60 + minutos;

        return totalMinutos;
    }

}
