package com.mvp.eduarda.studylistwhitrealm.data.db;

import com.mvp.eduarda.studylistwhitrealm.data.domain.Lista;
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

        realm.beginTransaction();
            List<Lista> resultado ;
            resultado = realm.where(Lista.class).findAll();
        realm.commitTransaction();

        return resultado;
    }

    public List<Lista> buscarItemLista(int id) {

        realm.beginTransaction();
            List<Lista> result ;
            result = realm.where(Lista.class).equalTo("Lista.id", id).findAll();
        realm.commitTransaction();

        return result;
    }

    public void salvarItemLista( String item){

        realm.beginTransaction();
            int idSoma = autoIncrementId();
            Lista lista = realm.createObject(Lista.class);
                lista.setId(idSoma);
                lista.setItem(item);
            realm.insert(lista);
        realm.commitTransaction();

    }

    public void editarItemLista(int id , String item){

        realm.beginTransaction();
            Lista lista = realm.createObject(Lista.class);
                lista.setItem(item);
            realm.copyToRealmOrUpdate(lista);
        realm.commitTransaction();
    }

    public void deletarItemLista(int id ){
        realm.beginTransaction();
             realm.where(Lista.class).findAll().deleteFromRealm(id);
        realm.commitTransaction();
    }

    public static int autoIncrementId(){
        int id = 0;
        Realm realm = Realm.getDefaultInstance();
        try {
            id = realm.where(Lista.class).max("id").intValue() + 1;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return id;
    }
}