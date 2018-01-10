package com.mvp.eduarda.studylistwhitrealm.app;

import android.app.Application;

import com.mvp.eduarda.studylistwhitrealm.data.db.ListaDaoImpl;
import com.mvp.eduarda.studylistwhitrealm.data.prefs.Preferences;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Eduarda on 26/12/2017.
 */

public class StudyListwhitRealm extends Application {
    private static StudyListwhitRealm singleton;
    private Preferences preferences;
    private ListaDaoImpl listaDaoImpl;

    public StudyListwhitRealm() {
    }

    public Preferences getPreferences(){
        if(preferences == null){
            preferences = new Preferences(singleton) ;
        }
        return preferences;
    }

    public ListaDaoImpl getListaDaoImpl(){
        if(listaDaoImpl == null){
            listaDaoImpl = new ListaDaoImpl(Realm.getDefaultInstance());
        }
        return listaDaoImpl;
    }

    public static StudyListwhitRealm getInstance(){
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        singleton = this;

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("lista.realm")
                .schemaVersion(1)
                .build();
        Realm.setDefaultConfiguration(config);

    }


}
