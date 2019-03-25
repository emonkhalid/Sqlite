package com.example.sqlite;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlite.Database.Employee;
import com.example.sqlite.Database.EmployeeDBSource;

public class MainActivity extends AppCompatActivity {

    private EmployeeDBSource employeeDBSource;
    private int empId;

    Button btnSave;
    EditText etEmpName, etEmpDesignation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmpName = findViewById(R.id.edit_textEmployeeName);
        etEmpDesignation = findViewById(R.id.edit_textEmployeeDesignation);
        btnSave = findViewById(R.id.buttonSaveEmployee);

        employeeDBSource = new EmployeeDBSource(this);
        empId = getIntent().getIntExtra("empId", 0);

        if(empId > 0){
            Employee employee = employeeDBSource.getEmployeeById(empId);
            etEmpName.setText(employee.getEmployeeName());
            etEmpDesignation.setText(employee.getEmployeeDesignation());
            btnSave.setText("Update");

        }


    }



    public void createEmployeeBtn(View v){

        if( empId > 0){
            String empName = etEmpName.getText().toString();
            String empDesignation = etEmpDesignation.getText().toString();

            Employee employee = new Employee(empId, empName, empDesignation);
            boolean status = employeeDBSource.updateEmployee(employee);
            if(status){
                Toast.makeText(this,"Updated Successfully", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"Failed to Update!", Toast.LENGTH_LONG).show();
            }
        }

        else{
            String empName = etEmpName.getText().toString();
            String empDesignation = etEmpDesignation.getText().toString();

            Employee employee = new Employee(empName, empDesignation);
            EmployeeDBSource employeeDBSource = new EmployeeDBSource(this);
            boolean status = employeeDBSource.insertEmployee(employee);
            if(status){
                Toast.makeText(this,"Employee Created Successfully", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"Sorry, Employee Created Failed!", Toast.LENGTH_LONG).show();
            }
        }

    }


    public void viewEmployeeBtn(View v){
        startActivity(new Intent(MainActivity.this, EmployeeListActivity.class));

    }


}

