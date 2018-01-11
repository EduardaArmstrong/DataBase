package com.mvp.eduarda.studylistwhitrealm.ui.edit;

import com.mvp.eduarda.studylistwhitrealm.data.domain.Lista;
import java.util.List;

/**
 * Created by Eduarda on 26/12/2017.
 */

public interface IEdit {

    interface EditarView{
        void updateScreen(List<Lista> resultList);
    }

    interface  EditarPresenter{
        void findItem(int id);
        void editItem(int id , String item);
    }
}
