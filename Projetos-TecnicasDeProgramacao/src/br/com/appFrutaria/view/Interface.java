package br.com.appFrutaria.view;

import java.util.List;
import java.util.Scanner;

import br.com.appFrutaria.model.Fruta;

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
        System.out.println("=== Bem-vindo ao App Frutaria ===");
    }

    public int menuPrincipal() {
        System.out.println("--------------------------");
        System.out.println("O que você deseja fazer?");
        System.out.println("1 - Cadastrar frutas");
        System.out.println("2 - Ver frutas");
        System.out.println("3 - Remover frutas");
        System.out.println("4 - Editar frutas");
        System.out.println("5 - Sair do programa");
        System.out.println("Digite sua escolha abaixo:");
        System.out.print("> ");
        int escolha = input.nextInt();
        input.nextLine();
        System.out.println("--------------------------");

        return escolha;
    }

    public Fruta cadastrar() {
        System.out.print("Digite o nome da fruta: ");
        String nome = input.nextLine();

        System.out.print("Digite o preço da fruta: ");
        double preco = input.nextDouble();

        System.out.print("Digite a quantidade em estoque: ");
        int quantidade = input.nextInt();
        input.nextLine();

        Fruta.adicionarFrutas(quantidade);

        Fruta fruta = new Fruta();
        fruta.setNome(nome);
        fruta.setPreco(preco);
        fruta.setQuantidade(quantidade);

        System.out.println("Fruta '" + nome + "' adicionada com sucesso!");
        System.out.println("Total de frutas na frutaria: " + Fruta.getTotalFrutas());

        return fruta;
    }

    public void detalhar(List<Fruta> estoqueFruta) {
        if (estoqueFruta.isEmpty()) {
            System.out.println("O estoque de frutas está vazio.");
            return;
        } else {
            System.out.println("Frutas disponíveis:");
            for (int i = 0; i < estoqueFruta.size(); i++) {
                System.out.println((i + 1) + " - " + estoqueFruta.get(i).getNome() + " (Quantidade: " + estoqueFruta.get(i).getQuantidade() + ")");
            }

            System.out.println("Digite o número da fruta para ver os detalhes:");
            System.out.print("> ");
            int escolhaFruta = input.nextInt();
            input.nextLine();

            if (escolhaFruta > 0 && escolhaFruta <= estoqueFruta.size()) {
                Fruta frutaEscolhida = estoqueFruta.get(escolhaFruta - 1);
                System.out.println("--------------------------");
                System.out.println("Detalhes da fruta escolhida:");
                System.out.println("Nome: " + frutaEscolhida.getNome());
                System.out.println("Preço: R$ " + String.format("%.2f", frutaEscolhida.getPreco()));
                System.out.println("Quantidade em estoque: " + frutaEscolhida.getQuantidade());
                System.out.println("Total de frutas na frutaria: " + frutaEscolhida.getTotalFrutas());
            } else {
                System.out.println("Opção inválida. Escolha um número entre 1 e " + estoqueFruta.size() + ".");
            }
        }
    }

    public void remover(List<Fruta> estoqueFruta) {
        if (estoqueFruta.isEmpty()) {
            System.out.println("O estoque de frutas está vazio.");
            return;
        }
        System.out.println("Frutas disponíveis:");
        for (int i = 0; i < estoqueFruta.size(); i++) {
            System.out.println((i + 1) + " - " + estoqueFruta.get(i).getNome() + " (Quantidade: " + estoqueFruta.get(i).getQuantidade() + ")");
        }

        System.out.println("Digite o número da fruta que deseja remover: ");
        System.out.print("> ");
        int escolha = input.nextInt();
        input.nextLine();
        System.out.println("--------------------------");
        if (escolha > 0 && escolha <= estoqueFruta.size()) {
            Fruta selecionada = estoqueFruta.get(escolha - 1);
            System.out.println("Estão disponíveis " + selecionada.getQuantidade() + " unidades da fruta '" + selecionada.getNome() + "'. Quantas você deseja remover?");
            System.out.print("> ");
            int quantidadeRemovida = input.nextInt();
            input.nextLine();

            if (quantidadeRemovida > 0 && quantidadeRemovida <= selecionada.getQuantidade()) {
                selecionada.setQuantidade(selecionada.getQuantidade() - quantidadeRemovida);
                Fruta.removerFrutas(quantidadeRemovida);

                System.out.println("Foram removidas " + quantidadeRemovida + " unidades da fruta '" + selecionada.getNome() + "'.");
                System.out.println("Quantidade restante desta fruta: " + selecionada.getQuantidade());
                System.out.println("Total de frutas na frutaria: " + Fruta.getTotalFrutas());

                if (selecionada.getQuantidade() == 0) {
                    estoqueFruta.remove(escolha - 1);
                    System.out.println("Todos os exemplares desta fruta foram removidos. Fruta retirada do estoque.");
                }
            } else {
                System.out.println("Quantidade inválida para remoção.");
            }
        } else {
            System.out.println("Opção inválida. Escolha um número entre 1 e " + estoqueFruta.size() + ".");
        }
    }

    public void editar(List<Fruta> estoqueFruta) {

        if (estoqueFruta.isEmpty()) {
            System.out.println("O estoque de frutas está vazio.");
            return;
        }
        System.out.println("Frutas disponíveis:");
        for (int i = 0; i < estoqueFruta.size(); i++) {
            System.out.println((i + 1) + " - " + estoqueFruta.get(i).getNome());
        }

        System.out.println("Digite o número da fruta que deseja editar: ");
        System.out.print("> ");
        int escolha = input.nextInt();
        input.nextLine();
        System.out.println("--------------------------");
        if (escolha > 0 && escolha <= estoqueFruta.size()) {
            Fruta fruta = estoqueFruta.get(escolha - 1);
            System.out.println("O que deseja editar?");
            System.out.println("1 - Nome");
            System.out.println("2 - Preço");
            System.out.println("3 - Quantidade");
            System.out.print("> ");
            int opcaoEdicao = input.nextInt();
            input.nextLine();
            System.out.println("--------------------------");
            switch (opcaoEdicao) {
                case 1:
                    Editar.editarNome(fruta);
                    break;
                case 2:
                    Editar.editarPreco(fruta);
                    break;
                case 3:
                    Editar.editarQuantidade(fruta);
                    break;
                default:
                    System.out.println("Opção inválida. Escolha um número entre 1 e 3.");
            }

        } else

        {
            System.out.println("Número inválido.");
        }
    }

    public void encerrar() {
        System.out.println("Encerrando o programa...");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Programa encerrado com sucesso!");
        System.out.println("--------------------------");
        System.exit(0);
    }
}