package com.mvp.eduarda.studylistwhitrealm.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.mvp.eduarda.studylistwhitrealm.R;
import com.mvp.eduarda.studylistwhitrealm.app.StudyListwhitRealm;
import com.mvp.eduarda.studylistwhitrealm.data.domain.Lista;

import java.util.List;

import io.realm.Realm;

import static io.realm.Realm.init;

public class MainActivity extends AppCompatActivity implements IMain.MainView{
    private Realm realm;
    private MainPresenterImpl mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter = new MainPresenterImpl(this , StudyListwhitRealm.getInstance());
        mainPresenter.verificarFlag("flag");

    }

    @Override
    public void updateLista(List<Lista> listaResultado) {
        
    }

    @Override
    public void toastBemVindo() {
        Toast.makeText(MainActivity.this, " Bem Vindo Realm ", Toast.LENGTH_LONG).show();
    }
}
