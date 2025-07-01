package br.com.appBiblioteca.model;

public class Livro {
    private String nome;
    private String autor;
    private String genero;
    private String editora;
    private int paginas;
    private int quantidade;
    private double preco;
    private static int totalLivros = 0;

    public Livro() {
        this.nome = "";
        this.autor = "";
        this.genero = "";
        this.editora = "";
        this.paginas = 0;
        this.quantidade = 0;
        this.preco = 0.0;
    }

    public Livro(String nome, String autor, String genero, String editora, int paginas, int quantidade, double preco) {
        this.nome = nome;
        this.autor = autor;
        this.genero = genero;
        this.editora = editora;
        this.paginas = paginas;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
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

    public static int getTotalLivros() {
        return totalLivros;
    }

    public static void setTotalLivros(int totalLivros) {
        Livro.totalLivros = totalLivros;
    }

    public static void adicionarLivros(int quantidade) {
        totalLivros += quantidade;
    }

    public static void removerLivros(int quantidade) {
        totalLivros -= quantidade;
    }

    public static void removerLivroEspecifico(int quantidade) {
        quantidade -= quantidade;
    }
}