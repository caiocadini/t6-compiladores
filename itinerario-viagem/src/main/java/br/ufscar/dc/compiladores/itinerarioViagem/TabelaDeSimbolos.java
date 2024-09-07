package br.ufscar.dc.compiladores.itinerarioViagem;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class TabelaDeSimbolos {
    private Map<String, Integer> tabela;
    

    public TabelaDeSimbolos() {
        tabela = new HashMap<>();
         
    }

    public void adicionar(String nome, int value) {
        tabela.put(nome, value);
    }

    public void modificar(String nome, int newValue) {
        tabela.put(nome, newValue);
    }


    public boolean existe(String nome) {
        return tabela.containsKey(nome);
    }

    public int verificar(String nome) {
        return tabela.get(nome);
    }
    
    

    // Used for debugging
    public Map<String, Integer> obterTodosSimbolos() {
        return tabela;
    }
}