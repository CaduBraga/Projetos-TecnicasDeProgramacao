package br.com.appSuplementos.service;

import java.util.ArrayList;
import java.util.List;

import br.com.appSuplementos.model.Suplemento;
import br.com.appSuplementos.view.Interface;

public class Estoque {
    List<Suplemento> estoqueSuplemento;
    Interface tela;

    public Estoque() {
        estoqueSuplemento = new ArrayList<>();
        tela = new Interface();
    }

    public Estoque(List<Suplemento> estoqueSuplemento) {
        this.estoqueSuplemento = estoqueSuplemento;
    }

    public void setSuplemento(List<Suplemento> estoqueSuplemento) {
        this.estoqueSuplemento = estoqueSuplemento;
    }

    public List<Suplemento> getEstoqueSuplemento() {
        return estoqueSuplemento;
    }

    public void gerenciarEstoque() {
        int escolhaInicial = 0;
        while (escolhaInicial != 5) {
            escolhaInicial = tela.menuPrincipal();
            switch (escolhaInicial) {

                case 1:
                    Suplemento suplemento = tela.cadastrar();
                    estoqueSuplemento.add(suplemento);
                    break;

                case 2:
                    tela.detalhar(estoqueSuplemento);
                    break;

                case 3:
                    tela.remover(estoqueSuplemento);
                    break;

                case 4:
                    tela.editar(estoqueSuplemento);
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