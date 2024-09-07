package br.ufscar.dc.compiladores.itinerarioViagem;

import java.util.LinkedList;
import java.util.List;

public class Escopos {

    private LinkedList<TabelaDeSimbolos> pilhaDeTabelas;

    public Escopos() {
        pilhaDeTabelas = new LinkedList<>();
        criarNovoEscopo();  // Cria o primeiro escopo padrão.
    }

    // Cria um novo escopo adicionando uma nova TabelaDeSimbolos na pilha.
    public void criarNovoEscopo() {
        pilhaDeTabelas.push(new TabelaDeSimbolos());
    }


    public TabelaDeSimbolos obterEscopoAtual() {
        return pilhaDeTabelas.peek();
    }


    public List<TabelaDeSimbolos> percorrerEscoposAninhados() {
        return pilhaDeTabelas;
    }


    public void abandonarEscopo() {
        pilhaDeTabelas.pop();
    }
}