package com.mvp.eduarda.studylistwhitrealm.data.db;

import com.mvp.eduarda.studylistwhitrealm.data.domain.Lista;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;


/**
 * Created by Eduarda on 27/12/2017.
 */

public class ListaDaoImpl {
    private Realm realm;

    public ListaDaoImpl(Realm realm) {
        this.realm = realm;
    }

    public List<Lista> listarItens() {

        return null;
    }

    public ArrayList<Lista> buscarItemLista(int id) {

        return null;
    }

    public long salvarItemLista( String item){

        return 0;
    }

    public long editarItemLista(int id , String item){

        return 0;
    }

    public long deletarItemLista(int id ){

        return 0;
    }
}