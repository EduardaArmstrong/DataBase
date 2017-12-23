package com.mvp.eduarda.studylist.ui.main;

import com.mvp.eduarda.studylist.data.domain.Lista;
import com.mvp.eduarda.studylist.data.model.DBModel;
import com.mvp.eduarda.studylist.data.prefs.Preferences;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eduarda on 22/12/2017.
 */

public class MainPresenterImpl implements IMain.MainPresenter {

    private IMain.MainView mainView;
    private DBModel dbModel;
    private List<Lista> resultado = new ArrayList<Lista>();

    public MainPresenterImpl(IMain.MainView mainView, Preferences preferences ) {
        this.mainView = mainView;
        this.dbModel = new DBModel(preferences);
    }

    @Override
    public void clickBotaoExcluir(int id) {
        dbModel.Excluir(id);

    }

    @Override
    public void buscarLista() {
       resultado = dbModel.ListarTodos();
       mainView.updateLista(resultado);
    }
}
