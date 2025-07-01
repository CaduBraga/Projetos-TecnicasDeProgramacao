package br.com.appBiblioteca;

import br.com.appBiblioteca.service.Estoque;
import br.com.appBiblioteca.view.Interface;

public class AppBiblioteca {
    public static void main(String[] args) {

        Interface.mensagemInicial();

        Estoque estoqueLivro = new Estoque();

        estoqueLivro.gerenciarEstoque();
    }
}