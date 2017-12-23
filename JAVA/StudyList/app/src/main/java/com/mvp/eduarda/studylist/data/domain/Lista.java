package com.mvp.eduarda.studylist.data.domain;

import java.io.Serializable;

/**
 * Created by Eduarda on 17/12/2017.
 */

public class Lista implements Serializable {

    private int id;
    private String item;

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

    public void setItem(String item) {
        this.item = item;
    }


}
