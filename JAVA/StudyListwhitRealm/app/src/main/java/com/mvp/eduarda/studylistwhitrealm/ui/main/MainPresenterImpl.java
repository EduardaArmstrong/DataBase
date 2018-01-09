package com.mvp.eduarda.studylistwhitrealm.ui.main;

import android.content.Context;

import com.mvp.eduarda.studylistwhitrealm.data.db.DBHelper;
import com.mvp.eduarda.studylistwhitrealm.data.domain.Lista;
import com.mvp.eduarda.studylistwhitrealm.data.prefs.Preferences;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Eduarda on 26/12/2017.
 */

public class MainPresenterImpl implements IMain.MainPresenter{
    private IMain.MainView mainView;
    private DBHelper dbHelper;
    private boolean estadoFlag;
    private Preferences preferences;
    private RealmResults<Lista> resultado;

    public MainPresenterImpl(IMain.MainView mainView , Context context , Realm realm) {
        this.mainView = mainView;
        this.preferences = new Preferences(context);
        this.dbHelper = new DBHelper(realm);
    }

    @Override
    public void excluirItem(int id) {
        dbHelper.deletarItemLista(id);

    }

    @Override
    public void buscarLista() {
        resultado = dbHelper.listarItens();
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
