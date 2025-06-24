package br.com.appBiblioteca.view;

import java.util.Scanner;

import br.com.appBiblioteca.model.Livro;

public class Editar {
    static Scanner input = new Scanner(System.in);

    public static void editarNome(Livro livro) {
        System.out.print("Digite o novo nome: ");
        String novoNome = input.nextLine();
        livro.setNome(novoNome);
        System.out.println("Nome atualizado com sucesso!");
    }

    public static void editarAutor(Livro livro) {
        System.out.print("Digite o novo autor: ");
        String novoAutor = input.nextLine();
        livro.setAutor(novoAutor);
        System.out.println("Autor atualizado com sucesso!");
    }

    public static void editarGenero(Livro livro) {
        System.out.print("Digite o novo genero: ");
        String novoGenero = input.nextLine();
        livro.setGenero(novoGenero);
        System.out.println("Genero atualizado com sucesso!");
    }

    public static void editarEditora(Livro livro) {
        System.out.print("Digite a nova editora: ");
        String novaEditora = input.nextLine();
        livro.setEditora(novaEditora);
        System.out.println("Editora atualizado com sucesso!");
    }

    public static void editarPaginas(Livro livro) {
        System.out.print("Digite a nova quantidade de páginas: ");
        int novaQuantidade = input.nextInt();
        livro.setPaginas(novaQuantidade);
        input.nextLine();
        System.out.println("Paginas atualizada com sucesso!");
    }

    public static void editarQuantidade(Livro livro) {
        System.out.print("Digite a nova quantidade: ");
        int novaQuantidade = input.nextInt();
        input.nextLine();

        int quantidadeAntiga = livro.getQuantidade();
        int diferenca = novaQuantidade - quantidadeAntiga;

        livro.setQuantidade(novaQuantidade);
        if (diferenca > 0) {
            Livro.adicionarLivros(diferenca);
        } else if (diferenca < 0) {
            Livro.removerLivros(-diferenca);
        }
        System.out.println("Quantidade atualizada com sucesso!");
        System.out.println("Total de livros na biblioteca: " + Livro.getTotalLivros());
    }
}