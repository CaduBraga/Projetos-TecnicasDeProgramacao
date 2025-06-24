package br.com.appSuplementos.view;

import java.util.Scanner;

import br.com.appSuplementos.model.Suplemento;

public class Editar {
    static Scanner input = new Scanner(System.in);

    public static void editarNome(Suplemento suplemento) {
        System.out.print("Digite o novo nome: ");
        String novoNome = input.nextLine();
        suplemento.setNome(novoNome);
        System.out.println("Nome atualizado com sucesso!");
    }

    public static void editarPreco(Suplemento suplemento) {
        System.out.print("Digite o novo preço: ");
        double novoPreco = input.nextDouble();
        suplemento.setPreco(novoPreco);
        input.nextLine();
        System.out.println("Preço atualizado com sucesso!");
    }

    public static void editarQuantidade(Suplemento suplemento) {
        System.out.print("Digite a nova quantidade: ");
        int novaQuantidade = input.nextInt();
        input.nextLine();

        int quantidadeAntiga = suplemento.getQuantidade();
        int diferenca = novaQuantidade - quantidadeAntiga;

        suplemento.setQuantidade(novaQuantidade);
        if (diferenca > 0) {
            Suplemento.adicionarSuplementos(diferenca);
        } else if (diferenca < 0) {
            Suplemento.removerSuplementos(-diferenca);
        }
        System.out.println("Quantidade atualizada com sucesso!");
        System.out.println("Total de suplementos na loja: " + Suplemento.getTotalSuplementos());
    }

    public static void editarMarca(Suplemento suplemento) {
        System.out.print("Digite a nova marca: ");
        String novaMarca = input.nextLine();
        suplemento.setMarca(novaMarca);
        System.out.println("Marca atualizada com sucesso!");
    }
} 