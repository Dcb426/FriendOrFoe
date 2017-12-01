package com.mobile_final.friendorfoe.database;

public class StudentsTable {
    public static final String TABLE_STUDENT = "games";
    public static final String COLUMN_ID = "studentId";
    public static final String COLUMN_NAME = "studentName";
    public static final String COLUMN_PHONE = "studentPhone";

    public static final String[] ALL_COL = {
            COLUMN_ID,COLUMN_NAME,COLUMN_PHONE};

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_STUDENT + "(" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_PHONE + " TEXT" + ");";

    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_STUDENT;
}