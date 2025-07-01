package br.com.appBiblioteca.view;

import java.util.List;
import java.util.Scanner;
import br.com.appBiblioteca.model.Livro;
import br.com.appBiblioteca.service.CarrinhoCompras;

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
        System.out.println("|  1 - Adicionar livros ao carrinho                            |");
        System.out.println("|  2 - Remover livro do carrinho                               |");
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

    public void adicionarAoCarrinho(List<Livro> estoqueLivros, CarrinhoCompras carrinho) {
        if (estoqueLivros.isEmpty()) {
            System.out.println("Estoque vazio.");
            return;
        }
        System.out.println("Livros disponíveis:");
        int disponiveis = 0;
        for (int i = 0; i < estoqueLivros.size(); i++) {
            Livro l = estoqueLivros.get(i);
            if (l.getQuantidade() > 0) {
                disponiveis++;
                System.out.println(disponiveis + " - " + l.getNome() + " (Qtd: " + l.getQuantidade() + ", Preço: R$ "
                        + l.getPreco() + ")");
            }
        }
        if (disponiveis == 0) {
            System.out.println("Nenhum livro disponível para compra.");
            return;
        }
        System.out.print("Escolha o livro: ");
        int idx = input.nextInt();
        input.nextLine();
        if (idx < 1 || idx > disponiveis) {
            System.out.println("Opção inválida.");
            return;
        }
        Livro selecionado = null;
        int contador = 0;
        for (Livro l : estoqueLivros) {
            if (l.getQuantidade() > 0) {
                contador++;
                if (contador == idx) {
                    selecionado = l;
                    break;
                }
            }
        }
        System.out.print("Quantidade: ");
        int qtd = input.nextInt();
        input.nextLine();
        if (qtd <= 0 || qtd > selecionado.getQuantidade()) {
            System.out.println("Quantidade inválida.");
            return;
        }
        carrinho.adicionarLivro(selecionado, qtd);
        selecionado.setQuantidade(selecionado.getQuantidade() - qtd);
        System.out.println(qtd + "x '" + selecionado.getNome() + "' adicionado ao carrinho!");
    }

    public void removerDoCarrinho(CarrinhoCompras carrinho) {
        if (carrinho.estaVazio()) {
            System.out.println("Carrinho vazio.");
            return;
        }
        for (int i = 0; i < carrinho.getTamanho(); i++) {
            Livro l = carrinho.getLivro(i);
            System.out.println((i + 1) + " - " + l.getNome() + " (Qtd: " + carrinho.getQuantidade(i) + ")");
        }
        System.out.print("Escolha o livro para remover: ");
        int idx = input.nextInt() - 1;
        input.nextLine();
        if (idx < 0 || idx >= carrinho.getTamanho()) {
            System.out.println("Opção inválida.");
            return;
        }
        System.out.print("Quantidade a remover: ");
        int qtd = input.nextInt();
        input.nextLine();
        carrinho.removerLivro(idx, qtd);
        System.out.println("Livro removido do carrinho.");
    }

    public void mostrarCarrinho(CarrinhoCompras carrinho) {
        if (carrinho.estaVazio()) {
            System.out.println("Carrinho vazio.");
            return;
        }
        System.out.println("=== Itens no Carrinho ===");
        for (int i = 0; i < carrinho.getTamanho(); i++) {
            Livro l = carrinho.getLivro(i);
            System.out.println((i + 1) + " - " + l.getNome() + " (Qtd: " + carrinho.getQuantidade(i) + ", R$ "
                    + l.getPreco() + ")");
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