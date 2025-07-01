package br.com.appFrutaria.model;

public class Produto {
    protected String nome;
    protected double preco;
    protected int quantidade;
    protected static int totalProdutos = 0;

    public Produto() {
        this.nome = "";
        this.preco = 0.0;
        this.quantidade = 0;
    }

    public Produto(String nome, double preco, int quantidade) {
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

    public static int getTotalProdutos() {
        return totalProdutos;
    }

    public static void setTotalProdutos(int totalProdutos) {
        Produto.totalProdutos = totalProdutos;
    }

    public static void adicionarProdutos(int quantidade) {
        totalProdutos += quantidade;
    }

    public static void removerProdutos(int quantidade) {
        totalProdutos -= quantidade;
        if (totalProdutos < 0) {
            totalProdutos = 0;
        }
    }
}