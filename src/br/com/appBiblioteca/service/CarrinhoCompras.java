package br.com.appBiblioteca.service;

import br.com.appBiblioteca.model.Livro;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {
    private List<Livro> carrinhoLivros;
    private List<Integer> carrinhoQuantidades;
    private double totalCarrinho;

    public CarrinhoCompras() {
        carrinhoLivros = new ArrayList<>();
        carrinhoQuantidades = new ArrayList<>();
        totalCarrinho = 0.0;
    }

    public void adicionarLivro(Livro livro, int quantidade) {
        carrinhoLivros.add(livro);
        carrinhoQuantidades.add(quantidade);
        totalCarrinho += livro.getPreco() * quantidade;
    }

    public void removerLivro(int index, int quantidade) {
        if (index >= 0 && index < carrinhoLivros.size()) {
            Livro livro = carrinhoLivros.get(index);
            int qtdAtual = carrinhoQuantidades.get(index);
            if (quantidade >= qtdAtual) {
                totalCarrinho -= livro.getPreco() * qtdAtual;
                livro.setQuantidade(livro.getQuantidade() + qtdAtual);
                carrinhoLivros.remove(index);
                carrinhoQuantidades.remove(index);
            } else {
                totalCarrinho -= livro.getPreco() * quantidade;
                livro.setQuantidade(livro.getQuantidade() + quantidade);
                carrinhoQuantidades.set(index, qtdAtual - quantidade);
            }
        }
    }

    public void limparCarrinho() {
        for (int i = 0; i < carrinhoLivros.size(); i++) {
            Livro l = carrinhoLivros.get(i);
            int qtd = carrinhoQuantidades.get(i);
            l.setQuantidade(l.getQuantidade() + qtd);
        }
        carrinhoLivros.clear();
        carrinhoQuantidades.clear();
        totalCarrinho = 0.0;
    }

    public boolean estaVazio() {
        return carrinhoLivros.isEmpty();
    }

    public int getTamanho() {
        return carrinhoLivros.size();
    }

    public Livro getLivro(int index) {
        if (index >= 0 && index < carrinhoLivros.size()) {
            return carrinhoLivros.get(index);
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

    public List<Livro> getCarrinhoLivros() {
        return carrinhoLivros;
    }

    public List<Integer> getCarrinhoQuantidades() {
        return carrinhoQuantidades;
    }

    public void gerenciarCarrinho(List<Livro> estoqueLivros) {
        br.com.appBiblioteca.view.InterfaceCompra tela = new br.com.appBiblioteca.view.InterfaceCompra();
        int escolhaCarrinho = 0;
        while (escolhaCarrinho != 5) {
            escolhaCarrinho = tela.menuCarrinho();
            switch (escolhaCarrinho) {
                case 1:
                    tela.adicionarAoCarrinho(estoqueLivros, this);
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