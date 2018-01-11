package com.mvp.eduarda.studylistwhitrealm.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Eduarda on 08/01/2018.
 */

public class Preferences {

    private SharedPreferences sharedPreferences;
    private static final String ARQUIVO_FLAG = "arquivoFlag";
    private String status;

    public Preferences(Context context) {
        sharedPreferences = context.getSharedPreferences(ARQUIVO_FLAG, context.MODE_PRIVATE);
    }

    public void saveFlag(String key, String value){
        sharedPreferences.edit()
                .putString(key,value)
                .commit();
    }

    public boolean findFlag(String key){
        status = sharedPreferences.getString(key,"");

        if(status.isEmpty() || status == null){
            return false;
        }else {
            return true;
        }
    }
}
