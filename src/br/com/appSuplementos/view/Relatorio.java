package br.com.appSuplementos.view;

import java.util.List;
import java.util.Scanner;
import br.com.appSuplementos.model.Suplemento;

public class Relatorio {
    Scanner input;

    public Relatorio() {
        input = new Scanner(System.in);
    }

    public void relatorioSuplementos(List<Suplemento> estoqueSuplementos) {
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|                  RELATÓRIO DE SUPLEMENTOS                    |");
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("Total de suplementos: " + Suplemento.getTotalSuplementos());
        double totalReais = 0.0;
        for (Suplemento s : estoqueSuplementos) {
            totalReais += s.getPreco() * s.getQuantidade();
        }
        System.out.println("Total em reais em suplementos: R$ " + String.format("%.2f", totalReais));
        Suplemento[] ordenados = new Suplemento[estoqueSuplementos.size()];
        for (int i = 0; i < estoqueSuplementos.size(); i++) {
            ordenados[i] = estoqueSuplementos.get(i);
        }
        for (int i = 0; i < ordenados.length - 1; i++) {
            for (int j = 0; j < ordenados.length - i - 1; j++) {
                if (ordenados[j].getQuantidade() < ordenados[j + 1].getQuantidade()) {
                    Suplemento temp = ordenados[j];
                    ordenados[j] = ordenados[j + 1];
                    ordenados[j + 1] = temp;
                }
            }
        }
        System.out.println("\nSuplementos ordenados por quantidade (ordem decrescente):");
        for (Suplemento s : ordenados) {
            System.out.println(s.getNome() + " - Quantidade: " + s.getQuantidade());
        }
        String excesso = "";
        String aceitavel = "";
        String falta = "";
        boolean temExcesso = false;
        boolean temAceitavel = false;
        boolean temFalta = false;
        for (Suplemento s : estoqueSuplementos) {
            if (s.getQuantidade() > 20) {
                excesso += s.getNome() + " - Quantidade: " + s.getQuantidade() + "\n";
                temExcesso = true;
            } else if (s.getQuantidade() >= 5 && s.getQuantidade() <= 20) {
                aceitavel += s.getNome() + " - Quantidade: " + s.getQuantidade() + "\n";
                temAceitavel = true;
            } else if (s.getQuantidade() < 5) {
                falta += s.getNome() + " - Quantidade: " + s.getQuantidade() + "\n";
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