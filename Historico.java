package br.edu.usj.calculadora.calculadoralul;

import java.util.ArrayList;
import java.util.List;

public class Historico {
    
    List<String> listaDeOperacoes = new ArrayList<>();

    void add(String calculo){
        listaDeOperacoes.add(calculo);
    }

    List<String> lerLista(){
        return listaDeOperacoes;
    }
}