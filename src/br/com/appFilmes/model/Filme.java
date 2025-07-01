package br.com.appFilmes.model;

public class Filme {
    private String titulo;
    private String genero;
    private int duracao;
    private int anoLancamento;
    private String diretor;
    private int quantidade;
    private double preco;
    private static int totalFilmes = 0;

    public Filme() {
        this.titulo = "";
        this.genero = "";
        this.duracao = 0;
        this.anoLancamento = 0;
        this.diretor = "";
        this.quantidade = 0;
        this.preco = 0.0;
    }

    public Filme(String titulo, String genero, int duracao, int anoLancamento, String diretor, int quantidade,
            double preco) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.diretor = diretor;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public static int getTotalFilmes() {
        return totalFilmes;
    }

    public static void setTotalFilmes(int totalFilmes) {
        Filme.totalFilmes = totalFilmes;
    }

    public static void adicionarFilmes(int quantidade) {
        totalFilmes += quantidade;
    }

    public static void removerFilmes(int quantidade) {
        totalFilmes -= quantidade;
    }

    public static void removerFilmeEspecifico(int quantidade) {
        quantidade -= quantidade;
    }
}