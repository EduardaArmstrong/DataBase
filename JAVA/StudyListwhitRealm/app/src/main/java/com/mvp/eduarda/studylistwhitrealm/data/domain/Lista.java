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
    private long id;
    private String item;

    public Lista() {
    }

    public Lista(long id, String item) {
        this.id = id;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String detalhes) {
        this.item = item;
    }


    public static Long autoIncrementId(){
        Long id = 1L;
        Realm realm = Realm.getDefaultInstance();
        try {
            id = realm.where(Lista.class).max("id").longValue() + 1;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return id;
    }

}
