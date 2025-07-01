package br.com.appFrutaria.model.verduras;

import br.com.appFrutaria.model.Produto;

public class Verdura extends Produto {

    private TipoVerdura tipo;
    private static int totalVerduras = 0;

    public Verdura(TipoVerdura tipo, int totalVerduras) {
        super();
        this.tipo = tipo;
        this.totalVerduras = totalVerduras;
    }

    public TipoVerdura getTipo() {
        return tipo;
    }

    public void setTipo(TipoVerdura tipo) {
        this.tipo = tipo;
    }

    public static int getTotalVerduras() {
        return totalVerduras;
    }

    public void setTotalVerduras() {
        this.totalVerduras = totalVerduras;
    }

    public static void adicionarVerduras(int quantidade) {
        totalVerduras += quantidade;
    }

    public static void removerVerduras(int quantidade) {
        totalVerduras -= quantidade;
        if (totalVerduras < 0) {
            totalVerduras = 0;
        }
    }
}