package com.mvp.eduarda.studylistwhitrealm.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Eduarda on 08/01/2018.
 */

public class Preferences {

    private SharedPreferences sharedPreferences;
    private static final String ARQUIVO_FLAG = "arquivoFlag";
    private String estado;

    public Preferences(Context context) {
        sharedPreferences = context.getSharedPreferences(ARQUIVO_FLAG, context.MODE_PRIVATE);
    }

    public void salvarFlag(String key, String valor){

        sharedPreferences.edit()
                .putString(key,valor)
                .commit();

    }

    public boolean buscarFlag(String key){
        estado = sharedPreferences.getString(key,"");

        if(estado.isEmpty() || estado == null){
            return false;
        }else {
            return true;
        }
    }

}
