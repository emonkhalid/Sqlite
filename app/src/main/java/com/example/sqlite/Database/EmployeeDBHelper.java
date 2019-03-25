package com.example.sqlite.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EmployeeDBHelper extends SQLiteOpenHelper {

    private Context context;
    public static final String DATABASE_NAME = "employee_db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_EMPLOYEE = "tbl_employee";
    public static final String EMPLOYEE_COL_ID = "employee_id";
    public static final String EMPLOYEE_COL_NAME = "employee_name";
    public static final String EMPLOYEE_COL_DESIGNATION = "employee_designation";

    public static final String CREATE_TABLE_EMPLOYEE = "CREATE TABLE "+TABLE_EMPLOYEE+"("+EMPLOYEE_COL_ID+" INTEGER PRIMARY KEY, "+
            EMPLOYEE_COL_NAME+" TEXT, "+
            EMPLOYEE_COL_DESIGNATION+" TEXT);";


    public EmployeeDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION );

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_EMPLOYEE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_EMPLOYEE);
    }
}
