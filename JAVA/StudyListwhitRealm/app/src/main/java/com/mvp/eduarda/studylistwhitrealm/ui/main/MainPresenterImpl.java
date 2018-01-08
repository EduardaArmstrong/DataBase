package com.mvp.eduarda.studylistwhitrealm.ui.main;

import android.content.Context;

import com.mvp.eduarda.studylistwhitrealm.data.db.DBHelper;

import io.realm.Realm;

/**
 * Created by Eduarda on 26/12/2017.
 */

public class MainPresenterImpl implements IMain.MainPresenter{
    private IMain.MainView mainView;
    private DBHelper dbHelper;

    public MainPresenterImpl(IMain.MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void excluirItem(int id) {

    }

    @Override
    public void buscarLista() {

    }

    @Override
    public void verificarFlag(String key) {

    }
}
