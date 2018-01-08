package com.mvp.eduarda.studylistwhitrealm.ui.main.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import com.mvp.eduarda.studylistwhitrealm.data.domain.Lista;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;

/**
 * Created by Eduarda on 26/12/2017.
 */

public class ListItemAdapter extends RealmBaseAdapter<Lista> implements ListAdapter {
    public ListItemAdapter(@Nullable OrderedRealmCollection<Lista> data) {
        super(data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
