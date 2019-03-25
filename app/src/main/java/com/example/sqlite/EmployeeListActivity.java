package com.example.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.sqlite.Database.Employee;
import com.example.sqlite.Database.EmployeeDBSource;

import java.util.ArrayList;

public class EmployeeListActivity extends AppCompatActivity {

    private ListView listView;
    private EmployeeAdapter employeeAdapter;
    private ArrayList<Employee> employeeArrayList = new ArrayList<>();
    private EmployeeDBSource source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        listView = findViewById(R.id.employeeListView);

        source = new EmployeeDBSource(this);
        employeeArrayList = source.getAllEmployee();
        employeeAdapter = new EmployeeAdapter(this,employeeArrayList);
        listView.setAdapter(employeeAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                int employeeId = employeeArrayList.get(position).getEmplopyeeId();
                source.deleteEmployee(employeeId);
                reloadActivity();
                return false;
            }
        });
        //For Edit Function
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Employee  employee = employeeArrayList.get(position);
                int empId = employee.getEmplopyeeId();
                startActivity( new Intent(EmployeeListActivity.this, MainActivity.class)
                        .putExtra("empId", empId));


            }
        });




    }

    private void reloadActivity(){
        startActivity(new Intent(this, EmployeeListActivity.class));
    }

}
