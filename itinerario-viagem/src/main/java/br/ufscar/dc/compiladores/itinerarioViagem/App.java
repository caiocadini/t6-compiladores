package br.ufscar.dc.compiladores.itinerarioViagem;

import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;


import  java.io.PrintWriter;

public class App {

    public static void main(String[] args) {
        //Obter o arquivo onde se escreve o retorno do analisador
        String arquivoSaida = args[1];
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

            parser.itinerario();
            pw.close();
        //catch para garantir tratamento de erro
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
