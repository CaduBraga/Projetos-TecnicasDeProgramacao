package br.com.appFilmes.view;

import java.util.List;
import java.util.Scanner;
import br.com.appFilmes.model.Filme;

public class Relatorio {
    Scanner input;

    public Relatorio() {
        input = new Scanner(System.in);
    }

    public void relatorioFilmes(List<Filme> estoqueFilmes) {
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|                  RELATÓRIO DE FILMES                         |");
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("Total de filmes: " + Filme.getTotalFilmes());
        double totalReais = 0.0;
        for (Filme f : estoqueFilmes) {
            totalReais += f.getPreco() * f.getQuantidade();
        }
        System.out.println("Total em reais em filmes: R$ " + String.format("%.2f", totalReais));
        Filme[] ordenados = new Filme[estoqueFilmes.size()];
        for (int i = 0; i < estoqueFilmes.size(); i++) {
            ordenados[i] = estoqueFilmes.get(i);
        }
        for (int i = 0; i < ordenados.length - 1; i++) {
            for (int j = 0; j < ordenados.length - i - 1; j++) {
                if (ordenados[j].getQuantidade() < ordenados[j + 1].getQuantidade()) {
                    Filme temp = ordenados[j];
                    ordenados[j] = ordenados[j + 1];
                    ordenados[j + 1] = temp;
                }
            }
        }
        System.out.println("\nFilmes ordenados por quantidade (ordem decrescente):");
        for (Filme f : ordenados) {
            System.out.println(f.getTitulo() + " - Quantidade: " + f.getQuantidade());
        }
        String excesso = "";
        String aceitavel = "";
        String falta = "";
        boolean temExcesso = false;
        boolean temAceitavel = false;
        boolean temFalta = false;
        for (Filme f : estoqueFilmes) {
            if (f.getQuantidade() > 20) {
                excesso += f.getTitulo() + " - Quantidade: " + f.getQuantidade() + "\n";
                temExcesso = true;
            } else if (f.getQuantidade() >= 5 && f.getQuantidade() <= 20) {
                aceitavel += f.getTitulo() + " - Quantidade: " + f.getQuantidade() + "\n";
                temAceitavel = true;
            } else if (f.getQuantidade() < 5) {
                falta += f.getTitulo() + " - Quantidade: " + f.getQuantidade() + "\n";
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