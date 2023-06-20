package app.bolsofundo.model;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;

public class Movimentacao implements Serializable {

    private final String titulo, descricao;
    private final Date dataRegistro;
    private final float valor;
    private final boolean receita;

    public Movimentacao(String titulo, String descricao, Date dataRegistro, float valor, boolean receita) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataRegistro = dataRegistro;
        this.valor = valor;
        this.receita = receita;
    }



    @NonNull
    @Override
    public String toString() {
        return "R$ " + valor + " (" + titulo + ")";
    }
}
