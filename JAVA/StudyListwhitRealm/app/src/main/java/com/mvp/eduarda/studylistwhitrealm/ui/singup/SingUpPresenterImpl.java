package com.mvp.eduarda.studylistwhitrealm.ui.singup;

import android.content.Context;

import com.mvp.eduarda.studylistwhitrealm.app.StudyListwhitRealm;
import com.mvp.eduarda.studylistwhitrealm.data.db.ListaDaoImpl;

import io.realm.Realm;

/**
 * Created by Eduarda on 26/12/2017.
 */

public class SingUpPresenterImpl implements ISingUp.CadastrarPresenter {
    private ListaDaoImpl listaDao;

    public SingUpPresenterImpl(Realm realm) {
        this.listaDao = new ListaDaoImpl(realm);
    }

    @Override
    public void salvarItem(String descricao) {
        listaDao.salvarItemLista(descricao);
    }
}
