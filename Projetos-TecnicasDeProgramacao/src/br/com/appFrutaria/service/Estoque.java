package br.com.appFrutaria.service;

import java.util.ArrayList;
import java.util.List;
import br.com.appFrutaria.model.Fruta;
import br.com.appFrutaria.view.Interface;

public class Estoque {
    List<Fruta> estoqueFruta;
    Interface tela;
    /*
     * eu queria usar interface ao invés de tela,
     * mas interface é uma palavra protegida pelo Java
     */

    public Estoque() {
        estoqueFruta = new ArrayList<>();
        tela = new Interface();
    }

    public Estoque(List<Fruta> estoqueFruta) {
        this.estoqueFruta = estoqueFruta;
    }

    public void setFruta(List<Fruta> estoqueFruta) {
        this.estoqueFruta = estoqueFruta;
    }

    public List<Fruta> getEstoqueFruta() {
        return estoqueFruta;
    }

    public void gerenciarEstoque() {
        int escolhaInicial = 0;
        while (escolhaInicial != 5) {
            escolhaInicial = tela.menuPrincipal();
            switch (escolhaInicial) {

                case 1:
                    Fruta fruta = tela.cadastrar();
                    estoqueFruta.add(fruta);
                    break;

                case 2:
                    tela.detalhar(estoqueFruta);
                    break;

                case 3:
                    tela.remover(estoqueFruta);
                    break;

                case 4:
                    tela.editar(estoqueFruta);
                    break;

                case 5:
                    tela.encerrar();
                    break;
                default:
                    System.out.println("Opção inválida. Escolha um número entre 1 e 5.");
            }
        }
    }
}