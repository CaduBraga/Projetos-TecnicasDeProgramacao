package br.com.appFrutaria.view;

import br.com.appFrutaria.model.*;
import br.com.appFrutaria.model.verduras.*;
import java.util.List;
import java.util.Scanner;

public class Interface {
    Scanner input;

    public Interface() {
        input = new Scanner(System.in);
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public static void mensagemInicial() {
        System.out.println("=== BEM-VINDO AO SISTEMA DE GESTÃO DA FRUTARIA ===");
        System.out.println();
    }

    public Produto cadastrar() {
        int tipo = Menus.menuTipoProduto();
        System.out.print("Digite o nome: ");
        String nome = input.nextLine();
        System.out.print("Digite o preço: ");
        double preco = input.nextDouble();
        System.out.print("Digite a quantidade em estoque: ");
        int quantidade = input.nextInt();
        input.nextLine();
        Produto produto;
        switch (tipo) {
            case 1:
                System.out.print("Digite o peso da fruta: ");
                double peso = input.nextDouble();
                input.nextLine();
                produto = new Fruta(peso, 0);
                Fruta.adicionarFrutas(quantidade);
                break;
            case 2:
                System.out.println("Escolha o tipo da verdura:");
                System.out.println("1 - Legume");
                System.out.println("2 - Tubérculo");
                System.out.println("3 - Raiz");
                System.out.println("4 - Cereal");
                System.out.println("5 - Oleagionsa");
                System.out.println("6 - Condimento");
                System.out.print("> ");
                int tipoVerduraId = input.nextInt();
                input.nextLine();
                TipoVerdura tipoVerdura;
                switch (tipoVerduraId) {
                    case 1:
                        tipoVerdura = TipoVerdura.LEGUME;
                        break;
                    case 2:
                        tipoVerdura = TipoVerdura.TUBERCULO;
                        break;
                    case 3:
                        tipoVerdura = TipoVerdura.RAIZ;
                        break;
                    case 4:
                        tipoVerdura = TipoVerdura.CEREAL;
                        break;
                    case 5:
                        tipoVerdura = TipoVerdura.OLEAGINOSA;
                        break;
                    case 6:
                        tipoVerdura = TipoVerdura.CONDIMENTO;
                        break;
                    default:
                        return null;
                    }
                produto = new Verdura(tipoVerdura, 0);
                Verdura.adicionarVerduras(quantidade);
                break;
            default:
                return null;
        }
        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setQuantidade(quantidade);
        Produto.adicionarProdutos(quantidade);
        System.out.println("Produto '" + nome + "' adicionado com sucesso!");
        System.out.println("Total de produtos na frutaria: " + Produto.getTotalProdutos());
        return produto;
    }

    public void detalhar(List<Produto> estoqueProdutos) {
        if (estoqueProdutos.isEmpty()) {
            System.out.println("O estoque está vazio.");
            return;
        }
        System.out.println("Produtos disponíveis:");
        for (int i = 0; i < estoqueProdutos.size(); i++) {
            System.out.println((i + 1) + " - " + estoqueProdutos.get(i).getNome() + " (Quantidade: "
                    + estoqueProdutos.get(i).getQuantidade() + ")");
        }
        System.out.println("Digite o número do produto para ver os detalhes:");
        System.out.print("> ");
        int escolha = input.nextInt();
        input.nextLine();
        if (escolha > 0 && escolha <= estoqueProdutos.size()) {
            Produto produtoEscolhido = estoqueProdutos.get(escolha - 1);
            System.out.println("--------------------------");
            System.out.println("Detalhes do produto escolhido:");
            System.out.println("Nome: " + produtoEscolhido.getNome());
            System.out.println("Preço: R$ " + String.format("%.2f", produtoEscolhido.getPreco()));
            System.out.println("Quantidade em estoque: " + produtoEscolhido.getQuantidade());
            System.out.println("Total de produtos na frutaria: " + Produto.getTotalProdutos());
        } else {
            System.out.println("Opção inválida. Escolha um número entre 1 e " + estoqueProdutos.size() + ".");
        }
    }

    public void remover(List<Produto> estoqueProdutos) {
        if (estoqueProdutos.isEmpty()) {
            System.out.println("O estoque está vazio.");
            return;
        }
        System.out.println("Produtos disponíveis:");
        for (int i = 0; i < estoqueProdutos.size(); i++) {
            System.out.println((i + 1) + " - " + estoqueProdutos.get(i).getNome() + " (Quantidade: "
                    + estoqueProdutos.get(i).getQuantidade() + ")");
        }
        System.out.println("Digite o número do produto que deseja remover: ");
        System.out.print("> ");
        int escolha = input.nextInt();
        input.nextLine();
        if (escolha > 0 && escolha <= estoqueProdutos.size()) {
            Produto selecionado = estoqueProdutos.get(escolha - 1);
            System.out.println("Estão disponíveis " + selecionado.getQuantidade() + " unidades do produto '"
                    + selecionado.getNome() + "'. Quantas você deseja remover?");
            System.out.print("> ");
            int quantidadeRemovida = input.nextInt();
            input.nextLine();
            if (quantidadeRemovida > 0 && quantidadeRemovida <= selecionado.getQuantidade()) {
                selecionado.setQuantidade(selecionado.getQuantidade() - quantidadeRemovida);
                Produto.removerProdutos(quantidadeRemovida);
                System.out.println("Foram removidas " + quantidadeRemovida + " unidades do produto '"
                        + selecionado.getNome() + "'.");
                System.out.println("Quantidade restante deste produto: " + selecionado.getQuantidade());
                System.out.println("Total de produtos na frutaria: " + Produto.getTotalProdutos());
                if (selecionado.getQuantidade() == 0) {
                    estoqueProdutos.remove(escolha - 1);
                    System.out
                            .println("Todos os exemplares deste produto foram removidos. Produto retirado do estoque.");
                }
            } else {
                System.out.println("Quantidade inválida para remoção.");
            }
        } else {
            System.out.println("Opção inválida. Escolha um número entre 1 e " + estoqueProdutos.size() + ".");
        }
    }

    public void encerrar() {
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|                                                              |");
        System.out.println("|  ENCERRANDO O SISTEMA                                         |");
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|  Salvando dados...                                            |");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("|  Sistema encerrado com sucesso!                             |");
        System.out.println("|  Obrigado por usar o Sistema de Gestão da Frutaria!         |");
        System.out.println("|  Até a próxima!                                             |");
        System.out.println("+--------------------------------------------------------------+");
        System.exit(0);
    }
}