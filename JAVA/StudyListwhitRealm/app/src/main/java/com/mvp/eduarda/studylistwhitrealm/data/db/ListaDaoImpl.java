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

        List<Lista> resultado = new ArrayList<Lista>();
        resultado = realm.where(Lista.class).findAll();

        return resultado;
    }

    public List<Lista> buscarItemLista(int id) {

        List<Lista> result = new ArrayList<Lista>() ;
        result = realm.where(Lista.class).equalTo("id", id).findAll();

        return result;
    }

    public void salvarItemLista( String item){

        realm.beginTransaction();
            Lista lista = realm.createObject(Lista.class,String.valueOf(autoIncrementId()));
                lista.setItem(item);
        realm.commitTransaction();

    }

    public void editarItemLista(int id , String item){

        realm.beginTransaction();
            Lista lista = realm.createObject(Lista.class,String.valueOf(id));
                lista.setItem(item);
            realm.copyToRealmOrUpdate(lista);
        realm.commitTransaction();
    }

    public void deletarItemLista(int id ){
        realm.beginTransaction();
             realm.where(Lista.class).equalTo("id",id).findAll();
        realm.commitTransaction();
    }

    public int autoIncrementId(){
        Number idFinal;
        int idNovo = 0;
        try {
            idFinal = realm.where(Lista.class).max("id");

            if(idFinal == null){
                idNovo = 0;
            }else{
                idNovo = idFinal.intValue() + 1;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return idNovo;
    }
}