package br.com.appCursos.view;

import br.com.appCursos.model.Curso;
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
        System.out.println("=== Bem-vindo ao App Cursos ===");
    }

    public int menuPrincipal() {
        System.out.println("--------------------------");
        System.out.println("O que você deseja fazer?");
        System.out.println("1 - Cadastrar cursos");
        System.out.println("2 - Ver cursos");
        System.out.println("3 - Remover cursos");
        System.out.println("4 - Editar cursos");
        System.out.println("5 - Iniciar compras");
        System.out.println("6 - Relatório de cursos");
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

    public Curso cadastrar() {
        System.out.print("Digite o nome do curso: ");
        String nome = input.nextLine();
        System.out.print("Digite a duração do curso (em horas): ");
        int duracaoHoras = input.nextInt();
        input.nextLine();
        System.out.print("Digite o nome do coordenador: ");
        String coordenador = input.nextLine();
        System.out.print("Digite o nível do curso: ");
        String nivel = input.nextLine();
        System.out.print("Digite o número de vagas: ");
        int vagas = input.nextInt();
        input.nextLine();
        System.out.print("Digite o preço do curso: ");
        double preco = input.nextDouble();
        input.nextLine();
        Curso.adicionarCursos(1);
        Curso curso = new Curso(nome, duracaoHoras, coordenador, nivel, vagas, preco);
        System.out.println("Curso '" + nome + "' cadastrado com sucesso!");
        System.out.println("Total de cursos na instituição: " + Curso.getTotalCursos());
        return curso;
    }

    public void detalhar(List<Curso> estoqueCurso) {
        if (estoqueCurso.isEmpty()) {
            System.out.println("O estoque de cursos está vazio.");
            return;
        } else {
            System.out.println("Cursos disponíveis:");
            for (int i = 0; i < estoqueCurso.size(); i++) {
                System.out.println((i + 1) + " - " + estoqueCurso.get(i).getNome() + " (Vagas: "
                        + estoqueCurso.get(i).getVagas() + ")");
            }

            System.out.println("Digite o número do curso para ver os detalhes:");
            System.out.print("> ");
            int escolhaCurso = input.nextInt();
            input.nextLine();

            if (escolhaCurso > 0 && escolhaCurso <= estoqueCurso.size()) {
                Curso cursoEscolhido = estoqueCurso.get(escolhaCurso - 1);
                System.out.println("--------------------------");
                System.out.println("Detalhes do curso escolhido:");
                System.out.println("Nome: " + cursoEscolhido.getNome());
                System.out.println("Duração: " + cursoEscolhido.getDuracaoHoras() + " horas");
                System.out.println("Coordenador: " + cursoEscolhido.getCoordenador());
                System.out.println("Nível: " + cursoEscolhido.getNivel());
                System.out.println("Vagas disponíveis: " + cursoEscolhido.getVagas());
                System.out.println("Total de cursos na instituição: " + cursoEscolhido.getTotalCursos());
            } else {
                System.out.println("Opção inválida. Escolha um número entre 1 e " + estoqueCurso.size() + ".");
            }
        }
    }

    public void remover(List<Curso> estoqueCurso) {
        if (estoqueCurso.isEmpty()) {
            System.out.println("O estoque de cursos está vazio.");
            return;
        }
        System.out.println("Cursos disponíveis:");
        for (int i = 0; i < estoqueCurso.size(); i++) {
            System.out.println((i + 1) + " - " + estoqueCurso.get(i).getNome() + " (Vagas: "
                    + estoqueCurso.get(i).getVagas() + ")");
        }
        System.out.println("Digite o número do curso que deseja remover: ");
        System.out.print("> ");
        int escolha = input.nextInt();
        input.nextLine();
        System.out.println("--------------------------");

        if (escolha > 0 && escolha <= estoqueCurso.size()) {
            Curso selecionado = estoqueCurso.get(escolha - 1);
            System.out.println(
                    "Tem certeza que deseja remover o curso '" + selecionado.getNome() + "'? (1 - Sim / 0 - Não)");
            System.out.print("> ");
            int confirmacao = input.nextInt();
            input.nextLine();

            if (confirmacao == 1) {
                estoqueCurso.remove(escolha - 1);
                Curso.removerCursos(1);
                System.out.println("Curso '" + selecionado.getNome() + "' removido com sucesso.");
                System.out.println("Total de cursos na instituição: " + Curso.getTotalCursos());
            } else {
                System.out.println("Operação cancelada.");
            }
        } else {
            System.out.println("Opção inválida. Escolha um número entre 1 e " + estoqueCurso.size() + ".");
        }
    }

    public void editar(List<Curso> estoqueCurso) {
        if (estoqueCurso.isEmpty()) {
            System.out.println("O estoque de cursos está vazio.");
            return;
        }
        System.out.println("Cursos disponíveis:");
        for (int i = 0; i < estoqueCurso.size(); i++) {
            System.out.println((i + 1) + " - " + estoqueCurso.get(i).getNome());
        }

        System.out.println("Digite o número do curso que deseja editar: ");
        System.out.print("> ");
        int escolha = input.nextInt();
        input.nextLine();
        System.out.println("--------------------------");
        if (escolha > 0 && escolha <= estoqueCurso.size()) {
            Curso curso = estoqueCurso.get(escolha - 1);
            System.out.println("O que deseja editar?");
            System.out.println("1 - Nome");
            System.out.println("2 - Duração");
            System.out.println("3 - Coordenador");
            System.out.println("4 - Nível");
            System.out.println("5 - Vagas");
            System.out.print("> ");
            int opcaoEdicao = input.nextInt();
            input.nextLine();
            System.out.println("--------------------------");
            switch (opcaoEdicao) {
                case 1:
                    Editar.editarNome(curso);
                    break;
                case 2:
                    Editar.editarDuracao(curso);
                    break;
                case 3:
                    Editar.editarCoordenador(curso);
                    break;
                case 4:
                    Editar.editarNivel(curso);
                    break;
                case 5:
                    Editar.editarVagas(curso);
                    break;
                default:
                    System.out.println("Opção inválida. Escolha um número entre 1 e 5.");
            }
        } else {
            System.out.println("Opção inválida. Escolha um número entre 1 e " + estoqueCurso.size() + ".");
        }
    }

    public void encerrar() {
        System.out.println("Obrigado por usar o App Cursos!");
        System.out.println("Programa encerrado.");
    }

    public int menuCarrinho() {
        System.out.println("=== Carrinho de Compras ===");
        System.out.println("1 - Adicionar curso ao carrinho");
        System.out.println("2 - Remover curso do carrinho");
        System.out.println("3 - Ver carrinho");
        System.out.println("4 - Finalizar compra");
        System.out.println("5 - Voltar");
        System.out.print("> ");
        int escolha = input.nextInt();
        input.nextLine();
        return escolha;
    }

    public void adicionarAoCarrinho(List<Curso> estoque, br.com.appCursos.service.CarrinhoCompras carrinho) {
        if (estoque.isEmpty()) {
            System.out.println("Estoque vazio.");
            return;
        }
        System.out.println("Cursos disponíveis:");
        for (int i = 0; i < estoque.size(); i++) {
            Curso c = estoque.get(i);
            System.out
                    .println((i + 1) + " - " + c.getNome() + " (R$ " + c.getPreco() + ", Vagas: " + c.getVagas() + ")");
        }
        System.out.print("Escolha o curso: ");
        int idx = input.nextInt() - 1;
        input.nextLine();
        if (idx < 0 || idx >= estoque.size()) {
            System.out.println("Opção inválida.");
            return;
        }
        Curso curso = estoque.get(idx);
        System.out.print("Quantidade: ");
        int qtd = input.nextInt();
        input.nextLine();
        if (qtd <= 0 || qtd > curso.getVagas()) {
            System.out.println("Quantidade inválida.");
            return;
        }
        curso.setVagas(curso.getVagas() - qtd);
        carrinho.adicionarCurso(curso, qtd);
    }
}