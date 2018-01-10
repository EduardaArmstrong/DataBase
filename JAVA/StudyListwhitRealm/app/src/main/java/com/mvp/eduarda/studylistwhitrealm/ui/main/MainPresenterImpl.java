package com.mvp.eduarda.studylistwhitrealm.ui.main;

import android.content.Context;

import com.mvp.eduarda.studylistwhitrealm.data.db.ListaDaoImpl;
import com.mvp.eduarda.studylistwhitrealm.data.domain.Lista;
import com.mvp.eduarda.studylistwhitrealm.data.prefs.Preferences;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eduarda on 26/12/2017.
 */

public class MainPresenterImpl implements IMain.MainPresenter{
    private IMain.MainView mainView;
    private ListaDaoImpl listaDao;
    private List<Lista> resultado = new ArrayList<Lista>();
    private boolean estadoFlag;
    private Preferences preferences;

    public MainPresenterImpl(IMain.MainView mainView, Context context) {
        this.mainView = mainView;
        this.listaDao = new ListaDaoImpl(context);
        this.preferences = new Preferences(context);
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
