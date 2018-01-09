package com.mvp.eduarda.studylistwhitrealm.data.domain;

import io.realm.Realm;
import io.realm.RealmList;
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
    private String detalhes;

    public Lista() {
    }

    public Lista(long id, String detalhes) {
        this.id = id;
        this.detalhes = detalhes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
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
