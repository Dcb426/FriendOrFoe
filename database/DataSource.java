package com.mobile_final.friendorfoe.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mobile_final.friendorfoe.model.DataStudent;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private Context mContext;
    private SQLiteDatabase mdatabase;
    private SQLiteOpenHelper mdbHelper;

    public DataSource(Context context) {
        this.mContext = context;
        mdbHelper = new DBhelper(mContext);
        mdatabase = mdbHelper.getWritableDatabase();
    }

    public void open() {
        mdatabase = mdbHelper.getWritableDatabase();
    }

    public void wipe() {
        mdbHelper.onUpgrade(mdatabase, 0, 0);
    }

    public void close() {
        mdbHelper.close();
    }

    public DataStudent createStudent(DataStudent student) {
        ContentValues values = student.toValues();
        mdatabase.insert(StudentsTable.TABLE_STUDENT, null, values);
        return student;
    }

    public List<DataStudent> rawQuery(String S) {
        Cursor cursor = mdatabase.rawQuery(S, new String[]{});
        List<DataStudent> dataStudents = new ArrayList<>();
        while (cursor.moveToNext()) {
            DataStudent student = new DataStudent();
            student.setID(cursor.getString(cursor.getColumnIndex(StudentsTable.COLUMN_ID)));
            student.setName(cursor.getString(cursor.getColumnIndex(StudentsTable.COLUMN_NAME)));
            student.setstudentPhone(cursor.getString(cursor.getColumnIndex(StudentsTable.COLUMN_PHONE)));
            dataStudents.add(student);
        }
        cursor.close();
        return dataStudents;
    }
    public List<DataStudent> getAll(){
        List<DataStudent> dataStudents = new ArrayList<>();
        Cursor cursor = mdatabase.query(StudentsTable.TABLE_STUDENT, StudentsTable.ALL_COL,
                null,null,null,null,"UPPER("+StudentsTable.COLUMN_NAME+")");
        while(cursor.moveToNext()){
            DataStudent student = new DataStudent();
            student.setID(cursor.getString(cursor.getColumnIndex(StudentsTable.COLUMN_ID)));
            student.setName(cursor.getString(cursor.getColumnIndex(StudentsTable.COLUMN_NAME)));
            student.setstudentPhone(cursor.getString(cursor.getColumnIndex(StudentsTable.COLUMN_PHONE)));
            dataStudents.add(student);
        }
        cursor.close();
        return dataStudents;
    }
}

