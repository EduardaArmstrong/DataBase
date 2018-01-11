package com.mvp.eduarda.studylist.ui.singup;

import android.content.Context;

import com.mvp.eduarda.studylist.app.StudyList;
import com.mvp.eduarda.studylist.data.db.ListaDaoImpl;

/**
 * Created by Eduarda on 22/12/2017.
 */

public class SingUpPresenterImpl implements ISingUp.CadastrarPresenter {
    private ListaDaoImpl listaDao;

    public SingUpPresenterImpl(ListaDaoImpl listaDaoImpl) {
        this.listaDao = listaDaoImpl;
    }

    @Override
    public void salvarItem(String descricao) {
        listaDao.salvarItemLista(descricao);
    }
}
