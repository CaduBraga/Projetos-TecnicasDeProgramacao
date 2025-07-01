package br.com.appFrutaria.service;

import java.util.ArrayList;
import java.util.List;
import br.com.appFrutaria.model.Produto;
import br.com.appFrutaria.view.InterfaceCompra;

public class CarrinhoCompras {
    List<Produto> carrinhoProdutos;
    List<Integer> carrinhoQuantidades;
    double totalCarrinho;
    InterfaceCompra tela;

    public CarrinhoCompras() {
        carrinhoProdutos = new ArrayList<>();
        carrinhoQuantidades = new ArrayList<>();
        totalCarrinho = 0.0;
        tela = new InterfaceCompra();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        carrinhoProdutos.add(produto);
        carrinhoQuantidades.add(quantidade);
        totalCarrinho += produto.getPreco() * quantidade;
    }

    public void removerProduto(int index, int quantidade) {
        if (index >= 0 && index < carrinhoProdutos.size()) {
            Produto produto = carrinhoProdutos.get(index);
            int qtdAtual = carrinhoQuantidades.get(index);
            
            if (quantidade >= qtdAtual) {
                totalCarrinho -= produto.getPreco() * qtdAtual;
                carrinhoProdutos.remove(index);
                carrinhoQuantidades.remove(index);
            } else {
                totalCarrinho -= produto.getPreco() * quantidade;
                carrinhoQuantidades.set(index, qtdAtual - quantidade);
            }
        }
    }

    public void limparCarrinho() {
        carrinhoProdutos.clear();
        carrinhoQuantidades.clear();
        totalCarrinho = 0.0;
    }

    public boolean estaVazio() {
        return carrinhoProdutos.isEmpty();
    }

    public int getTamanho() {
        return carrinhoProdutos.size();
    }

    public Produto getProduto(int index) {
        if (index >= 0 && index < carrinhoProdutos.size()) {
            return carrinhoProdutos.get(index);
        }
        return null;
    }

    public int getQuantidade(int index) {
        if (index >= 0 && index < carrinhoQuantidades.size()) {
            return carrinhoQuantidades.get(index);
        }
        return 0;
    }

    public double getTotalCarrinho() {
        return totalCarrinho;
    }

    public List<Produto> getCarrinhoProdutos() {
        return carrinhoProdutos;
    }

    public List<Integer> getCarrinhoQuantidades() {
        return carrinhoQuantidades;
    }

    public void restaurarEstoque() {
        for (int i = 0; i < carrinhoProdutos.size(); i++) {
            Produto p = carrinhoProdutos.get(i);
            int qtd = carrinhoQuantidades.get(i);
            p.setQuantidade(p.getQuantidade() + qtd);
            Produto.adicionarProdutos(qtd);
        }
    }

    public void gerenciarCarrinho(List<Produto> estoqueProdutos) {
        int escolhaCarrinho = 0;
        while (escolhaCarrinho != 5) {
            escolhaCarrinho = tela.menuCarrinho();
            switch (escolhaCarrinho) {
                case 1:
                    tela.adicionarAoCarrinho(estoqueProdutos, this);
                    break;
                case 2:
                    tela.removerDoCarrinho(this);
                    break;
                case 3:
                    tela.mostrarCarrinho(this);
                    break;
                case 4:
                    tela.finalizarCompra(this);
                    escolhaCarrinho = 5;
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida. Escolha um número entre 1 e 5.");
            }
        }
    }
} 