package br.com.appFrutaria.model;

public class Fruta extends Produto {

    private double peso;
    private static int totalFrutas = 0;

    public Fruta(double peso, int totalFrutas) {
        super();
        this.peso = peso;
        this.totalFrutas = totalFrutas;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public static int getTotalFrutas() {
        return totalFrutas;
    }

    public void setTotalFrutas() {
        this.totalFrutas = totalFrutas;
    }

    public static void adicionarFrutas(int quantidade) {
        totalFrutas += quantidade;
    }

    public static void removerFrutas(int quantidade) {
        totalFrutas -= quantidade;
        if (totalFrutas < 0) {
            totalFrutas = 0;
        }
    }
}