package com.mvp.eduarda.studylist.ui.cadastrar;

import com.mvp.eduarda.studylist.data.domain.Lista;

import java.util.ArrayList;

/**
 * Created by Eduarda on 22/12/2017.
 */

public interface ICadastrar {

    interface CadastrarPresenter{

        void clickBotaoSalvar(String descricao);
    }

}
