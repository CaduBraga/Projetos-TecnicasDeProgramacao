package br.com.appCursos.view;

import java.util.List;
import java.util.Scanner;
import br.com.appCursos.model.Curso;
import br.com.appCursos.service.CarrinhoCompras;

public class InterfaceCompra {
    Scanner input;

    public InterfaceCompra() {
        input = new Scanner(System.in);
    }

    public int menuCarrinho() {
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|                    CARRINHO DE COMPRAS                       |");
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|  O que você deseja fazer?                                    |");
        System.out.println("|                                                              |");
        System.out.println("|  1 - Adicionar cursos ao carrinho                            |");
        System.out.println("|  2 - Remover curso do carrinho                               |");
        System.out.println("|  3 - Ver carrinho                                            |");
        System.out.println("|  4 - Finalizar compra                                        |");
        System.out.println("|  5 - Voltar ao menu principal                                |");
        System.out.println("+--------------------------------------------------------------+");
        System.out.print("  Digite sua escolha: ");
        int escolha = input.nextInt();
        input.nextLine();
        System.out.println();
        return escolha;
    }

    public void adicionarAoCarrinho(List<Curso> estoqueCursos, CarrinhoCompras carrinho) {
        if (estoqueCursos.isEmpty()) {
            System.out.println("Estoque vazio.");
            return;
        }
        System.out.println("Cursos disponíveis:");
        int disponiveis = 0;
        for (int i = 0; i < estoqueCursos.size(); i++) {
            Curso c = estoqueCursos.get(i);
            if (c.getVagas() > 0) {
                disponiveis++;
                System.out.println(disponiveis + " - " + c.getNome() + " (Vagas: " + c.getVagas() + ", Preço: R$ "
                        + c.getPreco() + ")");
            }
        }
        if (disponiveis == 0) {
            System.out.println("Nenhum curso disponível para compra.");
            return;
        }
        System.out.print("Escolha o curso: ");
        int idx = input.nextInt();
        input.nextLine();
        if (idx < 1 || idx > disponiveis) {
            System.out.println("Opção inválida.");
            return;
        }
        Curso selecionado = null;
        int contador = 0;
        for (Curso c : estoqueCursos) {
            if (c.getVagas() > 0) {
                contador++;
                if (contador == idx) {
                    selecionado = c;
                    break;
                }
            }
        }
        System.out.print("Quantidade: ");
        int qtd = input.nextInt();
        input.nextLine();
        if (qtd <= 0 || qtd > selecionado.getVagas()) {
            System.out.println("Quantidade inválida.");
            return;
        }
        carrinho.adicionarCurso(selecionado, qtd);
        selecionado.setVagas(selecionado.getVagas() - qtd);
        System.out.println(qtd + "x '" + selecionado.getNome() + "' adicionado ao carrinho!");
    }

    public void removerDoCarrinho(CarrinhoCompras carrinho) {
        if (carrinho.estaVazio()) {
            System.out.println("Carrinho vazio.");
            return;
        }
        for (int i = 0; i < carrinho.getTamanho(); i++) {
            Curso c = carrinho.getCurso(i);
            System.out.println((i + 1) + " - " + c.getNome() + " (Qtd: " + carrinho.getQuantidade(i) + ")");
        }
        System.out.print("Escolha o curso para remover: ");
        int idx = input.nextInt() - 1;
        input.nextLine();
        if (idx < 0 || idx >= carrinho.getTamanho()) {
            System.out.println("Opção inválida.");
            return;
        }
        System.out.print("Quantidade a remover: ");
        int qtd = input.nextInt();
        input.nextLine();
        carrinho.removerCurso(idx, qtd);
        System.out.println("Curso removido do carrinho.");
    }

    public void mostrarCarrinho(CarrinhoCompras carrinho) {
        if (carrinho.estaVazio()) {
            System.out.println("Carrinho vazio.");
            return;
        }
        System.out.println("=== Itens no Carrinho ===");
        for (int i = 0; i < carrinho.getTamanho(); i++) {
            Curso c = carrinho.getCurso(i);
            System.out.println((i + 1) + " - " + c.getNome() + " (Qtd: " + carrinho.getQuantidade(i) + ", R$ "
                    + c.getPreco() + ")");
        }
        System.out.println("Total: R$ " + carrinho.getTotalCarrinho());
    }

    public void finalizarCompra(CarrinhoCompras carrinho) {
        if (carrinho.estaVazio()) {
            System.out.println("Carrinho vazio.");
            return;
        }
        mostrarCarrinho(carrinho);
        System.out.println("Compra finalizada! Obrigado.");
        carrinho.limparCarrinho();
    }
}