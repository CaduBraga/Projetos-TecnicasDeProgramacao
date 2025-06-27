package br.com.appFrutaria.model.verduras;

import br.com.appFrutaria.model.Produto;

public class Verdura extends Produto {

    private TipoVerdura tipo;

    public Verdura(TipoVerdura tipo) {
        this.tipo = tipo;
    }
    public TipoVerdura getTipo() {
        return tipo;
    }

    public void setTipo(TipoVerdura tipo) {
        this.tipo = tipo;
    }
}