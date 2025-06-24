package br.com.appSuplementos.model;

import java.util.Date;

public class Suplemento {
    private String nome;
    private double preco;
    private int quantidade;
    private String marca;
    private static int totalSuplementos = 0;

    public Suplemento() {
        this.nome = "";
        this.preco = 0.0;
        this.quantidade = 0;
        this.marca = "";
    }

    public Suplemento(String nome, double preco, int quantidade, String marca) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.marca = marca;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public static int getTotalSuplementos() {
        return totalSuplementos;
    }

    public static void setTotalSuplementos(int totalSuplementos) {
        Suplemento.totalSuplementos = totalSuplementos;
    }

    public static void adicionarSuplementos(int quantidade) {
        totalSuplementos += quantidade;
    }

    public static void removerSuplementos(int quantidade) {
        totalSuplementos -= quantidade;
    }

    public static void removerSuplementoEspecifico(int quantidade) {
        quantidade -= quantidade;
    }
} 