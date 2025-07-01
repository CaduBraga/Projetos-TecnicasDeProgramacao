package br.com.appFilmes.view;

import br.com.appFilmes.model.Filme;
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
        System.out.println("=== Bem-vindo ao App Filmes ===");
    }

    public int menuPrincipal() {
        System.out.println("--------------------------");
        System.out.println("O que você deseja fazer?");
        System.out.println("1 - Cadastrar filmes");
        System.out.println("2 - Ver filmes");
        System.out.println("3 - Remover filmes");
        System.out.println("4 - Editar filmes");
        System.out.println("5 - Iniciar compras");
        System.out.println("6 - Relatório de filmes");
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

    public Filme cadastrar() {
        System.out.print("Digite o título do filme: ");
        String titulo = input.nextLine();

        System.out.print("Digite o gênero do filme: ");
        String genero = input.nextLine();

        System.out.print("Digite a duração do filme (em minutos): ");
        int duracao = input.nextInt();
        input.nextLine();

        System.out.print("Digite o ano de lançamento: ");
        int anoLancamento = input.nextInt();
        input.nextLine();

        System.out.print("Digite o nome do diretor: ");
        String diretor = input.nextLine();

        System.out.print("Digite a quantidade em estoque: ");
        int quantidade = input.nextInt();
        input.nextLine();

        System.out.print("Digite o preço do filme: ");
        double preco = input.nextDouble();
        input.nextLine();

        Filme.adicionarFilmes(quantidade);

        Filme filme = new Filme(titulo, genero, duracao, anoLancamento, diretor, quantidade, preco);

        System.out.println("Filme '" + titulo + "' cadastrado com sucesso!");
        System.out.println("Total de filmes na locadora: " + Filme.getTotalFilmes());

        return filme;
    }

    public void detalhar(List<Filme> estoqueFilme) {
        if (estoqueFilme.isEmpty()) {
            System.out.println("O estoque de filmes está vazio.");
            return;
        } else {
            System.out.println("Filmes disponíveis:");
            for (int i = 0; i < estoqueFilme.size(); i++) {
                System.out.println((i + 1) + " - " + estoqueFilme.get(i).getTitulo() + " (Quantidade: "
                        + estoqueFilme.get(i).getQuantidade() + ")");
            }

            System.out.println("Digite o número do filme para ver os detalhes:");
            System.out.print("> ");
            int escolhaFilme = input.nextInt();
            input.nextLine();

            if (escolhaFilme > 0 && escolhaFilme <= estoqueFilme.size()) {
                Filme filmeEscolhido = estoqueFilme.get(escolhaFilme - 1);
                System.out.println("--------------------------");
                System.out.println("Detalhes do filme escolhido:");
                System.out.println("Título: " + filmeEscolhido.getTitulo());
                System.out.println("Gênero: " + filmeEscolhido.getGenero());
                System.out.println("Duração: " + filmeEscolhido.getDuracao() + " minutos");
                System.out.println("Ano de lançamento: " + filmeEscolhido.getAnoLancamento());
                System.out.println("Diretor: " + filmeEscolhido.getDiretor());
                System.out.println("Quantidade em estoque: " + filmeEscolhido.getQuantidade());
                System.out.println("Total de filmes na locadora: " + filmeEscolhido.getTotalFilmes());
            } else {
                System.out.println("Opção inválida. Escolha um número entre 1 e " + estoqueFilme.size() + ".");
            }
        }
    }

    public void remover(List<Filme> estoqueFilme) {
        if (estoqueFilme.isEmpty()) {
            System.out.println("O estoque de filmes está vazio.");
            return;
        }
        System.out.println("Filmes disponíveis:");
        for (int i = 0; i < estoqueFilme.size(); i++) {
            System.out.println((i + 1) + " - " + estoqueFilme.get(i).getTitulo() + " (Quantidade: "
                    + estoqueFilme.get(i).getQuantidade() + ")");
        }
        System.out.println("Digite o número do filme que deseja remover: ");
        System.out.print("> ");
        int escolha = input.nextInt();
        input.nextLine();
        System.out.println("--------------------------");

        if (escolha > 0 && escolha <= estoqueFilme.size()) {
            Filme selecionado = estoqueFilme.get(escolha - 1);
            System.out.println("Estão disponíveis " + selecionado.getQuantidade() + " unidades do filme '"
                    + selecionado.getTitulo() + "'. Quantas você deseja remover?");
            System.out.print("> ");
            int quantidadeRemovida = input.nextInt();
            input.nextLine();

            if (quantidadeRemovida > 0 && quantidadeRemovida <= selecionado.getQuantidade()) {
                selecionado.setQuantidade(selecionado.getQuantidade() - quantidadeRemovida);
                Filme.removerFilmes(quantidadeRemovida);

                System.out.println("Foram removidas " + quantidadeRemovida + " unidades do filme '"
                        + selecionado.getTitulo() + "'.");
                System.out.println("Quantidade restante deste filme: " + selecionado.getQuantidade());
                System.out.println("Total de filmes na locadora: " + Filme.getTotalFilmes());

                if (selecionado.getQuantidade() == 0) {
                    estoqueFilme.remove(escolha - 1);
                    System.out.println("Todos os exemplares deste filme foram removidos. Filme retirado do estoque.");
                }
            } else {
                System.out.println("Quantidade inválida para remoção.");
            }
        } else {
            System.out.println("Opção inválida. Escolha um número entre 1 e " + estoqueFilme.size() + ".");
        }
    }

    public void editar(List<Filme> estoqueFilme) {
        if (estoqueFilme.isEmpty()) {
            System.out.println("O estoque de filmes está vazio.");
            return;
        }
        System.out.println("Filmes disponíveis:");
        for (int i = 0; i < estoqueFilme.size(); i++) {
            System.out.println((i + 1) + " - " + estoqueFilme.get(i).getTitulo());
        }

        System.out.println("Digite o número do filme que deseja editar: ");
        System.out.print("> ");
        int escolha = input.nextInt();
        input.nextLine();
        System.out.println("--------------------------");
        if (escolha > 0 && escolha <= estoqueFilme.size()) {
            Filme filme = estoqueFilme.get(escolha - 1);
            System.out.println("O que deseja editar?");
            System.out.println("1 - Título");
            System.out.println("2 - Gênero");
            System.out.println("3 - Duração");
            System.out.println("4 - Ano de lançamento");
            System.out.println("5 - Diretor");
            System.out.println("6 - Quantidade em estoque");
            System.out.print("> ");
            int opcaoEdicao = input.nextInt();
            input.nextLine();
            System.out.println("--------------------------");
            switch (opcaoEdicao) {
                case 1:
                    Editar.editarTitulo(filme);
                    break;
                case 2:
                    Editar.editarGenero(filme);
                    break;
                case 3:
                    Editar.editarDuracao(filme);
                    break;
                case 4:
                    Editar.editarAnoLancamento(filme);
                    break;
                case 5:
                    Editar.editarDiretor(filme);
                    break;
                case 6:
                    Editar.editarQuantidade(filme);
                    break;
                default:
                    System.out.println("Opção inválida. Escolha um número entre 1 e 6.");
            }
        } else {
            System.out.println("Opção inválida. Escolha um número entre 1 e " + estoqueFilme.size() + ".");
        }
    }

    public void encerrar() {
        System.out.println("Obrigado por usar o App Filmes!");
        System.out.println("Programa encerrado.");
    }
}