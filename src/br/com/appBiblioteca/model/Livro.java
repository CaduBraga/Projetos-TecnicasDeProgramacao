package br.com.appBiblioteca.model;

import java.util.Date;


public class Livro {
    private String nome;
    private String autor;
    private String genero;
    private String editora;
    private int paginas;
    private int quantidade;

    public Livro() {
        this.nome = "";
        this.autor = "";
        this.genero = "";
        this.editora = "";
        this.paginas = 0;
        this.quantidade = 0;
    }

    public Livro(String nome, double autor, String genero, String editora, int paginas, int quantidade) {
        this.nome = "";
        this.autor = "";
        this.genero = "";
        this.editora = "";
        this.paginas = 0;
        this.quantidade = 0;
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
}