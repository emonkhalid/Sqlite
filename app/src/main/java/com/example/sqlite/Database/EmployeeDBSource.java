package com.example.sqlite.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


public class EmployeeDBSource {

    private EmployeeDBHelper dbHelper;
    private SQLiteDatabase db;

    public EmployeeDBSource(Context context) {
        dbHelper = new EmployeeDBHelper(context);
    }

    public void open(){
        db = dbHelper.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public boolean insertEmployee(Employee employee){
        this.open();
        ContentValues values = new ContentValues();
        values.put(EmployeeDBHelper.EMPLOYEE_COL_NAME, employee.getEmployeeName());
        values.put(EmployeeDBHelper.EMPLOYEE_COL_DESIGNATION, employee.getEmployeeDesignation());
        long insertedRow = db.insert(EmployeeDBHelper.TABLE_EMPLOYEE,
                null,
                values);
        if(insertedRow > 0){
            return true;
        }else{
            return false;
        }

    }

    public ArrayList<Employee>getAllEmployee(){

        this.open();
        ArrayList<Employee>employeeArrayList = new ArrayList<>();
        Cursor cursor = db.query(EmployeeDBHelper.TABLE_EMPLOYEE,
                null,
                null,
                null,
                null,
                null,
                null);
        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                int id = cursor.getInt(cursor.getColumnIndex(EmployeeDBHelper.EMPLOYEE_COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(EmployeeDBHelper.EMPLOYEE_COL_NAME));
                String designation = cursor.getString(cursor.getColumnIndex(EmployeeDBHelper.EMPLOYEE_COL_DESIGNATION));
                employeeArrayList.add(new Employee(id, name, designation));
            }while ( cursor.moveToNext());
        }
        cursor.close();
        this.close();
        return employeeArrayList;
    }

    public boolean deleteEmployee(int id){
        this.open();
        int deleteRow = db.delete(EmployeeDBHelper.TABLE_EMPLOYEE, EmployeeDBHelper.EMPLOYEE_COL_ID
                +"="+id,null);
        if(deleteRow > 0){
          return true;
        }
        else{
            return false;
        }
    }

    public Employee getEmployeeById(int id){

     this.open();
     Employee employee = null;
     Cursor cursor = db.query(EmployeeDBHelper.TABLE_EMPLOYEE,
             null,EmployeeDBHelper.EMPLOYEE_COL_ID+"="+id,null,null,null,null);
     if(cursor != null && cursor.getCount() > 0){
         cursor.moveToFirst();
         int empId = cursor.getInt(cursor.getColumnIndex(EmployeeDBHelper.EMPLOYEE_COL_ID));
         String empName = cursor.getString(cursor.getColumnIndex(EmployeeDBHelper.EMPLOYEE_COL_NAME));
         String empDesgination = cursor.getString(cursor.getColumnIndex(EmployeeDBHelper.EMPLOYEE_COL_DESIGNATION));
         employee = new Employee(empId, empName, empDesgination);
     }
     this.close();
     return employee;
    }


    public boolean updateEmployee(Employee employee){
        this.open();
        ContentValues values = new ContentValues();
        values.put(EmployeeDBHelper.EMPLOYEE_COL_NAME, employee.getEmployeeName());
        values.put(EmployeeDBHelper.EMPLOYEE_COL_DESIGNATION, employee.getEmployeeDesignation());
        int updatedRow = db.update(EmployeeDBHelper.TABLE_EMPLOYEE,
                values,
                EmployeeDBHelper.EMPLOYEE_COL_ID+"="+employee.getEmplopyeeId(),
                null
                );

        if(updatedRow >0){
            return true;
        }
        else {
            return false;
        }
    }


}
