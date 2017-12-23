package com.mvp.eduarda.studylist.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.mvp.eduarda.studylist.data.domain.Lista;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eduarda on 17/12/2017.
 */

public class ListaDaoImpl extends MyDao {

    public ListaDaoImpl(Context context) {
        super(context);
    }

    private Lista createLista(Cursor cursor){
        Lista model = new Lista(
                cursor.getInt(cursor.getColumnIndex(DBHelper.Lista.ID)),
                cursor.getString(cursor.getColumnIndex(DBHelper.Lista.ITEM))

        );

        return model;
    }

    public List<Lista> listarItens(){
        Cursor cursor = getDatabase().query(DBHelper.Lista.TABELA, DBHelper.Lista.COLUNAS,
                null,null,null,null,DBHelper.Lista.ID);

        if(cursor != null){
            List<Lista> listaItens = new ArrayList<Lista>();
            while(cursor.moveToNext()){
                Lista model = createLista(cursor);
                listaItens.add(model);
            }
            cursor.close();
            return listaItens;
        }else{
            return null;
        }
    }

    public ArrayList<Lista> buscarItemLista(int id){
        Cursor cursor = getDatabase().query(DBHelper.Lista.TABELA,DBHelper.Lista.COLUNAS,
                "id = ?" , new String[]{String.valueOf(id)}, null,null,null);

        if(cursor != null){
            ArrayList<Lista> lista = new ArrayList<Lista>();
            while (cursor.moveToNext()){
                Lista model = createLista(cursor);
                lista.add(model);
            }
            cursor.close();
            return lista;
        }else{
            return null;
        }
    }


    public long salvarItemLista( String item){
        ContentValues valores = new ContentValues();
        valores.put(DBHelper.Lista.ITEM, item);

        return getDatabase().insert(DBHelper.Lista.TABELA, null,valores);
    }


    public long editarItemLista(int id , String item){
        ContentValues valores = new ContentValues();
        valores.put(DBHelper.Lista.ITEM , item);

        return getDatabase().update(DBHelper.Lista.TABELA, valores, "id = ?" , new String[]{String.valueOf(id)});
    }

    public long deletarItemLista(int id ){

       return  getDatabase().delete(DBHelper.Lista.TABELA, "id = ?", new String[]{String.valueOf(id)});

    }


}
