package br.ufscar.dc.compiladores.itinerarioViagem;

import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import br.ufscar.dc.compiladores.itinerarioViagem.itinerarioViagemParser.ItinerarioContext;

import java.util.List;


import  java.io.PrintWriter;

public class App {

    public static void main(String[] args) {
        boolean erroLex = false;
        try {
            CharStream cs = CharStreams.fromFileName(args[0]);
            //Declaração de Lexer e Parser
            itinerarioViagemLexer lexer = new itinerarioViagemLexer(cs);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            itinerarioViagemParser parser = new itinerarioViagemParser(tokens);

            PrintWriter pw = new PrintWriter("index.html");
            //Criação de classe personalizada para obter erros customizados do Parser
            MyCustomErrorListener mcel = new MyCustomErrorListener(pw);
            parser.removeErrorListeners();
            parser.addErrorListener(mcel);

            ItinerarioContext ctx = parser.itinerario();
            //Se não houverem erros Sintáticos/Léxicos, roda a análise semântica
            if (!mcel.Errou()) {
                ItinerarioViagemSemantico semantico = new ItinerarioViagemSemantico();
                semantico.visitItinerario(ctx);
                List<String> errosSemanticos = ItinerarioViagemSemanticoUtils.errosSemanticos;
                //Se não houverem erros semânticos, gera o código em HTML
                if (errosSemanticos.isEmpty()) {
                    // Gerar código HTML
                    ItinerarioToHtml gerador = new ItinerarioToHtml();
                    gerador.visitItinerario(ctx);
                    pw.print(gerador.finalCode.toString());
                    
                } else {
                    // Escrever erros semânticos no arquivo de saída
                    for (String erro : errosSemanticos) {
                        pw.println(erro);
                    }
                    pw.print("Fim da compilacao");
                }
            }

            pw.close();
        //catch para garantir tratamento de erro
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
