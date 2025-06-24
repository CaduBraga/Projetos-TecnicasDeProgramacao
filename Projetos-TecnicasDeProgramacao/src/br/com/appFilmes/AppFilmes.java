package br.com.appFilmes;

import br.com.appFilmes.view.Interface;
import br.com.appFilmes.service.Estoque;

public class AppFilmes {
    public static void main(String[] args) {

        Interface.mensagemInicial();

        Estoque estoqueFilme = new Estoque();

        estoqueFilme.gerenciarEstoque();
    }
} 