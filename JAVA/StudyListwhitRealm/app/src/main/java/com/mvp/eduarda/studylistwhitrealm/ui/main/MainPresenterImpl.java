package com.mvp.eduarda.studylistwhitrealm.ui.main;

import android.content.Context;

import com.mvp.eduarda.studylistwhitrealm.data.db.ListaDaoImpl;
import com.mvp.eduarda.studylistwhitrealm.data.domain.Lista;
import com.mvp.eduarda.studylistwhitrealm.data.prefs.Preferences;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

/**
 * Created by Eduarda on 26/12/2017.
 */

public class MainPresenterImpl implements IMain.MainPresenter{
    private IMain.MainView mainView;
    private ListaDaoImpl listaDao;
    private List<Lista> resultado ;
    private boolean estadoFlag;
    private Preferences preferences;

    public MainPresenterImpl(IMain.MainView mainView,Preferences preferences, ListaDaoImpl listaDaoImpl) {
        this.mainView = mainView;
        this.listaDao = listaDaoImpl;
        this.preferences = preferences;
    }

    @Override
    public void excluirItem(int id) {
        listaDao.deletarItemLista(id);

    }

    @Override
    public void buscarLista() {
        resultado = listaDao.listarItens();
        mainView.updateLista(resultado);
    }

    @Override
    public void verificarFlag(String key) {
        estadoFlag = preferences.buscarFlag(key);

        if(estadoFlag == false){
            preferences.salvarFlag("flag", "true");
            mainView.toastBemVindo();
        }
    }
}
