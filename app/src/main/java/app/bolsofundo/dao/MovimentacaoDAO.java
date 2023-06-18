package app.bolsofundo.dao;

import java.util.ArrayList;
import java.util.List;

import app.bolsofundo.model.Movimentacao;

public class MovimentacaoDAO {

    private final static List<Movimentacao> movimentacoes = new ArrayList<>();
    public void salvar(Movimentacao movimentacao) {
        movimentacoes.add(movimentacao);
    }
    public List<Movimentacao> listarMovimentacoes() {
        return new ArrayList<Movimentacao>(movimentacoes);
    }
}
