package br.com.appFrutaria.view;

import java.util.List;
import java.util.Scanner;
import br.com.appFrutaria.model.Produto;
import br.com.appFrutaria.service.CarrinhoCompras;

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
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    🛒 CARRINHO DE COMPRAS                    ║");
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        System.out.println("║  O que você deseja fazer?                                   ║");
        System.out.println("║                                                              ║");
        System.out.println("║  1 ➤ Adicionar itens ao carrinho                           ║");
        System.out.println("║  2 ➤ Remover produto do carrinho                           ║");
        System.out.println("║  3 ➤ Ver carrinho                                          ║");
        System.out.println("║  4 ➤ Finalizar compra                                      ║");
        System.out.println("║  5 ➤ Voltar ao menu principal                              ║");
        System.out.println("║                                                              ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.print("  Digite sua escolha: ");
        int escolha = input.nextInt();
        input.nextLine();
        System.out.println();
        return escolha;
    }

    public void adicionarAoCarrinho(List<Produto> estoqueProdutos, CarrinhoCompras carrinho) {
        if (estoqueProdutos.isEmpty()) {
            System.out.println("╔══════════════════════════════════════════════════════════════╗");
            System.out.println("║                    ⚠️  ESTOQUE VAZIO                         ║");
            System.out.println("╠══════════════════════════════════════════════════════════════╣");
            System.out.println("║  Não há produtos disponíveis para comprar.                  ║");
            System.out.println("║  Adicione produtos ao estoque primeiro!                     ║");
            System.out.println("╚══════════════════════════════════════════════════════════════╝");
            return;
        }
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    🛒 ADICIONAR AO CARRINHO                   ║");
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        System.out.println("║  Produtos disponíveis:                                       ║");
        for (int i = 0; i < estoqueProdutos.size(); i++) {
            Produto p = estoqueProdutos.get(i);
            String produtoInfo = String.format("║  %d ➤ %s (Qtd: %d, Preço: R$ %.2f)", 
                i + 1, p.getNome(), p.getQuantidade(), p.getPreco());
            System.out.println(produtoInfo);
        }
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.print("  Escolha o produto (número): ");
        int escolhaProduto = input.nextInt();
        input.nextLine();
        if (escolhaProduto < 1 || escolhaProduto > estoqueProdutos.size()) {
            System.out.println("╔══════════════════════════════════════════════════════════════╗");
            System.out.println("║                    ❌ OPÇÃO INVÁLIDA                         ║");
            System.out.println("╠══════════════════════════════════════════════════════════════╣");
            System.out.println("║  Por favor, escolha um número entre 1 e " + estoqueProdutos.size() + ".                    ║");
            System.out.println("╚══════════════════════════════════════════════════════════════╝");
            return;
        }
        Produto selecionado = estoqueProdutos.get(escolhaProduto - 1);
        System.out.print("  Digite a quantidade que deseja comprar: ");
        int qtd = input.nextInt();
        input.nextLine();
        if (qtd <= 0 || qtd > selecionado.getQuantidade()) {
            System.out.println("╔══════════════════════════════════════════════════════════════╗");
            System.out.println("║                    ❌ QUANTIDADE INVÁLIDA                    ║");
            System.out.println("╠══════════════════════════════════════════════════════════════╣");
            System.out.println("║  Quantidade disponível: " + selecionado.getQuantidade() + " unidades.                        ║");
            System.out.println("╚══════════════════════════════════════════════════════════════╝");
            return;
        }
        carrinho.adicionarProduto(selecionado, qtd);
        selecionado.setQuantidade(selecionado.getQuantidade() - qtd);
        Produto.removerProdutos(qtd);
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    ✅ PRODUTO ADICIONADO                      ║");
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        System.out.println("║  " + qtd + "x " + selecionado.getNome() + " adicionado ao carrinho!                    ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
    }

    public void removerDoCarrinho(CarrinhoCompras carrinho) {
        if (carrinho.estaVazio()) {
            System.out.println("╔══════════════════════════════════════════════════════════════╗");
            System.out.println("║                    🛒 CARRINHO VAZIO                        ║");
            System.out.println("╠══════════════════════════════════════════════════════════════╣");
            System.out.println("║  Não há produtos no carrinho para remover.                  ║");
            System.out.println("╚══════════════════════════════════════════════════════════════╝");
            return;
        }
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    🗑️  REMOVER DO CARRINHO                     ║");
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        System.out.println("║  Produtos no carrinho:                                       ║");
        for (int i = 0; i < carrinho.getTamanho(); i++) {
            String produtoInfo = String.format("║  %d ➤ %s (Qtd: %d)", 
                i + 1, carrinho.getProduto(i).getNome(), carrinho.getQuantidade(i));
            System.out.println(produtoInfo);
        }
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.print("  Escolha o produto para remover: ");
        int escolhaRemover = input.nextInt();
        input.nextLine();
        if (escolhaRemover < 1 || escolhaRemover > carrinho.getTamanho()) {
            System.out.println("╔══════════════════════════════════════════════════════════════╗");
            System.out.println("║                    ❌ OPÇÃO INVÁLIDA                         ║");
            System.out.println("╠══════════════════════════════════════════════════════════════╣");
            System.out.println("║  Por favor, escolha um número entre 1 e " + carrinho.getTamanho() + ".                    ║");
            System.out.println("╚══════════════════════════════════════════════════════════════╝");
            return;
        }
        int indexRemover = escolhaRemover - 1;
        Produto prodRemover = carrinho.getProduto(indexRemover);
        int qtdCarrinho = carrinho.getQuantidade(indexRemover);
        System.out.print("  Quantas unidades deseja remover? (máximo: " + qtdCarrinho + "): ");
        int qtdRemover = input.nextInt();
        input.nextLine();
        if (qtdRemover <= 0 || qtdRemover > qtdCarrinho) {
            System.out.println("╔══════════════════════════════════════════════════════════════╗");
            System.out.println("║                    ❌ QUANTIDADE INVÁLIDA                    ║");
            System.out.println("╠══════════════════════════════════════════════════════════════╣");
            System.out.println("║  Por favor, escolha uma quantidade entre 1 e " + qtdCarrinho + ".                    ║");
            System.out.println("╚══════════════════════════════════════════════════════════════╝");
            return;
        }
        prodRemover.setQuantidade(prodRemover.getQuantidade() + qtdRemover);
        Produto.adicionarProdutos(qtdRemover);
        carrinho.removerProduto(indexRemover, qtdRemover);
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    ✅ PRODUTO REMOVIDO                        ║");
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        System.out.println("║  " + qtdRemover + "x " + prodRemover.getNome() + " removido do carrinho!                    ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
    }

    // Função auxiliar para preencher espaços (compatível com Java 8)
    private String preencherEspacos(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(' ');
        return sb.toString();
    }

    public void mostrarCarrinho(CarrinhoCompras carrinho) {
        if (carrinho.estaVazio()) {
            System.out.println("╔══════════════════════════════════════════════════════════════╗");
            System.out.println("║                    🛒 CARRINHO VAZIO                        ║");
            System.out.println("╠══════════════════════════════════════════════════════════════╣");
            System.out.println("║  Seu carrinho de compras está vazio.                        ║");
            System.out.println("║  Adicione alguns produtos para começar!                     ║");
            System.out.println("╚══════════════════════════════════════════════════════════════╝");
        } else {
            System.out.println("╔══════════════════════════════════════════════════════════════╗");
            System.out.println("║                    🛒 SEU CARRINHO                           ║");
            System.out.println("╠══════════════════════════════════════════════════════════════╣");
            System.out.println("║  Produtos no carrinho:                                       ║");
            for (int i = 0; i < carrinho.getTamanho(); i++) {
                Produto p = carrinho.getProduto(i);
                int qtd = carrinho.getQuantidade(i);
                double valor = p.getPreco() * qtd;
                String itemInfo = String.format("║  %d ➤ %s - Qtd: %d - R$ %.2f", 
                    i + 1, p.getNome(), qtd, valor);
                System.out.println(itemInfo);
            }
            System.out.println("╠══════════════════════════════════════════════════════════════╣");
            String totalInfo = String.format("║  Total do carrinho: R$ %.2f", carrinho.getTotalCarrinho());
            System.out.println(totalInfo + preencherEspacos(58 - totalInfo.length()) + "║");
            System.out.println("╚══════════════════════════════════════════════════════════════╝");
        }
    }

    public void finalizarCompra(CarrinhoCompras carrinho) {
        if (carrinho.estaVazio()) {
            System.out.println("Nenhum produto foi selecionado para compra.");
            return;
        }
        System.out.println("\nResumo da compra:");
        for (int i = 0; i < carrinho.getTamanho(); i++) {
            Produto p = carrinho.getProduto(i);
            int qtd = carrinho.getQuantidade(i);
            double valor = p.getPreco() * qtd;
            System.out.println(p.getNome() + " - Quantidade: " + qtd + " - Valor: R$ " + String.format("%.2f", valor));
        }
        System.out.println("Total da compra: R$ " + String.format("%.2f", carrinho.getTotalCarrinho()));
        System.out.println("Escolha o método de pagamento:");
        System.out.println("1 - Dinheiro");
        System.out.println("2 - Cartão");
        System.out.print("> ");
        int metodo = input.nextInt();
        input.nextLine();
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