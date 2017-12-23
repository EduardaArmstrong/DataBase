package com.mvp.eduarda.studylist.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Eduarda on 17/12/2017.
 */

public abstract class MyDao {

    protected DBHelper databaseHelper;
    protected SQLiteDatabase database;

    public MyDao(Context context){
        databaseHelper = new DBHelper(context);
    }

    protected SQLiteDatabase getDatabase(){
        if(database == null){
            database = databaseHelper.getWritableDatabase();
        }

        return database;
    }

    public void fechar(){
        databaseHelper.close();
        database = null;
    }
}
