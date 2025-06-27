package br.com.appFrutaria.model;

public class Fruta extends Produto {

    private double peso;

    public Fruta(double peso) {
        super();
        this.peso = peso;
    }
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}