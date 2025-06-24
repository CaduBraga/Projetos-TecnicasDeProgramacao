package br.com.appCursos.view;

import java.util.Scanner;

import br.com.appCursos.model.Curso;

public class Editar {
    static Scanner input = new Scanner(System.in);

    public static void editarNome(Curso curso) {
        System.out.print("Digite o novo nome: ");
        String novoNome = input.nextLine();
        curso.setNome(novoNome);
        System.out.println("Nome atualizado com sucesso!");
    }

    public static void editarDuracao(Curso curso) {
        System.out.print("Digite a nova duração (em horas): ");
        int novaDuracao = input.nextInt();
        curso.setDuracaoHoras(novaDuracao);
        input.nextLine();
        System.out.println("Duração atualizada com sucesso!");
    }

    public static void editarCoordenador(Curso curso) {
        System.out.print("Digite o novo coordenador: ");
        String novoCoordenador = input.nextLine();
        curso.setCoordenador(novoCoordenador);
        System.out.println("Coordenador atualizado com sucesso!");
    }

    public static void editarNivel(Curso curso) {
        System.out.print("Digite o novo nível: ");
        String novoNivel = input.nextLine();
        curso.setNivel(novoNivel);
        System.out.println("Nível atualizado com sucesso!");
    }

    public static void editarVagas(Curso curso) {
        System.out.print("Digite o novo número de vagas: ");
        int novasVagas = input.nextInt();
        curso.setVagas(novasVagas);
        input.nextLine();
        System.out.println("Vagas atualizadas com sucesso!");
    }
} 