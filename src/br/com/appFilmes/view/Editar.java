package br.com.appFilmes.view;

import java.util.Scanner;

import br.com.appFilmes.model.Filme;

public class Editar {
    static Scanner input = new Scanner(System.in);

    public static void editarTitulo(Filme filme) {
        System.out.print("Digite o novo título: ");
        String novoTitulo = input.nextLine();
        filme.setTitulo(novoTitulo);
        System.out.println("Título atualizado com sucesso!");
    }

    public static void editarGenero(Filme filme) {
        System.out.print("Digite o novo gênero: ");
        String novoGenero = input.nextLine();
        filme.setGenero(novoGenero);
        System.out.println("Gênero atualizado com sucesso!");
    }

    public static void editarDuracao(Filme filme) {
        System.out.print("Digite a nova duração (em minutos): ");
        int novaDuracao = input.nextInt();
        filme.setDuracao(novaDuracao);
        input.nextLine();
        System.out.println("Duração atualizada com sucesso!");
    }

    public static void editarAnoLancamento(Filme filme) {
        System.out.print("Digite o novo ano de lançamento: ");
        int novoAno = input.nextInt();
        filme.setAnoLancamento(novoAno);
        input.nextLine();
        System.out.println("Ano de lançamento atualizado com sucesso!");
    }

    public static void editarDiretor(Filme filme) {
        System.out.print("Digite o novo diretor: ");
        String novoDiretor = input.nextLine();
        filme.setDiretor(novoDiretor);
        System.out.println("Diretor atualizado com sucesso!");
    }

    public static void editarQuantidade(Filme filme) {
        System.out.print("Digite a nova quantidade: ");
        int novaQuantidade = input.nextInt();
        input.nextLine();

        int quantidadeAntiga = filme.getQuantidade();
        int diferenca = novaQuantidade - quantidadeAntiga;

        filme.setQuantidade(novaQuantidade);
        if (diferenca > 0) {
            Filme.adicionarFilmes(diferenca);
        } else if (diferenca < 0) {
            Filme.removerFilmes(-diferenca);
        }
        System.out.println("Quantidade atualizada com sucesso!");
        System.out.println("Total de filmes na locadora: " + Filme.getTotalFilmes());
    }
} 