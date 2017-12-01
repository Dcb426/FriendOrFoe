package com.mobile_final.friendorfoe.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBhelper extends SQLiteOpenHelper{

    private static final  String DB_FILE_NAME = "gamestates.db";
    private static final int DB_VERSION = 1;

    DBhelper(Context context) {
        super(context, DB_FILE_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(StudentsTable.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(StudentsTable.SQL_DELETE);
        onCreate(db);
    }
}

