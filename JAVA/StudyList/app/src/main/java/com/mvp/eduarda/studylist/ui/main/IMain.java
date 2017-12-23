package com.mvp.eduarda.studylist.ui.main;

import com.mvp.eduarda.studylist.data.domain.Lista;
import java.util.List;

/**
 * Created by Eduarda on 22/12/2017.
 */

public interface IMain {

    interface MainView{
        void updateLista(List<Lista> listaResultado);
        void toastBemVindo();

    }

    interface MainPresenter{
        void clickBotaoExcluir(int id);
        void buscarLista();
        void verificarFlag(String key);

    }

}
