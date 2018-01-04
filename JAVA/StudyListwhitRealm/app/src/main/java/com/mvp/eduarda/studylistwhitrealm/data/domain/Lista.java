package com.mvp.eduarda.studylistwhitrealm.data.domain;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Eduarda on 26/12/2017.
 */

public class Lista extends RealmObject {

    @PrimaryKey
    private int id;
    private String detalhes;

    public Lista() {
    }

    public Lista(int id, String detalhes) {
        this.id = id;
        this.detalhes = detalhes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
}
