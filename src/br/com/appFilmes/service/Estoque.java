package br.com.appFilmes.service;

import br.com.appFilmes.model.Filme;
import br.com.appFilmes.view.Interface;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    List<Filme> estoqueFilme;
    Interface tela;

    public Estoque() {
        estoqueFilme = new ArrayList<>();
        tela = new Interface();
    }

    public Estoque(List<Filme> estoqueFilme) {
        this.estoqueFilme = estoqueFilme;
    }

    public void setFilme(List<Filme> estoqueFilme) {
        this.estoqueFilme = estoqueFilme;
    }

    public List<Filme> getEstoqueFilme() {
        return estoqueFilme;
    }

    public void gerenciarEstoque() {
        int escolhaInicial = 0;
        CarrinhoCompras carrinho = new CarrinhoCompras();
        while (escolhaInicial != 7) {
            escolhaInicial = tela.menuPrincipal();
            switch (escolhaInicial) {
                case 1:
                    Filme filme = tela.cadastrar();
                    estoqueFilme.add(filme);
                    break;
                case 2:
                    tela.detalhar(estoqueFilme);
                    break;
                case 3:
                    tela.remover(estoqueFilme);
                    break;
                case 4:
                    tela.editar(estoqueFilme);
                    break;
                case 5:
                    carrinho.gerenciarCarrinho(estoqueFilme);
                    break;
                case 6:
                    br.com.appFilmes.view.Relatorio relatorio = new br.com.appFilmes.view.Relatorio();
                    relatorio.relatorioFilmes(estoqueFilme);
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