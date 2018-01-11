package com.mvp.eduarda.studylistwhitrealm.data.db;

import com.mvp.eduarda.studylistwhitrealm.data.domain.Lista;

import java.util.ArrayList;
import java.util.List;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Eduarda on 27/12/2017.
 */

public class ListaDaoImpl {
    private Realm realm;

    public ListaDaoImpl(Realm realm) {
        this.realm = realm;
    }

    public List<Lista> findAllItems() {

        List<Lista> result = realm.where(Lista.class).findAll();

        return result;
    }

    public List<Lista> findItem(int id) {

        List<Lista> result = realm.where(Lista.class).equalTo("id", id).findAll();

        return result;
    }

    public void saveItem( String item){

        realm.beginTransaction();
            Lista obj = new Lista();
                obj.setId(autoIncrementId());
                obj.setItem(item);

                realm.insert(obj);
        realm.commitTransaction();

    }

    public void editItem(Lista list){

        realm.beginTransaction();
            realm.copyToRealmOrUpdate(list);
        realm.commitTransaction();
    }

    public void deleteItem(int id ){
        realm.beginTransaction();
            RealmResults<Lista> result = realm.where(Lista.class).equalTo("id",id).findAll();
            result.deleteAllFromRealm();
        realm.commitTransaction();
    }

    public int autoIncrementId(){
        Number finalId;
        int nextId = 0;
        try {
            finalId = realm.where(Lista.class).max("id");

            if(finalId == null){
                nextId = 0;
            }else{
                nextId = finalId.intValue() + 1;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return nextId;
    }
}