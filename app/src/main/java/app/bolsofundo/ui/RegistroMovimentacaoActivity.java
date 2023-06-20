package app.bolsofundo.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import app.bolsofundo.R;
import app.bolsofundo.dao.MovimentacaoDAO;
import app.bolsofundo.model.Movimentacao;

public class RegistroMovimentacaoActivity extends AppCompatActivity {

    MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_movimentacao);

        setTitle("Registrar movimentação");
        EditText campoTitulo = findViewById(R.id.activity_registro_movimentacao_titulo);
        EditText campoDescricao = findViewById(R.id.activity_registro_movimentacao_descricao);
        EditText campoDataRegistro = findViewById(R.id.activity_registro_movimentacao_data_registro);
        EditText campoValor = findViewById(R.id.activity_registro_movimentacao_valor);
        CheckBox campoReceita = findViewById(R.id.activity_registro_movimentacao_receita);
        Button botaoSalvar = findViewById(R.id.activity_registro_movimentacao_botao_salvar);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String titulo = campoTitulo.getText().toString();
                String descricao = campoDescricao.getText().toString();
                Date dataRegistro = null;
                try {
                    dataRegistro = new SimpleDateFormat("dd/MM/yyyy").parse(campoDataRegistro.getText().toString());
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                if(dataRegistro == null){
                    dataRegistro = new Date();
                }

                float valor = Float.parseFloat(campoValor.getText().toString());
                boolean isReceita = false;

                //Se a movimentação não for do tipo receita, só pode ser despesa, portanto o valor deve ser negativo.
                if(!campoReceita.isChecked()){
                    valor = valor * (-1);
                    isReceita = true;
                }
                Movimentacao novaMovimentacao = new Movimentacao(titulo, descricao, dataRegistro, valor, isReceita);
                movimentacaoDAO.salvar(novaMovimentacao);
                finish();
            }
        });
    }
}