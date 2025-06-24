package br.com.appBiblioteca;

import br.com.appBiblioteca.view.Interface;
import br.com.appBiblioteca.service.Estoque;

public class AppBiblioteca {
    public static void main(String[] args) {

        Interface.mensagemInicial();

        Estoque estoqueLivro = new Estoque();

        estoqueLivro.gerenciarEstoque();
    }
}