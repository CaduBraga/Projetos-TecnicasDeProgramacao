package br.com.appCursos.service;

import java.util.ArrayList;
import java.util.List;
import br.com.appCursos.model.Curso;

public class CarrinhoCompras {
    private List<Curso> carrinhoCursos;
    private List<Integer> carrinhoQuantidades;
    private double totalCarrinho;

    public CarrinhoCompras() {
        carrinhoCursos = new ArrayList<>();
        carrinhoQuantidades = new ArrayList<>();
        totalCarrinho = 0.0;
    }

    public void adicionarCurso(Curso curso, int quantidade) {
        carrinhoCursos.add(curso);
        carrinhoQuantidades.add(quantidade);
        totalCarrinho += curso.getPreco() * quantidade;
    }

    public void removerCurso(int index, int quantidade) {
        if (index >= 0 && index < carrinhoCursos.size()) {
            Curso curso = carrinhoCursos.get(index);
            int qtdAtual = carrinhoQuantidades.get(index);
            if (quantidade >= qtdAtual) {
                totalCarrinho -= curso.getPreco() * qtdAtual;
                curso.setVagas(curso.getVagas() + qtdAtual);
                carrinhoCursos.remove(index);
                carrinhoQuantidades.remove(index);
            } else {
                totalCarrinho -= curso.getPreco() * quantidade;
                curso.setVagas(curso.getVagas() + quantidade);
                carrinhoQuantidades.set(index, qtdAtual - quantidade);
            }
        }
    }

    public void limparCarrinho() {
        for (int i = 0; i < carrinhoCursos.size(); i++) {
            Curso c = carrinhoCursos.get(i);
            int qtd = carrinhoQuantidades.get(i);
            c.setVagas(c.getVagas() + qtd);
        }
        carrinhoCursos.clear();
        carrinhoQuantidades.clear();
        totalCarrinho = 0.0;
    }

    public boolean estaVazio() {
        return carrinhoCursos.isEmpty();
    }

    public int getTamanho() {
        return carrinhoCursos.size();
    }

    public Curso getCurso(int index) {
        if (index >= 0 && index < carrinhoCursos.size()) {
            return carrinhoCursos.get(index);
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

    public List<Curso> getCarrinhoCursos() {
        return carrinhoCursos;
    }

    public List<Integer> getCarrinhoQuantidades() {
        return carrinhoQuantidades;
    }
}