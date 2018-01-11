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


public class EditActivity extends AppCompatActivity implements IEdit.EditarView{
    private EditText editContent;
    private Button saveEditButton;
    private int recoverId;
    private EditPresenterImpl editPresenterImpl;
    private String editContentText ="";
    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Title
        setTitle("Editar Conteudo da Lista");

        //recover id
        recoverId = getIntent().getIntExtra("id",0);

        editContent = (EditText) findViewById(R.id.conteudoEditarId);
        saveEditButton = (Button) findViewById(R.id.btSalvarEdicaoId);

        editPresenterImpl = new EditPresenterImpl(this, StudyListwhitRealm.getInstance().getListaDaoImpl());
        editPresenterImpl.findItem(recoverId);

        saveEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editContentText = editContent.getText().toString();

                if(editContentText.isEmpty()){
                    Toast.makeText(EditActivity.this,"Digite o conteudo a ser alterado", Toast.LENGTH_SHORT).show();
                }else{

                    //create an alert dialog
                    dialog = new AlertDialog.Builder(EditActivity.this);

                    //title
                    dialog.setTitle("Editar Conteudo");

                    //message configuration
                    dialog.setMessage("Tem certeza que deseja editar o conteudo ?");

                    //do not allow canceling the message when clicking away
                    dialog.setCancelable(false);

                    //icone
                    dialog.setIcon(android.R.drawable.ic_dialog_info);

                    //no button
                    dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });

                    //yes button
                    dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            editPresenterImpl.editItem(recoverId,editContentText);
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
    public void updateScreen(List<Lista> listResult) {
        String subject="";
        for(int i =0 ; i< listResult.size(); i++){
            subject = listResult.get(i).getItem();
        }
        editContent.setText(subject);
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
