package com.mvp.eduarda.studylistwhitrealm.data.domain;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Eduarda on 26/12/2017.
 */

public class Lista extends RealmObject {

    @Required
    @PrimaryKey
    private int id;
    private String item;

    public Lista() {
    }

    public Lista(int id, String item) {
        this.id = id;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String detalhes) {
        this.item = item;
    }


}
