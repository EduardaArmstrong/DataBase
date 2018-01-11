package com.mvp.eduarda.studylistwhitrealm.ui.edit;

import com.mvp.eduarda.studylistwhitrealm.data.db.ListaDaoImpl;
import com.mvp.eduarda.studylistwhitrealm.data.domain.Lista;
import java.util.List;

/**
 * Created by Eduarda on 26/12/2017.
 */

public class EditPresenterImpl implements IEdit.EditarPresenter {
    private IEdit.EditarView editarView;
    private ListaDaoImpl listaDaoImpl;
    private List<Lista> result;

    public EditPresenterImpl(IEdit.EditarView editarView, ListaDaoImpl listaDaoImpl) {
        this.editarView = editarView;
        this.listaDaoImpl = listaDaoImpl;
    }

    @Override
    public void findItem(int id) {
        result = listaDaoImpl.findItem(id);
        editarView.updateScreen(result);
    }

    @Override
    public void editItem(int id, String item) {
      Lista list = new Lista();
        list.setId(id);
        list.setItem(item);

        listaDaoImpl.editItem(list);
    }
}
