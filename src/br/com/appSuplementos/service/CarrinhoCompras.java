package br.com.appSuplementos.service;

import java.util.ArrayList;
import java.util.List;
import br.com.appSuplementos.model.Suplemento;
import br.com.appSuplementos.view.*;

public class CarrinhoCompras {
    List<Suplemento> carrinhoSuplementos;
    List<Integer> carrinhoQuantidades;
    double totalCarrinho;
    Interface tela;
    InterfaceCompra telaCarrinho;

    public CarrinhoCompras() {
        carrinhoSuplementos = new ArrayList<>();
        carrinhoQuantidades = new ArrayList<>();
        totalCarrinho = 0.0;
        tela = new Interface();
    }

    public void adicionarSuplemento(Suplemento suplemento, int quantidade) {
        carrinhoSuplementos.add(suplemento);
        carrinhoQuantidades.add(quantidade);
        totalCarrinho += suplemento.getPreco() * quantidade;
    }

    public void removerSuplemento(int index, int quantidade) {
        if (index >= 0 && index < carrinhoSuplementos.size()) {
            Suplemento suplemento = carrinhoSuplementos.get(index);
            int qtdAtual = carrinhoQuantidades.get(index);
            if (quantidade >= qtdAtual) {
                totalCarrinho -= suplemento.getPreco() * qtdAtual;
                carrinhoSuplementos.remove(index);
                carrinhoQuantidades.remove(index);
            } else {
                totalCarrinho -= suplemento.getPreco() * quantidade;
                carrinhoQuantidades.set(index, qtdAtual - quantidade);
            }
        }
    }

    public void limparCarrinho() {
        carrinhoSuplementos.clear();
        carrinhoQuantidades.clear();
        totalCarrinho = 0.0;
    }

    public boolean estaVazio() {
        return carrinhoSuplementos.isEmpty();
    }

    public int getTamanho() {
        return carrinhoSuplementos.size();
    }

    public Suplemento getSuplemento(int index) {
        if (index >= 0 && index < carrinhoSuplementos.size()) {
            return carrinhoSuplementos.get(index);
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

    public List<Suplemento> getCarrinhoSuplementos() {
        return carrinhoSuplementos;
    }

    public List<Integer> getCarrinhoQuantidades() {
        return carrinhoQuantidades;
    }

    public void restaurarEstoque() {
        for (int i = 0; i < carrinhoSuplementos.size(); i++) {
            Suplemento s = carrinhoSuplementos.get(i);
            int qtd = carrinhoQuantidades.get(i);
            s.setQuantidade(s.getQuantidade() + qtd);
            Suplemento.adicionarSuplementos(qtd);
        }
    }

    public void gerenciarCarrinho(List<Suplemento> estoqueSuplementos) {
        int escolhaCarrinho = 0;
        while (escolhaCarrinho != 5) {
            escolhaCarrinho = tela.menuCarrinho();
            switch (escolhaCarrinho) {
                case 1:
                    telaCarrinho.adicionarAoCarrinho(estoqueSuplementos, this);
                    break;
                case 2:
                    telaCarrinho.removerDoCarrinho(this);
                    break;
                case 3:
                    telaCarrinho.mostrarCarrinho(this);
                    break;
                case 4:
                    telaCarrinho.finalizarCompra(this);
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