package br.com.appBiblioteca.view;

import java.util.List;
import java.util.Scanner;
import br.com.appBiblioteca.model.Livro;

public class Relatorio {
    Scanner input;

    public Relatorio() {
        input = new Scanner(System.in);
    }

    public void relatorioBiblioteca(List<Livro> estoqueLivros) {
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|                  RELATÓRIO DA BIBLIOTECA                     |");
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("Total de livros: " + Livro.getTotalLivros());
        double totalReais = 0.0;
        for (Livro l : estoqueLivros) {
            totalReais += l.getPreco() * l.getQuantidade();
        }
        System.out.println("Total em reais na biblioteca: R$ " + String.format("%.2f", totalReais));
        Livro[] ordenados = new Livro[estoqueLivros.size()];
        for (int i = 0; i < estoqueLivros.size(); i++) {
            ordenados[i] = estoqueLivros.get(i);
        }
        for (int i = 0; i < ordenados.length - 1; i++) {
            for (int j = 0; j < ordenados.length - i - 1; j++) {
                if (ordenados[j].getQuantidade() < ordenados[j + 1].getQuantidade()) {
                    Livro temp = ordenados[j];
                    ordenados[j] = ordenados[j + 1];
                    ordenados[j + 1] = temp;
                }
            }
        }
        System.out.println("\nLivros ordenados por quantidade (ordem decrescente):");
        for (Livro l : ordenados) {
            System.out.println(l.getNome() + " - Quantidade: " + l.getQuantidade());
        }
        String excesso = "";
        String aceitavel = "";
        String falta = "";
        boolean temExcesso = false;
        boolean temAceitavel = false;
        boolean temFalta = false;
        for (Livro l : estoqueLivros) {
            if (l.getQuantidade() > 20) {
                excesso += l.getNome() + " - Quantidade: " + l.getQuantidade() + "\n";
                temExcesso = true;
            } else if (l.getQuantidade() >= 5 && l.getQuantidade() <= 20) {
                aceitavel += l.getNome() + " - Quantidade: " + l.getQuantidade() + "\n";
                temAceitavel = true;
            } else if (l.getQuantidade() < 5) {
                falta += l.getNome() + " - Quantidade: " + l.getQuantidade() + "\n";
                temFalta = true;
            }
        }
        if (temExcesso) {
            System.out.println("\nExcesso:");
            System.out.print(excesso);
        }
        if (temAceitavel) {
            System.out.println("\nAceitável:");
            System.out.print(aceitavel);
        }
        if (temFalta) {
            System.out.println("\nEm falta:");
            System.out.print(falta);
        }
    }
}