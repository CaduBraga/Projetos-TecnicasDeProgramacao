package br.com.appSuplementos.view;

import br.com.appSuplementos.model.Suplemento;
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
        System.out.println("=== Bem-vindo ao App Suplementos ===");
    }

    public int menuPrincipal() {
        System.out.println("--------------------------");
        System.out.println("O que você deseja fazer?");
        System.out.println("1 - Cadastrar suplementos");
        System.out.println("2 - Ver suplementos");
        System.out.println("3 - Remover suplementos");
        System.out.println("4 - Editar suplementos");
        System.out.println("5 - Iniciar compras");
        System.out.println("6 - Relatório de suplementos");
        System.out.println("7 - Sair do programa");
        System.out.println("Digite sua escolha abaixo:");
        System.out.print("> ");
        int escolha = input.nextInt();
        input.nextLine();
        System.out.println("--------------------------");
        if (escolha < 1 || escolha > 7) {
            System.out.println("\nOpção inválida, escolha um número de 1 a 7.");
            return menuPrincipal();
        }
        return escolha;
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

    public Suplemento cadastrar() {
        System.out.print("Digite o nome do suplemento: ");
        String nome = input.nextLine();

        System.out.print("Digite o preço do suplemento: ");
        double preco = input.nextDouble();
        input.nextLine();

        System.out.print("Digite a quantidade em estoque: ");
        int quantidade = input.nextInt();
        input.nextLine();

        System.out.print("Digite a marca do suplemento: ");
        String marca = input.nextLine();

        Suplemento.adicionarSuplementos(quantidade);

        Suplemento suplemento = new Suplemento(nome, preco, quantidade, marca);

        System.out.println("Suplemento '" + nome + "' cadastrado com sucesso!");
        System.out.println("Total de suplementos na loja: " + Suplemento.getTotalSuplementos());

        return suplemento;
    }

    public void detalhar(List<Suplemento> estoqueSuplemento) {
        if (estoqueSuplemento.isEmpty()) {
            System.out.println("O estoque de suplementos está vazio.");
            return;
        } else {
            System.out.println("Suplementos disponíveis:");
            for (int i = 0; i < estoqueSuplemento.size(); i++) {
                System.out.println((i + 1) + " - " + estoqueSuplemento.get(i).getNome() + " (Quantidade: "
                        + estoqueSuplemento.get(i).getQuantidade() + ")");
            }

            System.out.println("Digite o número do suplemento para ver os detalhes:");
            System.out.print("> ");
            int escolhaSuplemento = input.nextInt();
            input.nextLine();

            if (escolhaSuplemento > 0 && escolhaSuplemento <= estoqueSuplemento.size()) {
                Suplemento suplementoEscolhido = estoqueSuplemento.get(escolhaSuplemento - 1);
                System.out.println("--------------------------");
                System.out.println("Detalhes do suplemento escolhido:");
                System.out.println("Nome: " + suplementoEscolhido.getNome());
                System.out.println("Preço: R$ " + String.format("%.2f", suplementoEscolhido.getPreco()));
                System.out.println("Quantidade em estoque: " + suplementoEscolhido.getQuantidade());
                System.out.println("Marca: " + suplementoEscolhido.getMarca());
                System.out.println("Total de suplementos na loja: " + suplementoEscolhido.getTotalSuplementos());
            } else {
                System.out.println("Opção inválida. Escolha um número entre 1 e " + estoqueSuplemento.size() + ".");
            }
        }
    }

    public void remover(List<Suplemento> estoqueSuplemento) {
        if (estoqueSuplemento.isEmpty()) {
            System.out.println("O estoque de suplementos está vazio.");
            return;
        }
        System.out.println("Suplementos disponíveis:");
        for (int i = 0; i < estoqueSuplemento.size(); i++) {
            System.out.println((i + 1) + " - " + estoqueSuplemento.get(i).getNome() + " (Quantidade: "
                    + estoqueSuplemento.get(i).getQuantidade() + ")");
        }
        System.out.println("Digite o número do suplemento que deseja remover: ");
        System.out.print("> ");
        int escolha = input.nextInt();
        input.nextLine();
        System.out.println("--------------------------");

        if (escolha > 0 && escolha <= estoqueSuplemento.size()) {
            Suplemento selecionado = estoqueSuplemento.get(escolha - 1);
            System.out.println("Estão disponíveis " + selecionado.getQuantidade() + " unidades do suplemento '"
                    + selecionado.getNome() + "'. Quantas você deseja remover?");
            System.out.print("> ");
            int quantidadeRemovida = input.nextInt();
            input.nextLine();

            if (quantidadeRemovida > 0 && quantidadeRemovida <= selecionado.getQuantidade()) {
                selecionado.setQuantidade(selecionado.getQuantidade() - quantidadeRemovida);
                Suplemento.removerSuplementos(quantidadeRemovida);

                System.out.println("Foram removidas " + quantidadeRemovida + " unidades do suplemento '"
                        + selecionado.getNome() + "'.");
                System.out.println("Quantidade restante deste suplemento: " + selecionado.getQuantidade());
                System.out.println("Total de suplementos na loja: " + Suplemento.getTotalSuplementos());

                if (selecionado.getQuantidade() == 0) {
                    estoqueSuplemento.remove(escolha - 1);
                    System.out.println(
                            "Todos os exemplares deste suplemento foram removidos. Suplemento retirado do estoque.");
                }
            } else {
                System.out.println("Quantidade inválida para remoção.");
            }
        } else {
            System.out.println("Opção inválida. Escolha um número entre 1 e " + estoqueSuplemento.size() + ".");
        }
    }

    public void editar(List<Suplemento> estoqueSuplemento) {
        if (estoqueSuplemento.isEmpty()) {
            System.out.println("O estoque de suplementos está vazio.");
            return;
        }
        System.out.println("Suplementos disponíveis:");
        for (int i = 0; i < estoqueSuplemento.size(); i++) {
            System.out.println((i + 1) + " - " + estoqueSuplemento.get(i).getNome());
        }

        System.out.println("Digite o número do suplemento que deseja editar: ");
        System.out.print("> ");
        int escolha = input.nextInt();
        input.nextLine();
        System.out.println("--------------------------");
        if (escolha > 0 && escolha <= estoqueSuplemento.size()) {
            Suplemento suplemento = estoqueSuplemento.get(escolha - 1);
            System.out.println("O que deseja editar?");
            System.out.println("1 - Nome");
            System.out.println("2 - Preço");
            System.out.println("3 - Quantidade");
            System.out.println("4 - Marca");
            System.out.print("> ");
            int opcaoEdicao = input.nextInt();
            input.nextLine();
            System.out.println("--------------------------");
            switch (opcaoEdicao) {
                case 1:
                    Editar.editarNome(suplemento);
                    break;
                case 2:
                    Editar.editarPreco(suplemento);
                    break;
                case 3:
                    Editar.editarQuantidade(suplemento);
                    break;
                case 4:
                    Editar.editarMarca(suplemento);
                    break;
                default:
                    System.out.println("Opção inválida. Escolha um número entre 1 e 4.");
            }
        } else {
            System.out.println("Opção inválida. Escolha um número entre 1 e " + estoqueSuplemento.size() + ".");
        }
    }

    public void encerrar() {
        System.out.println("Obrigado por usar o App Suplementos!");
        System.out.println("Programa encerrado.");
    }
}