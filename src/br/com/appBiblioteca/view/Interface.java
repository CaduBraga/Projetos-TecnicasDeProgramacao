package br.com.appBiblioteca.view;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.appBiblioteca.model.Livro;

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
        System.out.println("=== Bem-vindo ao App Biblioteca ===");
    }

    public int menuPrincipal() {
        System.out.println("--------------------------");
        System.out.println("O que você deseja fazer?");
        System.out.println("1 - Cadastrar livros");
        System.out.println("2 - Ver livros");
        System.out.println("3 - Remover livros");
        System.out.println("4 - Editar livros");
        System.out.println("5 - Sair do programa");
        System.out.println("Digite sua escolha abaixo:");
        System.out.print("> ");
        int escolha = input.nextInt();
        input.nextLine();
        System.out.println("--------------------------");

        return escolha;
    }

    public Livro cadastrar() {
        System.out.print("Digite o nome do livro: ");
        String nome = input.nextLine();

        System.out.print("Digite o autor do livro: ");
        String autor = input.nextLine();

        System.out.print("Digite o gênero do livro: ");
        String genero = input.nextLine();

        System.out.print("Digite a editora do livro: ");
        String editora = input.nextLine();

        System.out.print("Digite a quantidade de páginas: ");
        int paginas = input.nextInt();
        input.nextLine();

        System.out.print("Digite a quantidade em estoque: ");
        int quantidade = input.nextInt();
        input.nextLine();

        Livro livro = new Livro();
        livro.setNome(nome);
        livro.setAutor(autor);
        livro.setGenero(genero);
        livro.setEditora(editora);
        livro.setPaginas(paginas);
        livro.setQuantidade(quantidade);

        System.out.println("Livro '" + livro.getNome() + "' cadastrado com sucesso!");

        return livro;
    }

    public void detalhar(List<Livro> estoqueLivro) {
        if (estoqueLivro.isEmpty()) {
            System.out.println("O estoque de livros está vazio.");
            return;
        } else {
            System.out.println("Livros disponíveis:");
            for (int i = 0; i < estoqueLivro.size(); i++) {
                System.out.println((i + 1) + " - " + estoqueLivro.get(i).getNome());
            }

            System.out.println("Digite o número do livro para ver os detalhes:");
            System.out.print("> ");
            int escolhaLivro = input.nextInt();
            input.nextLine();

            if (escolhaLivro > 0 && escolhaLivro <= estoqueLivro.size()) {
                Livro livroEscolhido = estoqueLivro.get(escolhaLivro - 1);
                System.out.println("--------------------------");
                System.out.println("Detalhes do livro escolhido:");
                System.out.println("Nome: " + livroEscolhido.getNome());
                System.out.println("Autor: " + livroEscolhido.getAutor());
                System.out.println("Gênero: " + livroEscolhido.getGenero());
                System.out.println("Editora: " + livroEscolhido.getEditora());
                System.out.println("Quantidade de páginas: " + livroEscolhido.getPaginas());
                System.out.println("Quantidade: " + livroEscolhido.getQuantidade());
            } else {
                System.out.println("Opção inválida. Escolha um número entre 1 e " + estoqueLivro.size() + ".");
            }
        }
    }

    public void remover(List<Livro> estoqueLivro) {
        if (estoqueLivro.isEmpty()) {
            System.out.println("O estoque de livros está vazio.");
            return;
        }
        System.out.println("Livros disponíveis:");
        for (int i = 0; i < estoqueLivro.size(); i++) {
            System.out.println((i + 1) + " - " + estoqueLivro.get(i).getNome());
        }

        System.out.println("Digite o número do livro que deseja remover: ");
        System.out.print("> ");
        int escolha = input.nextInt();
        input.nextLine();
        System.out.println("--------------------------");
        if (escolha > 0 && escolha <= estoqueLivro.size()) {
            Livro removida = estoqueLivro.remove(escolha - 1);
            System.out.println("Livro '" + removida.getNome() + "' removido com sucesso!");
        } else {
            System.out.println("Opção inválida. Escolha um número entre 1 e " + estoqueLivro.size() + ".");
        }
    }

    public void editar(List<Livro> estoqueLivro) {

        if (estoqueLivro.isEmpty()) {
            System.out.println("O estoque de livros está vazio.");
            return;
        }
        System.out.println("Livros disponíveis:");
        for (int i = 0; i < estoqueLivro.size(); i++) {
            System.out.println((i + 1) + " - " + estoqueLivro.get(i).getNome());
        }

        System.out.println("Digite o número do livro que deseja editar: ");
        System.out.print("> ");
        int escolha = input.nextInt();
        input.nextLine();
        System.out.println("--------------------------");
        if (escolha > 0 && escolha <= estoqueLivro.size()) {
            Livro livro = estoqueLivro.get(escolha - 1);
            System.out.println("O que deseja editar?");
            System.out.println("1 - Nome");
            System.out.println("2 - Autor");
            System.out.println("3 - Gênero");
            System.out.println("4 - Editora");
            System.out.println("5 - Quantidade de páginas");
            System.out.println("6 - Quantidade em estoque");
            System.out.print("> ");
            int opcaoEdicao = input.nextInt();
            input.nextLine();
            System.out.println("--------------------------");
            switch (opcaoEdicao) {
                case 1:
                    Editar.editarNome(livro);
                    break;
                case 2:
                    Editar.editarAutor(livro);
                    break;
                case 3:
                    Editar.editarGenero(livro);
                    break;
                case 4:
                    Editar.editarEditora(livro);
                    break;
                case 5:
                    Editar.editarPaginas(livro);
                    break;
                case 6:
                    Editar.editarQuantidade(livro);
                    break;
                default:
                    System.out.println("Opção inválida. Escolha um número entre 1 e 6.");
            }

        } else {
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