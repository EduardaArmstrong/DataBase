package com.mvp.eduarda.studylist.ui.editar;

import com.mvp.eduarda.studylist.data.domain.Lista;
import com.mvp.eduarda.studylist.data.model.DBModel;
import com.mvp.eduarda.studylist.data.prefs.Preferences;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eduarda on 22/12/2017.
 */

public class EditarPresenterImpl implements IEditar.EditarPresenter {
    private IEditar.EditarView editarView;
    private DBModel dbModel;
    private ArrayList<Lista> resultado;

    public EditarPresenterImpl(IEditar.EditarView editarView, Preferences preferences) {
        this.editarView = editarView;
        this.dbModel = new DBModel(preferences);
    }

    @Override
    public void buscarItem(int id) {
        resultado = dbModel.BuscarItem(id);
        editarView.updateTela(resultado);

    }

    @Override
    public void clickBotaoSalvarAlteracao(int id, String descricao) {
        dbModel.Editar(id,descricao);

    }
}
