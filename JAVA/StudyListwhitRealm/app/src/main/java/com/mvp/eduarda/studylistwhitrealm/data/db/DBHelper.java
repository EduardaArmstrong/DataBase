package com.mvp.eduarda.studylistwhitrealm.data.db;

import com.mvp.eduarda.studylistwhitrealm.data.domain.Lista;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Eduarda on 27/12/2017.
 */

public class DBHelper {
    private Realm realm;

    public DBHelper(Realm realm) {
        this.realm = realm;

    }

    public RealmResults<Lista> listarItens() {

        return null;
    }

    public RealmResults<Lista> buscarItemLista(int id) {

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