package com.mvp.eduarda.studylist.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.mvp.eduarda.studylist.data.db.ListaDaoImpl;
import com.mvp.eduarda.studylist.data.domain.Lista;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eduarda on 22/12/2017.
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
