package app.bolsofundo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import app.bolsofundo.R;
import app.bolsofundo.dao.MovimentacaoDAO;

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
        MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
        ListView listViewMovimentacoes = findViewById(R.id.activity_movimentacoes);
        listViewMovimentacoes.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, movimentacaoDAO.listarMovimentacoes()));
    }
}
