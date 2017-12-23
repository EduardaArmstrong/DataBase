package com.mvp.eduarda.studylist.ui.main.Adapter;

import java.io.Serializable;

/**
 * Created by Eduarda on 22/12/2017.
 */

public class Item implements Serializable{

    int id;
    String descricao;

    public Item(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
