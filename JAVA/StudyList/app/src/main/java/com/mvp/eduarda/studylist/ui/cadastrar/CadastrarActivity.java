package com.mvp.eduarda.studylist.ui.cadastrar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mvp.eduarda.studylist.R;
import com.mvp.eduarda.studylist.app.StudyList;
import com.mvp.eduarda.studylist.data.domain.Lista;

import java.util.ArrayList;

public class CadastrarActivity extends AppCompatActivity {

    private EditText descricao;
    private Button btSalvarCadastro;
    private CadastrarPresenterImpl cadastrarPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        setTitle("Cadastrar novo conteudo");

        descricao = (EditText) findViewById(R.id.conteudoId);
        btSalvarCadastro = (Button) findViewById(R.id.btSalvarCadastroId);

        cadastrarPresenter = new CadastrarPresenterImpl(StudyList.getInstance().getPreferences());

        btSalvarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoDescricao = descricao.getText().toString();
                if(textoDescricao.isEmpty()){
                    Toast.makeText(CadastrarActivity.this, "Digite um conteudo", Toast.LENGTH_SHORT).show();
                }else{
                    cadastrarPresenter.clickBotaoSalvar(textoDescricao);
                    finish();
                }
            }
        });
    }
}
