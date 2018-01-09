package com.mvp.eduarda.studylistwhitrealm.ui.main;

import com.mvp.eduarda.studylistwhitrealm.data.domain.Lista;

import java.util.List;

import io.realm.RealmResults;

/**
 * Created by Eduarda on 26/12/2017.
 */

public interface IMain {

    interface MainView{
        void updateLista(RealmResults<Lista> listaResultado);
        void toastBemVindo();

    }

    interface MainPresenter{
        void excluirItem(int id);
        void buscarLista();
        void verificarFlag(String key);

    }
}
