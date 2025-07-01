package br.com.appFrutaria.service;

import java.util.ArrayList;
import java.util.List;
import br.com.appFrutaria.model.Produto;
import br.com.appFrutaria.view.*;

public class Estoque {
    List<Produto> estoqueProdutos;
    Interface tela;

    public Estoque() {
        estoqueProdutos = new ArrayList<>();
        tela = new Interface();
    }

    public Estoque(List<Produto> estoqueProdutos) {
        this.estoqueProdutos = estoqueProdutos;
    }

    public void setProdutos(List<Produto> estoqueProdutos) {
        this.estoqueProdutos = estoqueProdutos;
    }

    public List<Produto> getEstoqueProdutos() {
        return estoqueProdutos;
    }

    public void gerenciarEstoque() {
        int escolhaInicial = 0;
        while (escolhaInicial != 7) {
            escolhaInicial = Menus.menuPrincipal();
            switch (escolhaInicial) {
                case 1:
                    Produto produto = tela.cadastrar();
                    estoqueProdutos.add(produto);
                    break;
                case 2:
                    tela.detalhar(estoqueProdutos);
                    break;
                case 3:
                    tela.remover(estoqueProdutos);
                    break;
                case 4:
                    Editar.editar(estoqueProdutos);
                    break;
                case 5:
                    Relatorio relatorio = new Relatorio();
                    relatorio.relatorioFrutaria(estoqueProdutos);
                    break;
                case 6:
                    CarrinhoCompras carrinho = new CarrinhoCompras();
                    carrinho.gerenciarCarrinho(estoqueProdutos);
                    break;
                case 7:
                    tela.encerrar();
                    break;
                default:
                    System.out.println("Opção inválida. Escolha um número entre 1 e 7.");
            }
        }
    }
}