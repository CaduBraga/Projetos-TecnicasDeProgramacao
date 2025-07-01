package br.com.appFrutaria.view;

import br.com.appFrutaria.model.*;
import br.com.appFrutaria.model.verduras.*;
import java.util.List;
import java.util.Scanner;

public class Editar {
    static Scanner input = new Scanner(System.in);

    public static void editarNome(Produto produto) {
        System.out.print("Digite o novo nome: ");
        String novoNome = input.nextLine();
        produto.setNome(novoNome);
        System.out.println("Nome atualizado com sucesso!");
    }

    public static void editarPreco(Produto produto) {
        System.out.print("Digite o novo preço: ");
        double novoPreco = input.nextDouble();
        input.nextLine();
        produto.setPreco(novoPreco);
        System.out.println("Preço atualizado com sucesso!");
    }

    public static void editarQuantidade(Produto produto) {
        System.out.print("Digite a nova quantidade: ");
        int novaQuantidade = input.nextInt();
        input.nextLine();
        int quantidadeAntiga = produto.getQuantidade();
        int diferenca = novaQuantidade - quantidadeAntiga;
        produto.setQuantidade(novaQuantidade);
        if (diferenca > 0) {
            Produto.adicionarProdutos(diferenca);
        } else if (diferenca < 0) {
            Produto.removerProdutos(-diferenca);
        }
        System.out.println("Quantidade atualizada com sucesso!");
        System.out.println("Total de produtos na frutaria: " + Produto.getTotalProdutos());
    }

    public static void editarPeso(Fruta fruta) {
        System.out.print("Digite o novo peso: ");
        double novoPeso = input.nextDouble();
        input.nextLine();
        fruta.setPeso(novoPeso);
        System.out.println("Peso atualizado com sucesso!");
    }

    public static void editarTipoVerdura(Verdura verdura) {
        System.out.println("Escolha o novo tipo da verdura:");
        System.out.println("1 - Legume");
        System.out.println("2 - Tubérculo");
        System.out.println("3 - Raiz");
        System.out.println("4 - Cereal");
        System.out.println("5 - Oleagionsa");
        System.out.println("6 - Condimento");
        System.out.print("> ");
        int tipoId = input.nextInt();
        input.nextLine();
        switch (tipoId) {
            case 1:
                verdura.setTipo(TipoVerdura.LEGUME);
                break;
            case 2:
                verdura.setTipo(TipoVerdura.TUBERCULO);
                break;
            case 3:
                verdura.setTipo(TipoVerdura.RAIZ);
                break;
            case 4:
                verdura.setTipo(TipoVerdura.CEREAL);
                break;
            case 5:
                verdura.setTipo(TipoVerdura.OLEAGINOSA);
                break;
            case 6:
                verdura.setTipo(TipoVerdura.CONDIMENTO);
                break;
        }
        System.out.println("Tipo da verdura atualizado com sucesso!");
    }

    public static void editar(List<Produto> estoqueProdutos) {
        if (estoqueProdutos.isEmpty()) {
            System.out.println("O estoque está vazio.");
            return;
        }
        System.out.println("Produtos disponíveis:");
        for (int i = 0; i < estoqueProdutos.size(); i++) {
            System.out.println((i + 1) + " - " + estoqueProdutos.get(i).getNome());
        }
        System.out.println("Digite o número do produto que deseja editar: ");
        System.out.print("> ");
        int escolha = input.nextInt();
        input.nextLine();
        if (escolha > 0 && escolha <= estoqueProdutos.size()) {
            Produto produto = estoqueProdutos.get(escolha - 1);
            System.out.println("O que deseja editar?");
            System.out.println("1 - Nome");
            System.out.println("2 - Preço");
            System.out.println("3 - Quantidade");
            System.out.println("4 - Peso (apenas para frutas)");
            System.out.println("5 - Tipo (apenas para verduras)");
            System.out.print("> ");
            int opcaoEdicao = input.nextInt();
            input.nextLine();
            switch (opcaoEdicao) {
                case 1:
                    editarNome(produto);
                    break;
                case 2:
                    editarPreco(produto);
                    break;
                case 3:
                    editarQuantidade(produto);
                    break;
                case 4:
                    if (produto instanceof Fruta) {
                        editarPeso((Fruta) produto);
                    } else {
                        System.out.println("Erro: Só é possível editar o peso de frutas.");
                    }
                    break;
                case 5:
                    if (produto instanceof Verdura) {
                        editarTipoVerdura((Verdura) produto);
                    } else {
                        System.out.println("Erro: Só é possível editar o tipo de verduras.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Escolha um número entre 1 e 5.");
            }
        } else {
            System.out.println("Número inválido.");
        }
    }
}