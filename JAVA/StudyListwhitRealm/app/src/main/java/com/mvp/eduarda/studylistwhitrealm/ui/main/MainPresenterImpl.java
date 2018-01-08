package com.mvp.eduarda.studylistwhitrealm.ui.main;

import android.content.Context;

import com.mvp.eduarda.studylistwhitrealm.data.db.DBHelper;
import com.mvp.eduarda.studylistwhitrealm.data.prefs.Preferences;

import io.realm.Realm;

/**
 * Created by Eduarda on 26/12/2017.
 */

public class MainPresenterImpl implements IMain.MainPresenter{
    private IMain.MainView mainView;
    private DBHelper dbHelper;
    private boolean estadoFlag;
    private Preferences preferences;

    public MainPresenterImpl(IMain.MainView mainView , Context context) {
        this.mainView = mainView;
        this.preferences = new Preferences(context);
    }

    @Override
    public void excluirItem(int id) {

    }

    @Override
    public void buscarLista() {

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
