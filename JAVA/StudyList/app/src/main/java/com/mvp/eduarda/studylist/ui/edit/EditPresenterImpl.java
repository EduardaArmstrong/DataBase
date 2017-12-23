package com.mvp.eduarda.studylist.ui.edit;

import android.content.Context;
import com.mvp.eduarda.studylist.data.db.ListaDaoImpl;
import com.mvp.eduarda.studylist.data.domain.Lista;
import java.util.ArrayList;

/**
 * Created by Eduarda on 22/12/2017.
 */

public class EditPresenterImpl implements IEdit.EditarPresenter {
    private IEdit.EditarView editarView;
    private ListaDaoImpl listaDao;
    private ArrayList<Lista> resultado;

    public EditPresenterImpl(IEdit.EditarView editarView, Context context) {
        this.editarView = editarView;
        this.listaDao = new ListaDaoImpl(context);
    }

    @Override
    public void buscarItem(int id) {
        resultado = listaDao.buscarItemLista(id);
        editarView.updateTela(resultado);

    }

    @Override
    public void clickBotaoSalvarAlteracao(int id, String descricao) {
        listaDao.editarItemLista(id,descricao);

    }
}