package com.mvp.eduarda.studylistwhitrealm.app;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Eduarda on 26/12/2017.
 */

public class StudyListwhitRealm extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("lista.realm")
                .schemaVersion(1)
                .build();
        Realm.setDefaultConfiguration(config);

    }


}
