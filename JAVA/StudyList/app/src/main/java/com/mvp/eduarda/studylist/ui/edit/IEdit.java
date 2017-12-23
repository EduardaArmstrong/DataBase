package com.mvp.eduarda.studylist.ui.edit;

import com.mvp.eduarda.studylist.data.domain.Lista;

import java.util.ArrayList;

/**
 * Created by Eduarda on 22/12/2017.
 */

public interface IEdit {

    interface EditarView{
        void updateTela(ArrayList<Lista> listaResultado);
    }

    interface  EditarPresenter{
        void buscarItem(int id);
        void clickBotaoSalvarAlteracao(int id , String descricao);
    }
}
