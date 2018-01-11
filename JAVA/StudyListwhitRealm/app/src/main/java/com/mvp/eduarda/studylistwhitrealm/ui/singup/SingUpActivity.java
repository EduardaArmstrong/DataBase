package com.mvp.eduarda.studylistwhitrealm.ui.singup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.mvp.eduarda.studylistwhitrealm.R;
import com.mvp.eduarda.studylistwhitrealm.app.StudyListwhitRealm;

public class SingUpActivity extends AppCompatActivity {
    private EditText description;
    private Button saveButton;
    private SingUpPresenterImpl singUpPresenterImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        //title
        setTitle("Cadastrar novo conteudo");

        description = (EditText) findViewById(R.id.conteudoId);
        saveButton = (Button) findViewById(R.id.btSalvarCadastroId);

        singUpPresenterImpl = new SingUpPresenterImpl(StudyListwhitRealm.getInstance().getListaDaoImpl());

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String descriptionText = description.getText().toString();
                if(descriptionText.isEmpty()){
                    Toast.makeText(SingUpActivity.this, "Digite um conteudo", Toast.LENGTH_SHORT).show();
                }else{
                    singUpPresenterImpl.saveItem(descriptionText);
                    finish();
                }
            }
        });
    }
}
