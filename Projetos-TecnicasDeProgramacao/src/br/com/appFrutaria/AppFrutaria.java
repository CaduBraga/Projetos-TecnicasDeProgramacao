package br.com.appFrutaria;

import br.com.appFrutaria.view.Interface;
import br.com.appFrutaria.service.Estoque;

public class AppFrutaria {
    public static void main(String[] args) {

        Interface.mensagemInicial();

        Estoque estoqueFruta = new Estoque();

        estoqueFruta.gerenciarEstoque();
    }
}