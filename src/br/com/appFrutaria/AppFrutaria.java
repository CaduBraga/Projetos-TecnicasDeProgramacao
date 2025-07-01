package br.com.appFrutaria;

import br.com.appFrutaria.service.Estoque;
import br.com.appFrutaria.view.Interface;

public class AppFrutaria {
    public static void main(String[] args) {
        Interface.mensagemInicial();
        Estoque estoque = new Estoque();
        estoque.gerenciarEstoque();
    }
}