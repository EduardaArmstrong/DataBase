package com.mvp.eduarda.studylist.ui.editar;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
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

public class EditarActivity extends AppCompatActivity implements IEditar.EditarView{
    private EditText conteudoEditar;
    private Button btSalvarEditar;
    private int idReduperado;
    private EditarPresenterImpl editarPresenter;
    private String textoConteudoEditar ="";
    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        setTitle("Editar Conteudo da Lista");

        //recupera o id
        idReduperado = getIntent().getIntExtra("id",0);

        conteudoEditar = (EditText) findViewById(R.id.conteudoEditarId);
        btSalvarEditar = (Button) findViewById(R.id.btSalvarEdicaoId);

        editarPresenter = new EditarPresenterImpl(this, StudyList.getInstance().getPreferences());
        editarPresenter.buscarItem(idReduperado);

        textoConteudoEditar = conteudoEditar.getText().toString();

        btSalvarEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(textoConteudoEditar.isEmpty()){
                    Toast.makeText(EditarActivity.this,"Digite o conteudo a ser alterado", Toast.LENGTH_SHORT).show();
                }else{

                    //criar o alert dialog
                    dialog = new AlertDialog.Builder(EditarActivity.this);

                    //configurar o título
                    dialog.setTitle("Editar Conteudo");

                    //configurar a mensagem
                    dialog.setMessage("Tem certeza que deseja editar o conteudo ?");

                    //não permite cancelar a dialog se clicar fora
                    dialog.setCancelable(false);

                    //definir um icone
                    dialog.setIcon(android.R.drawable.ic_dialog_info);

                    //configurar os botoes
                    //botao não
                    dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });

                    //botao sim
                    dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            editarPresenter.clickBotaoSalvarAlteracao(idReduperado,textoConteudoEditar);
                            finish();
                        }
                    });

                    dialog.create();
                    dialog.show();

                }
            }
        });
    }

    @Override
    public void updateTela(ArrayList<Lista> listaResultado) {
        String materia="";
        for(int i =0 ; i< listaResultado.size(); i++){
            materia = listaResultado.get(i).getItem();
        }
        conteudoEditar.setText(materia);
    }
}
