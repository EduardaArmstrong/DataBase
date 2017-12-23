package com.mvp.eduarda.studylist.ui.cadastrar;

import com.mvp.eduarda.studylist.data.model.DBModel;
import com.mvp.eduarda.studylist.data.prefs.Preferences;

/**
 * Created by Eduarda on 22/12/2017.
 */

public class CadastrarPresenterImpl implements ICadastrar.CadastrarPresenter {
    private DBModel dbModel;

    public CadastrarPresenterImpl(Preferences preferences) {
        this.dbModel = new DBModel(preferences);
    }

    @Override
    public void clickBotaoSalvar(String descricao) {
        dbModel.Cadastrar(descricao);
    }
}
