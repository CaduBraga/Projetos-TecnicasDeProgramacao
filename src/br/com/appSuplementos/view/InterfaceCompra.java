package br.com.appSuplementos.view;

import br.com.appSuplementos.model.Suplemento;
import br.com.appSuplementos.service.CarrinhoCompras;
import java.util.List;
import java.util.Scanner;

public class InterfaceCompra {
    Scanner input;

    public InterfaceCompra() {
        input = new Scanner(System.in);
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public int menuCarrinho() {
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|                    CARRINHO DE COMPRAS                       |");
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|  O que você deseja fazer?                                    |");
        System.out.println("|                                                              |");
        System.out.println("|  1 - Adicionar suplementos ao carrinho                       |");
        System.out.println("|  2 - Remover suplemento do carrinho                          |");
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

    public void adicionarAoCarrinho(List<Suplemento> estoqueSuplementos, CarrinhoCompras carrinho) {
        if (estoqueSuplementos.isEmpty()) {
            System.out.println("+--------------------------------------------------------------+");
            System.out.println("|                    ESTOQUE VAZIO                             |");
            System.out.println("+--------------------------------------------------------------+");
            System.out.println("|  Não há suplementos disponíveis para comprar.                |");
            System.out.println("|  Adicione suplementos ao estoque primeiro!                   |");
            System.out.println("+--------------------------------------------------------------+");
            return;
        }
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|                    ADICIONAR AO CARRINHO                     |");
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("    Suplementos disponíveis:");
        int suplementosDisponiveis = 0;
        for (int i = 0; i < estoqueSuplementos.size(); i++) {
            Suplemento s = estoqueSuplementos.get(i);
            if (s.getQuantidade() > 0) {
                suplementosDisponiveis++;
                String suplementoInfo = String.format("   %d - %s (Qtd: %d, Preço: R$ %.2f)",
                        suplementosDisponiveis, s.getNome(), s.getQuantidade(), s.getPreco());
                System.out.println(suplementoInfo);
            }
        }
        if (suplementosDisponiveis == 0) {
            System.out.println("   Nenhum suplemento disponível para compra no momento.");
            System.out.println("+--------------------------------------------------------------+");
            return;
        }
        System.out.println("+--------------------------------------------------------------+");
        System.out.print("  Escolha o suplemento (número): ");
        int escolhaSuplemento = input.nextInt();
        input.nextLine();
        if (escolhaSuplemento < 1 || escolhaSuplemento > suplementosDisponiveis) {
            System.out.println("+--------------------------------------------------------------+");
            System.out.println("|                    OPÇÃO INVÁLIDA                            |");
            System.out.println("+--------------------------------------------------------------+");
            System.out.println("   Por favor, escolha um número entre 1 e " + suplementosDisponiveis);
            System.out.println("+--------------------------------------------------------------+");
            return;
        }

        Suplemento selecionado = null;
        int contador = 0;
        for (int i = 0; i < estoqueSuplementos.size(); i++) {
            Suplemento s = estoqueSuplementos.get(i);
            if (s.getQuantidade() > 0) {
                contador++;
                if (contador == escolhaSuplemento) {
                    selecionado = s;
                    break;
                }
            }
        }
        System.out.print("  Digite a quantidade que deseja comprar: ");
        int qtd = input.nextInt();
        input.nextLine();
        if (qtd <= 0 || qtd > selecionado.getQuantidade()) {
            System.out.println("+--------------------------------------------------------------+");
            System.out.println("|                    QUANTIDADE INVÁLIDA                       |");
            System.out.println("+--------------------------------------------------------------+");
            System.out.println("   Quantidade disponível: " + selecionado.getQuantidade());
            System.out.println("+--------------------------------------------------------------+");
            return;
        }
        carrinho.adicionarSuplemento(selecionado, qtd);
        selecionado.setQuantidade(selecionado.getQuantidade() - qtd);
        Suplemento.removerSuplementos(qtd);
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|                    SUPLEMENTO ADICIONADO                     |");
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("   " + qtd + "x " + selecionado.getNome() + " adicionado ao carrinho!");
        System.out.println("+--------------------------------------------------------------+");
    }

    public void removerDoCarrinho(CarrinhoCompras carrinho) {
        if (carrinho.estaVazio()) {
            System.out.println("+--------------------------------------------------------------+");
            System.out.println("|                    CARRINHO VAZIO                            |");
            System.out.println("+--------------------------------------------------------------+");
            System.out.println("|  Não há suplementos no carrinho para remover.                |");
            System.out.println("+--------------------------------------------------------------+");
            return;
        }
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|                    REMOVER DO CARRINHO                       |");
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("   Suplementos no carrinho:");
        for (int i = 0; i < carrinho.getTamanho(); i++) {
            String suplementoInfo = String.format("   %d - %s (Qtd: %d)",
                    i + 1, carrinho.getSuplemento(i).getNome(), carrinho.getQuantidade(i));
            System.out.println(suplementoInfo);
        }
        System.out.println("+--------------------------------------------------------------+");
        System.out.print("  Escolha o suplemento para remover: ");
        int escolhaRemover = input.nextInt();
        input.nextLine();
        if (escolhaRemover < 1 || escolhaRemover > carrinho.getTamanho()) {
            System.out.println("+--------------------------------------------------------------+");
            System.out.println("|                    OPÇÃO INVÁLIDA                            |");
            System.out.println("+--------------------------------------------------------------+");
            System.out.println("   Por favor, escolha um número entre 1 e " + carrinho.getTamanho());
            System.out.println("+--------------------------------------------------------------+");
            return;
        }
        int indexRemover = escolhaRemover - 1;
        Suplemento supRemover = carrinho.getSuplemento(indexRemover);
        int qtdCarrinho = carrinho.getQuantidade(indexRemover);
        System.out.print("  Quantas unidades deseja remover? (máximo: " + qtdCarrinho + "): ");
        int qtdRemover = input.nextInt();
        input.nextLine();
        if (qtdRemover <= 0 || qtdRemover > qtdCarrinho) {
            System.out.println("+--------------------------------------------------------------+");
            System.out.println("|                    QUANTIDADE INVÁLIDA                       |");
            System.out.println("+--------------------------------------------------------------+");
            System.out.println("   Por favor, escolha uma quantidade entre 1 e " + qtdCarrinho);
            System.out.println("+--------------------------------------------------------------+");
            return;
        }
        supRemover.setQuantidade(supRemover.getQuantidade() + qtdRemover);
        Suplemento.adicionarSuplementos(qtdRemover);
        carrinho.removerSuplemento(indexRemover, qtdRemover);
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|                    SUPLEMENTO REMOVIDO                       |");
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("   " + qtdRemover + "x " + supRemover.getNome() + " removido do carrinho!");
        System.out.println("+--------------------------------------------------------------+");
    }

    public void mostrarCarrinho(CarrinhoCompras carrinho) {
        if (carrinho.estaVazio()) {
            System.out.println("+--------------------------------------------------------------+");
            System.out.println("|                    CARRINHO VAZIO                            |");
            System.out.println("+--------------------------------------------------------------+");
            System.out.println("|  Seu carrinho de compras está vazio.                         |");
            System.out.println("|  Adicione alguns suplementos para começar!                   |");
            System.out.println("+--------------------------------------------------------------+");
        } else {
            System.out.println("+--------------------------------------------------------------+");
            System.out.println("|                    SEU CARRINHO                              |");
            System.out.println("+--------------------------------------------------------------+");
            System.out.println("   Suplementos no carrinho:");
            for (int i = 0; i < carrinho.getTamanho(); i++) {
                Suplemento s = carrinho.getSuplemento(i);
                int qtd = carrinho.getQuantidade(i);
                double valor = s.getPreco() * qtd;
                String itemInfo = String.format("   %d - %s - Qtd: %d - R$ %.2f",
                        i + 1, s.getNome(), qtd, valor);
                System.out.println(itemInfo);
            }
            System.out.println("+--------------------------------------------------------------+");
            String totalInfo = String.format("   Total do carrinho: R$ %.2f", carrinho.getTotalCarrinho());
            System.out.println(totalInfo);
            System.out.println("+--------------------------------------------------------------+");
        }
    }

    public void finalizarCompra(CarrinhoCompras carrinho) {
        if (carrinho.estaVazio()) {
            System.out.println("Nenhum suplemento foi selecionado para compra.");
            return;
        }
        System.out.println("\nResumo da compra:");
        for (int i = 0; i < carrinho.getTamanho(); i++) {
            Suplemento s = carrinho.getSuplemento(i);
            int qtd = carrinho.getQuantidade(i);
            double valor = s.getPreco() * qtd;
            System.out.println(s.getNome() + " - Quantidade: " + qtd + " - Valor: R$ " + String.format("%.2f", valor));
        }
        System.out.println("Total da compra: R$ " + String.format("%.2f", carrinho.getTotalCarrinho()));
        System.out.println("Escolha o método de pagamento:");
        System.out.println("1 - Dinheiro");
        System.out.println("2 - Cartão");
        System.out.print("> ");
        int metodo = input.nextInt();
        input.nextLine();
        while (metodo != 1 && metodo != 2) {
            System.out.println("\nOpção inválida, escolha 1 para Dinheiro ou 2 para Cartão.");
            System.out.print("> ");
            metodo = input.nextInt();
            input.nextLine();
        }
        if (metodo == 1) {
            System.out.print("Digite o valor pago: R$ ");
            double pago = input.nextDouble();
            input.nextLine();
            if (pago < carrinho.getTotalCarrinho()) {
                System.out.println("Valor insuficiente! Compra cancelada.");
                carrinho.restaurarEstoque();
                carrinho.limparCarrinho();
                return;
            }
            double troco = pago - carrinho.getTotalCarrinho();
            System.out.println("Troco: R$ " + String.format("%.2f", troco));
        } else {
            System.out.println("Pagamento realizado com sucesso!");
        }
        System.out.println("Compra finalizada. Obrigado!");
        carrinho.limparCarrinho();
    }
}