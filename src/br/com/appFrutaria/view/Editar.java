package br.com.appFrutaria.view;

import java.util.Scanner;
import br.com.appFrutaria.model.Fruta;

public class Editar {
    static Scanner input = new Scanner(System.in);

    public static void editarNome(Fruta fruta) {
        System.out.print("Digite o novo nome: ");
        String novoNome = input.nextLine();
        fruta.setNome(novoNome);
        System.out.println("Nome atualizado com sucesso!");
    }

    public static void editarPreco(Fruta fruta) {
        System.out.print("Digite o novo preço: ");
        double novoPreco = input.nextDouble();
        input.nextLine();
        fruta.setPreco(novoPreco);
        System.out.println("Preço atualizado com sucesso!");
    }

    public static void editarQuantidade(Fruta fruta) {
        System.out.print("Digite a nova quantidade: ");
        int novaQuantidade = input.nextInt();
        input.nextLine();

        int quantidadeAntiga = fruta.getQuantidade();
        int diferenca = novaQuantidade - quantidadeAntiga;

        fruta.setQuantidade(novaQuantidade);
        if (diferenca > 0) {
            Fruta.adicionarFrutas(diferenca);
        } else if (diferenca < 0) {
            Fruta.removerFrutas(-diferenca);
        }
        System.out.println("Quantidade atualizada com sucesso!");
        System.out.println("Total de frutas na frutaria: " + Fruta.getTotalFrutas());
    }
}