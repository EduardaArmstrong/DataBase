package com.mvp.eduarda.studylistwhitrealm.ui.main.adapter;

import android.support.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mvp.eduarda.studylistwhitrealm.R;
import com.mvp.eduarda.studylistwhitrealm.data.domain.Lista;
import java.util.List;

/**
 * Created by Eduarda on 26/12/2017.
 */

public class ListItemAdapter extends BaseQuickAdapter<Lista, BaseViewHolder> {
    public ListItemAdapter(@Nullable List<Lista> data) {
        super(R.layout.recycler_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Lista item) {
        helper.setText(R.id.id, String.valueOf(item.getId()));
        helper.setText(R.id.descricao, item.getItem());
        helper.addOnClickListener(R.id.deletar);
        helper.addOnClickListener(R.id.editar);


    }
}
