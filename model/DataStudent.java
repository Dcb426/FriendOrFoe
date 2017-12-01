package com.mobile_final.friendorfoe.model;

import android.content.ContentValues;

import com.mobile_final.friendorfoe.database.StudentsTable;


public class DataStudent {

    private String studentid;
    private String studentName;
    private String studentPhone;

    public DataStudent(){

    }

    //Setters
    public void setName(String n) {
        this.studentName = n;
    }
    public void setstudentPhone(String n) { this.studentPhone = n;}
    public void setID(String a) {
        this.studentid = a;
    }

    //Getters
    public String getID() {
        return this.studentid;
    }
    public String getName() {
        return this.studentName;
    }
    public String getstudentPhone(String n) { return this.studentPhone;}


    public ContentValues toValues()
    {
        ContentValues val = new ContentValues(3);
        val.put(StudentsTable.COLUMN_ID,studentid);
        val.put(StudentsTable.COLUMN_NAME, studentName);
        val.put(StudentsTable.COLUMN_PHONE, studentPhone);
        return val;
    }


}
