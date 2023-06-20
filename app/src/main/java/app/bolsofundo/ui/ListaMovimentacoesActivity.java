package app.bolsofundo.ui;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import app.bolsofundo.R;
import app.bolsofundo.dao.MovimentacaoDAO;
import app.bolsofundo.model.Movimentacao;

public class ListaMovimentacoesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimentacoes);

        setTitle("Movimentações");

        FloatingActionButton botaoNovaMovimentacao = findViewById(R.id.activity_floating_action_button);
        botaoNovaMovimentacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaMovimentacoesActivity.this, RegistroMovimentacaoActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        configurarLista();
    }

    public void configurarLista(){
        MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
        ListView listViewMovimentacoes = findViewById(R.id.activity_movimentacoes);
        final List<Movimentacao> movimentacoes = movimentacaoDAO.listarMovimentacoes();
        listViewMovimentacoes.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, movimentacoes));
        listViewMovimentacoes.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                Movimentacao movimentacaoSelecionada = movimentacoes.get(posicao);
                Intent vaiParaRegistroMovimentacaoActivity = new Intent(ListaMovimentacoesActivity.this, RegistroMovimentacaoActivity.class);
                vaiParaRegistroMovimentacaoActivity.putExtra("Movimentação", movimentacaoSelecionada);
                startActivity(vaiParaRegistroMovimentacaoActivity);
            }
        });
    }
}