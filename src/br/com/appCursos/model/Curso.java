package br.com.appCursos.model;

public class Curso {
    private String nome;
    private int duracaoHoras;
    private String coordenador;
    private String nivel;
    private int vagas;
    private double preco;
    private static int totalCursos = 0;

    public Curso() {
        this.nome = "";
        this.duracaoHoras = 0;
        this.coordenador = "";
        this.nivel = "";
        this.vagas = 0;
        this.preco = 0.0;
    }

    public Curso(String nome, int duracaoHoras, String coordenador, String nivel, int vagas, double preco) {
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
        this.coordenador = coordenador;
        this.nivel = nivel;
        this.vagas = vagas;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracaoHoras() {
        return duracaoHoras;
    }

    public void setDuracaoHoras(int duracaoHoras) {
        this.duracaoHoras = duracaoHoras;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public static int getTotalCursos() {
        return totalCursos;
    }

    public static void setTotalCursos(int totalCursos) {
        Curso.totalCursos = totalCursos;
    }

    public static void adicionarCursos(int quantidade) {
        totalCursos += quantidade;
    }

    public static void removerCursos(int quantidade) {
        totalCursos -= quantidade;
    }

    public static void removerCursoEspecifico(int quantidade) {
        quantidade -= quantidade;
    }
}