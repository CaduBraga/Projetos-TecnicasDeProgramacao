package br.com.appFrutaria.model;

public class Fruta {
    private String nome;
    private double preco;
    private int quantidade;
    private static int totalFrutas = 0;

    public Fruta() {
        this.nome = "";
        this.preco = 0.0;
        this.quantidade = 0;
    }

    public Fruta(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public static int getTotalFrutas() {
        return totalFrutas;
    }

    public static void setTotalFrutas(int totalFrutas) {
        Fruta.totalFrutas = totalFrutas;
    }

    public static void adicionarFrutas(int quantidade) {
        totalFrutas += quantidade;
    }

    public static void removerFrutas(int quantidade) {
        if (totalFrutas - quantidade < 0) {
            totalFrutas = 0;
        } else {
            totalFrutas -= quantidade;
        }
    }
}