package br.com.appFilmes.service;

import java.util.ArrayList;
import java.util.List;
import br.com.appFilmes.model.Filme;

public class CarrinhoCompras {
    private List<Filme> carrinhoFilmes;
    private List<Integer> carrinhoQuantidades;
    private double totalCarrinho;

    public CarrinhoCompras() {
        carrinhoFilmes = new ArrayList<>();
        carrinhoQuantidades = new ArrayList<>();
        totalCarrinho = 0.0;
    }

    public void adicionarFilme(Filme filme, int quantidade) {
        carrinhoFilmes.add(filme);
        carrinhoQuantidades.add(quantidade);
        totalCarrinho += filme.getPreco() * quantidade;
    }

    public void removerFilme(int index, int quantidade) {
        if (index >= 0 && index < carrinhoFilmes.size()) {
            Filme filme = carrinhoFilmes.get(index);
            int qtdAtual = carrinhoQuantidades.get(index);
            if (quantidade >= qtdAtual) {
                totalCarrinho -= filme.getPreco() * qtdAtual;
                filme.setQuantidade(filme.getQuantidade() + qtdAtual);
                carrinhoFilmes.remove(index);
                carrinhoQuantidades.remove(index);
            } else {
                totalCarrinho -= filme.getPreco() * quantidade;
                filme.setQuantidade(filme.getQuantidade() + quantidade);
                carrinhoQuantidades.set(index, qtdAtual - quantidade);
            }
        }
    }

    public void limparCarrinho() {
        for (int i = 0; i < carrinhoFilmes.size(); i++) {
            Filme f = carrinhoFilmes.get(i);
            int qtd = carrinhoQuantidades.get(i);
            f.setQuantidade(f.getQuantidade() + qtd);
        }
        carrinhoFilmes.clear();
        carrinhoQuantidades.clear();
        totalCarrinho = 0.0;
    }

    public boolean estaVazio() {
        return carrinhoFilmes.isEmpty();
    }

    public int getTamanho() {
        return carrinhoFilmes.size();
    }

    public Filme getFilme(int index) {
        if (index >= 0 && index < carrinhoFilmes.size()) {
            return carrinhoFilmes.get(index);
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

    public List<Filme> getCarrinhoFilmes() {
        return carrinhoFilmes;
    }

    public List<Integer> getCarrinhoQuantidades() {
        return carrinhoQuantidades;
    }
}