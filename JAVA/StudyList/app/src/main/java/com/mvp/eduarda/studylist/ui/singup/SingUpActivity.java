package com.mvp.eduarda.studylist.ui.singup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mvp.eduarda.studylist.R;
import com.mvp.eduarda.studylist.app.StudyList;

public class SingUpActivity extends AppCompatActivity {

    private EditText descricao;
    private Button btSalvarCadastro;
    private SingUpPresenterImpl cadastrarPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        setTitle("Cadastrar novo conteudo");

        descricao = (EditText) findViewById(R.id.conteudoId);
        btSalvarCadastro = (Button) findViewById(R.id.btSalvarCadastroId);

        cadastrarPresenter = new SingUpPresenterImpl(StudyList.getInstance());

        btSalvarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoDescricao = descricao.getText().toString();
                if(textoDescricao.isEmpty()){
                    Toast.makeText(SingUpActivity.this, "Digite um conteudo", Toast.LENGTH_SHORT).show();
                }else{
                    cadastrarPresenter.salvarItem(textoDescricao);
                    finish();
                }
            }
        });
    }
}
