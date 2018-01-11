package com.mvp.eduarda.studylistwhitrealm.ui.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mvp.eduarda.studylistwhitrealm.R;
import com.mvp.eduarda.studylistwhitrealm.app.StudyListwhitRealm;
import com.mvp.eduarda.studylistwhitrealm.data.domain.Lista;
import com.mvp.eduarda.studylistwhitrealm.ui.edit.EditActivity;
import com.mvp.eduarda.studylistwhitrealm.ui.main.adapter.ListItemAdapter;
import com.mvp.eduarda.studylistwhitrealm.ui.singup.SingUpActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IMain.MainView{
    RecyclerView  recyclerView;
    private ImageButton registerButton;
    private MainPresenterImpl mainPresenterImpl;
    private ListItemAdapter adapter;
    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerButton = (ImageButton) findViewById(R.id.btCadastrarId);
        recyclerView = (RecyclerView) findViewById(R.id.listaStudoId);

        //recover components
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListItemAdapter(new ArrayList<Lista>());

        mainPresenterImpl = new MainPresenterImpl(this, StudyListwhitRealm.getInstance().getPreferences(), StudyListwhitRealm.getInstance().getListaDaoImpl());
        mainPresenterImpl.checkFlag("flag");
        mainPresenterImpl.findList();

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                view.getId();
                Lista obj =(Lista) adapter.getData().get(position);
                final int idItem = obj.getId();

                switch (view.getId()){

                    case R.id.editar:

                        Lista itemLista = (Lista) adapter.getData().get(position);
                        Intent intent = new Intent(MainActivity.this, EditActivity.class);
                        intent.putExtra("id", itemLista.getId());
                        startActivity(intent);
                        break;

                    case R.id.deletar:

                        //create an alert dialog
                        dialog = new AlertDialog.Builder(MainActivity.this);

                        //title
                        dialog.setTitle("Excluir Conteudo");

                        //message configuration
                        dialog.setMessage("Tem certeza que deseja excluir esse conteudo ?");

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
                                mainPresenterImpl.deleteItem(idItem);
                                onResume();
                            }
                        });

                        dialog.create();
                        dialog.show();
                        break;
                }
            }
        });

        // + button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this , SingUpActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenterImpl.findList();
    }

    @Override
    public void updateList(List<Lista> resultList) {
        if(!resultList.isEmpty()){
            adapter.setNewData(resultList);
        }
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void toastWelcome() {
        Toast.makeText(MainActivity.this, " Bem Vindo Realm", Toast.LENGTH_LONG).show();
    }

}
