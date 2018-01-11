package com.mvp.eduarda.studylistwhitrealm.ui.singup;

import com.mvp.eduarda.studylistwhitrealm.data.db.ListaDaoImpl;

/**
 * Created by Eduarda on 26/12/2017.
 */

public class SingUpPresenterImpl implements ISingUp.CadastrarPresenter {
    private ListaDaoImpl listaDao;

    public SingUpPresenterImpl(ListaDaoImpl listaDaoImpl) {
        this.listaDao = listaDaoImpl;
    }

    @Override
    public void saveItem(String item) {
        listaDao.saveItem(item);
    }
}
