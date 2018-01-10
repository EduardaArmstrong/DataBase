package com.mvp.eduarda.studylistwhitrealm.ui.edit;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.mvp.eduarda.studylistwhitrealm.R;
import com.mvp.eduarda.studylistwhitrealm.app.StudyListwhitRealm;
import com.mvp.eduarda.studylistwhitrealm.data.domain.Lista;
import java.util.List;

import io.realm.Realm;

public class EditActivity extends AppCompatActivity implements IEdit.EditarView{
    private EditText conteudoEditar;
    private Button btSalvarEditar;
    private int idReduperado;
    private EditPresenterImpl editarPresenter;
    private String textoConteudoEditar ="";
    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        //Mostra flecha voltar na action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Titulo
        setTitle("Editar Conteudo da Lista");

        //recupera o id
        idReduperado = getIntent().getIntExtra("id",0);

        conteudoEditar = (EditText) findViewById(R.id.conteudoEditarId);
        btSalvarEditar = (Button) findViewById(R.id.btSalvarEdicaoId);

        editarPresenter = new EditPresenterImpl(this, StudyListwhitRealm.getInstance().getListaDaoImpl());
        editarPresenter.buscarItem(idReduperado);

        btSalvarEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoConteudoEditar = conteudoEditar.getText().toString();

                if(textoConteudoEditar.isEmpty()){
                    Toast.makeText(EditActivity.this,"Digite o conteudo a ser alterado", Toast.LENGTH_SHORT).show();
                }else{

                    //criar o alert dialog
                    dialog = new AlertDialog.Builder(EditActivity.this);

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
                            editarPresenter.salvarAlteracao(idReduperado,textoConteudoEditar);
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
    public void updateTela(List<Lista> listaResultado) {
        String materia="";
        for(int i =0 ; i< listaResultado.size(); i++){
            materia = listaResultado.get(i).getItem();
        }
        conteudoEditar.setText(materia);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return  false;
    }


}
