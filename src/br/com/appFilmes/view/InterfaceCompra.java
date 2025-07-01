package br.com.appFilmes.view;

import java.util.List;
import java.util.Scanner;
import br.com.appFilmes.model.Filme;
import br.com.appFilmes.service.CarrinhoCompras;

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
        System.out.println("|  1 - Adicionar filmes ao carrinho                            |");
        System.out.println("|  2 - Remover filme do carrinho                               |");
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

    public void adicionarAoCarrinho(List<Filme> estoqueFilmes, CarrinhoCompras carrinho) {
        if (estoqueFilmes.isEmpty()) {
            System.out.println("Estoque vazio.");
            return;
        }
        System.out.println("Filmes disponíveis:");
        int disponiveis = 0;
        for (int i = 0; i < estoqueFilmes.size(); i++) {
            Filme f = estoqueFilmes.get(i);
            if (f.getQuantidade() > 0) {
                disponiveis++;
                System.out.println(disponiveis + " - " + f.getTitulo() + " (Qtd: " + f.getQuantidade() + ", Preço: R$ "
                        + f.getPreco() + ")");
            }
        }
        if (disponiveis == 0) {
            System.out.println("Nenhum filme disponível para compra.");
            return;
        }
        System.out.print("Escolha o filme: ");
        int idx = input.nextInt();
        input.nextLine();
        if (idx < 1 || idx > disponiveis) {
            System.out.println("Opção inválida.");
            return;
        }
        Filme selecionado = null;
        int contador = 0;
        for (Filme f : estoqueFilmes) {
            if (f.getQuantidade() > 0) {
                contador++;
                if (contador == idx) {
                    selecionado = f;
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
        carrinho.adicionarFilme(selecionado, qtd);
        selecionado.setQuantidade(selecionado.getQuantidade() - qtd);
        System.out.println(qtd + "x '" + selecionado.getTitulo() + "' adicionado ao carrinho!");
    }

    public void removerDoCarrinho(CarrinhoCompras carrinho) {
        if (carrinho.estaVazio()) {
            System.out.println("Carrinho vazio.");
            return;
        }
        for (int i = 0; i < carrinho.getTamanho(); i++) {
            Filme f = carrinho.getFilme(i);
            System.out.println((i + 1) + " - " + f.getTitulo() + " (Qtd: " + carrinho.getQuantidade(i) + ")");
        }
        System.out.print("Escolha o filme para remover: ");
        int idx = input.nextInt() - 1;
        input.nextLine();
        if (idx < 0 || idx >= carrinho.getTamanho()) {
            System.out.println("Opção inválida.");
            return;
        }
        System.out.print("Quantidade a remover: ");
        int qtd = input.nextInt();
        input.nextLine();
        carrinho.removerFilme(idx, qtd);
        System.out.println("Filme removido do carrinho.");
    }

    public void mostrarCarrinho(CarrinhoCompras carrinho) {
        if (carrinho.estaVazio()) {
            System.out.println("Carrinho vazio.");
            return;
        }
        System.out.println("=== Itens no Carrinho ===");
        for (int i = 0; i < carrinho.getTamanho(); i++) {
            Filme f = carrinho.getFilme(i);
            System.out.println((i + 1) + " - " + f.getTitulo() + " (Qtd: " + carrinho.getQuantidade(i) + ", R$ "
                    + f.getPreco() + ")");
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