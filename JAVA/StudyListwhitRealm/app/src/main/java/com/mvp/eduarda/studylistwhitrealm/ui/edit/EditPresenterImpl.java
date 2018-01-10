package com.mvp.eduarda.studylistwhitrealm.ui.edit;

import com.mvp.eduarda.studylistwhitrealm.data.db.ListaDaoImpl;
import com.mvp.eduarda.studylistwhitrealm.data.domain.Lista;
import java.util.List;
import io.realm.Realm;

/**
 * Created by Eduarda on 26/12/2017.
 */

public class EditPresenterImpl implements IEdit.EditarPresenter {
    private IEdit.EditarView editarView;
    private ListaDaoImpl listaDao;
    private List<Lista> resultado;

    public EditPresenterImpl(IEdit.EditarView editarView, ListaDaoImpl listaDaoImpl) {
        this.editarView = editarView;
        this.listaDao = listaDaoImpl;
    }

    @Override
    public void buscarItem(int id) {
        resultado = listaDao.buscarItemLista(id);
        editarView.updateTela(resultado);

    }

    @Override
    public void salvarAlteracao(int id, String descricao) {
        listaDao.editarItemLista(id,descricao);

    }
}
