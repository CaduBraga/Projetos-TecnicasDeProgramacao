package br.com.appSuplementos;

import br.com.appSuplementos.view.Interface;
import br.com.appSuplementos.service.Estoque;

public class AppSuplementos {
    public static void main(String[] args) {

        Interface.mensagemInicial();

        Estoque estoqueSuplemento = new Estoque();

        estoqueSuplemento.gerenciarEstoque();
    }
} 