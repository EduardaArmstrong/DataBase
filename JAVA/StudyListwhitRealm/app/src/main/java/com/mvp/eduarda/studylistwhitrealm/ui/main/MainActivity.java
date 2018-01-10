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

import io.realm.Realm;
import io.realm.RealmResults;

import static io.realm.Realm.init;

public class MainActivity extends AppCompatActivity implements IMain.MainView{
    RecyclerView  recyclerView;
    private ImageButton btCadastrar;
    private MainPresenterImpl mainPresenter;
    private ListItemAdapter adapter;
    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCadastrar = (ImageButton) findViewById(R.id.btCadastrarId);
        recyclerView = (RecyclerView) findViewById(R.id.listaStudoId);

        //recuperar componentes
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListItemAdapter(new ArrayList<Lista>());

        mainPresenter = new MainPresenterImpl(this, StudyListwhitRealm.getInstance().getPreferences(), StudyListwhitRealm.getInstance().getListaDaoImpl());
        mainPresenter.verificarFlag("flag");
        mainPresenter.buscarLista();

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                view.getId();
                Lista lista =(Lista) adapter.getData().get(position);
                final int idItem = lista.getId();

                switch (view.getId()){

                    case R.id.editar:

                        Lista itemLista = (Lista) adapter.getData().get(position);
                        Intent intent = new Intent(MainActivity.this, EditActivity.class);
                        intent.putExtra("id", itemLista.getId());
                        startActivity(intent);
                        break;

                    case R.id.deletar:

                        //criar o alert dialog
                        dialog = new AlertDialog.Builder(MainActivity.this);

                        //configurar o título
                        dialog.setTitle("Excluir Conteudo");

                        //configurar a mensagem
                        dialog.setMessage("Tem certeza que deseja excluir esse conteudo ?");

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
                                mainPresenter.excluirItem(idItem);
                                onResume();
                            }
                        });

                        dialog.create();
                        dialog.show();
                        break;
                }
            }
        });

        //botao +
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this , SingUpActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.buscarLista();
    }

    @Override
    public void updateLista(List<Lista> listaresultado) {
        if(!listaresultado.isEmpty()){
            adapter.setNewData(listaresultado);
        }
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void toastBemVindo() {
        Toast.makeText(MainActivity.this, " Bem Vindo ", Toast.LENGTH_LONG).show();
    }

}
