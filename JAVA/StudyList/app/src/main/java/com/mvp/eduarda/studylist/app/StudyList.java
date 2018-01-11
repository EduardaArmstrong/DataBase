package com.mvp.eduarda.studylist.app;

import android.app.Application;

import com.mvp.eduarda.studylist.data.db.ListaDaoImpl;
import com.mvp.eduarda.studylist.data.prefs.Preferences;

/**
 * Created by Eduarda on 17/12/2017.
 */

public class StudyList extends Application {
    private static StudyList singleton;
    private static Preferences preferences;
    private ListaDaoImpl listaDaoImpl;

    public StudyList(){}

    public Preferences getPreferences(){
        if(preferences == null){
            preferences = new Preferences(singleton) ;
        }
        return preferences;
    }

    public ListaDaoImpl getListaDaoImpl(){
        if(listaDaoImpl == null){
            listaDaoImpl = new ListaDaoImpl(singleton);
        }
        return listaDaoImpl;
    }

    public static StudyList getInstance(){
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }
}
