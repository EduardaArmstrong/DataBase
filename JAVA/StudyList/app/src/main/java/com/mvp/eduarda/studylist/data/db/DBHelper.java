package com.mvp.eduarda.studylist.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Eduarda on 17/12/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "listStudy";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_LISTA =
            "CREATE TABLE IF NOT EXISTS lista ("+
                    "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "item VARCHAR (30));";

    public DBHelper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        createTables(db);
    }

    private void createTables(SQLiteDatabase db) {
        db.execSQL(TABLE_LISTA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public static class Lista{
        public  static  final  String TABELA = "lista";
        public  static  final  String ID = "id";
        public  static  final  String ITEM = "item";

        public static final String[] COLUNAS = new String[]{
                ID,ITEM
        };
    }

}
