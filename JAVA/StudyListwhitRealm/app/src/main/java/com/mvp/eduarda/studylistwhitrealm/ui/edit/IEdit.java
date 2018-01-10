package com.mvp.eduarda.studylistwhitrealm.ui.edit;

import com.mvp.eduarda.studylistwhitrealm.data.domain.Lista;

import java.util.ArrayList;

import io.realm.RealmResults;

/**
 * Created by Eduarda on 26/12/2017.
 */

public interface IEdit {

    interface EditarView{
        void updateTela(ArrayList<Lista> listaResultado);
    }

    interface  EditarPresenter{
        void buscarItem(int id);
        void salvarAlteracao(int id , String descricao);
    }
}
