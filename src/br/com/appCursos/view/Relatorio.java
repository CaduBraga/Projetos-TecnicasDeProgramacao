package br.com.appCursos.view;

import java.util.List;
import java.util.Scanner;
import br.com.appCursos.model.Curso;

public class Relatorio {
    Scanner input;

    public Relatorio() {
        input = new Scanner(System.in);
    }

    public void relatorioCursos(List<Curso> estoqueCursos) {
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|                  RELATÓRIO DE CURSOS                         |");
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("Total de cursos: " + Curso.getTotalCursos());
        double totalReais = 0.0;
        for (Curso c : estoqueCursos) {
            totalReais += c.getPreco() * c.getVagas();
        }
        System.out.println("Total em reais em cursos: R$ " + String.format("%.2f", totalReais));
        Curso[] ordenados = new Curso[estoqueCursos.size()];
        for (int i = 0; i < estoqueCursos.size(); i++) {
            ordenados[i] = estoqueCursos.get(i);
        }
        for (int i = 0; i < ordenados.length - 1; i++) {
            for (int j = 0; j < ordenados.length - i - 1; j++) {
                if (ordenados[j].getVagas() < ordenados[j + 1].getVagas()) {
                    Curso temp = ordenados[j];
                    ordenados[j] = ordenados[j + 1];
                    ordenados[j + 1] = temp;
                }
            }
        }
        System.out.println("\nCursos ordenados por vagas (ordem decrescente):");
        for (Curso c : ordenados) {
            System.out.println(c.getNome() + " - Vagas: " + c.getVagas());
        }
        String excesso = "";
        String aceitavel = "";
        String falta = "";
        boolean temExcesso = false;
        boolean temAceitavel = false;
        boolean temFalta = false;
        for (Curso c : estoqueCursos) {
            if (c.getVagas() > 20) {
                excesso += c.getNome() + " - Vagas: " + c.getVagas() + "\n";
                temExcesso = true;
            } else if (c.getVagas() >= 5 && c.getVagas() <= 20) {
                aceitavel += c.getNome() + " - Vagas: " + c.getVagas() + "\n";
                temAceitavel = true;
            } else if (c.getVagas() < 5) {
                falta += c.getNome() + " - Vagas: " + c.getVagas() + "\n";
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