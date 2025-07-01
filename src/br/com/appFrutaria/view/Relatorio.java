package br.com.appFrutaria.view;

import br.com.appFrutaria.model.*;
import br.com.appFrutaria.model.verduras.Verdura;
import java.util.List;
import java.util.Scanner;

public class Relatorio {
    Scanner input;

    public Relatorio() {
        input = new Scanner(System.in);
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public void relatorioFrutaria(List<Produto> estoqueProdutos) {
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|                  RELATÓRIO DA FRUTARIA                       |");
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("Total de produtos: " + Produto.getTotalProdutos());
        System.out.println("Total de frutas: " + Fruta.getTotalFrutas());
        System.out.println("Total de verduras: " + Verdura.getTotalVerduras());
        double totalReais = 0.0;
        for (Produto p : estoqueProdutos) {
            totalReais += p.getPreco() * p.getQuantidade();
        }
        System.out.println("Total em reais na frutaria: R$ " + String.format("%.2f", totalReais));
        Produto[] ordenados = new Produto[estoqueProdutos.size()];
        for (int i = 0; i < estoqueProdutos.size(); i++) {
            ordenados[i] = estoqueProdutos.get(i);
        }
        for (int i = 0; i < ordenados.length - 1; i++) {
            for (int j = 0; j < ordenados.length - i - 1; j++) {
                if (ordenados[j].getQuantidade() < ordenados[j + 1].getQuantidade()) {
                    Produto temp = ordenados[j];
                    ordenados[j] = ordenados[j + 1];
                    ordenados[j + 1] = temp;
                }
            }
        }
        System.out.println("\nProdutos ordenados por quantidade (ordem decrescente):");
        for (Produto p : ordenados) {
            System.out.println(p.getNome() + " - Quantidade: " + p.getQuantidade());
        }
        String excesso = "";
        String aceitavel = "";
        String falta = "";
        boolean temExcesso = false;
        boolean temAceitavel = false;
        boolean temFalta = false;
        for (Produto p : estoqueProdutos) {
            if (p.getQuantidade() > 20) {
                excesso += p.getNome() + " - Quantidade: " + p.getQuantidade() + "\n";
                temExcesso = true;
            } else if (p.getQuantidade() >= 5 && p.getQuantidade() <= 20) {
                aceitavel += p.getNome() + " - Quantidade: " + p.getQuantidade() + "\n";
                temAceitavel = true;
            } else if (p.getQuantidade() < 5) {
                falta += p.getNome() + " - Quantidade: " + p.getQuantidade() + "\n";
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
        System.out.println("\nTotal de cada tipo de verdura:");
        int totalLegume = 0;
        int totalTuberculo = 0;
        int totalRaiz = 0;
        int totalCereal = 0;
        int totalOleaginosa = 0;
        int totalCondimento = 0;

        for (int j = 0; j < estoqueProdutos.size(); j++) {
            Produto p = estoqueProdutos.get(j);
            if (p.getQuantidade() > 0) {
                totalLegume += p.getQuantidade();
            }
        }

        if (totalLegume > 0)
            System.out.println("LEGUME: " + totalLegume);
        if (totalTuberculo > 0)
            System.out.println("TUBERCULO: " + totalTuberculo);
        if (totalRaiz > 0)
            System.out.println("RAIZ: " + totalRaiz);
        if (totalCereal > 0)
            System.out.println("CEREAL: " + totalCereal);
        if (totalOleaginosa > 0)
            System.out.println("OLEAGINOSA: " + totalOleaginosa);
        if (totalCondimento > 0)
            System.out.println("CONDIMENTO: " + totalCondimento);
    }
}