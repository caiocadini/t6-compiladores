package br.ufscar.dc.compiladores.itinerarioViagem;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import java.util.BitSet;
import  java.io.PrintWriter;

public class MyCustomErrorListener implements ANTLRErrorListener {

    private PrintWriter pw;
    //Variável usada para parar a execução do Analisador Sintático no primeiro erro
    private boolean errou;

    public MyCustomErrorListener(PrintWriter pw){
        this.errou = false;
        this.pw = pw;
    }
    @Override
    public void	reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
        // Não será necessário para o T2, pode deixar vazio
    }
    
    @Override
    public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
        // Não será necessário para o T2, pode deixar vazio
    }

    @Override
    public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
        // Não será necessário para o T2, pode deixar vazio
    }

    @Override
    public void	syntaxError(Recognizer<?,?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        if(errou){
            //Quase já tenha errado não analisa nem o restante do código
            return;
        }

        Token t = (Token) offendingSymbol;
        String nomeToken = itinerarioViagemLexer.VOCABULARY.getDisplayName(t.getType());

        switch(nomeToken){
            //Análise de caso de erro Léxico
            case "SIMBOLO_NAO_ENCONTRADO":
                pw.println("Linha "+t.getLine()+": "+t.getText()+" - simbolo nao identificado");
                break;
            //Análise de caso de erro Léxico
            case "STRING_NAO_FECHADA":
                pw.println("Linha "+t.getLine()+": string nao fechada");
                break;
            //Caso específico de erro sintático para formatar a mensagem de modo a não aparecer <EOF> e sim apenas EOF
            case "EOF":
                pw.println("Linha " + t.getLine() + ": erro sintatico proximo a EOF");
                break;
            //Restante dos erros Sintáticos
            default:
                pw.println("Linha " + t.getLine() + ": erro sintatico proximo a " + t.getText());
        }
        //Caso tenha sido o primeiro erro -> Coloca variável como verdadeiro para não retornar mais erros
        this.errou = true;
        pw.println("Fim da compilacao");
    }
}