package com.mvp.eduarda.studylistwhitrealm.ui.main;

import com.mvp.eduarda.studylistwhitrealm.data.db.ListaDaoImpl;
import com.mvp.eduarda.studylistwhitrealm.data.domain.Lista;
import com.mvp.eduarda.studylistwhitrealm.data.prefs.Preferences;
import java.util.List;

/**
 * Created by Eduarda on 26/12/2017.
 */

public class MainPresenterImpl implements IMain.MainPresenter{
    private IMain.MainView mainView;
    private ListaDaoImpl listaDaoImpl;
    private List<Lista> result;
    private boolean flag;
    private Preferences preferences;

    public MainPresenterImpl(IMain.MainView mainView,Preferences preferences, ListaDaoImpl listaDaoImpl) {
        this.mainView = mainView;
        this.listaDaoImpl = listaDaoImpl;
        this.preferences = preferences;
    }

    @Override
    public void deleteItem(int id) {
        listaDaoImpl.deleteItem(id);
    }

    @Override
    public void findList() {
        result = listaDaoImpl.findAllItems();
        mainView.updateList(result);
    }

    @Override
    public void checkFlag(String key) {
        flag = preferences.findFlag(key);

        if(flag == false){
            preferences.saveFlag("flag", "true");
            mainView.toastWelcome();
        }
    }
}
