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

            itinerarioViagemLexer lexer = new itinerarioViagemLexer(cs);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            itinerarioViagemParser parser = new itinerarioViagemParser(tokens);

            PrintWriter pw = new PrintWriter(arquivoSaida);
            //Criação de classe personalizada para obter erros customizados do Parser
            MyCustomErrorListener mcel = new MyCustomErrorListener(pw);
            parser.removeErrorListeners();
            parser.addErrorListener(mcel);

            ItinerarioContext ctx = parser.itinerario();

            if (!mcel.Errou()) {
                ItinerarioViagemSemantico semantico = new ItinerarioViagemSemantico();
                semantico.visitItinerario(ctx);
                List<String> errosSemanticos = ItinerarioViagemSemanticoUtils.errosSemanticos;
                if (!errosSemanticos.isEmpty()) {
                    for (String erro : errosSemanticos) {
                        pw.println(erro);
                    }
                }
            }

            pw.close();
        //catch para garantir tratamento de erro
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
