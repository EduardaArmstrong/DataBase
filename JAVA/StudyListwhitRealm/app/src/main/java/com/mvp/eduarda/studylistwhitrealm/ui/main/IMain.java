package com.mvp.eduarda.studylistwhitrealm.ui.main;

import com.mvp.eduarda.studylistwhitrealm.data.domain.Lista;
import java.util.List;

/**
 * Created by Eduarda on 26/12/2017.
 */

public interface IMain {

    interface MainView{
        void updateList(List<Lista> listResult);
        void toastWelcome();

    }

    interface MainPresenter{
        void deleteItem(int id);
        void findList();
        void checkFlag(String key);

    }
}
