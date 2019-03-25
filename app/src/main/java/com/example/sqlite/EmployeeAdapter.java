package com.example.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sqlite.Database.Employee;

import java.util.ArrayList;

public class EmployeeAdapter extends ArrayAdapter<Employee> {

    private Context context;
    private ArrayList<Employee>employeeArrayList;

    public EmployeeAdapter(Context context, ArrayList<Employee>employeeArrayList) {
        super(context, R.layout.employee_row, employeeArrayList);

        this.context = context;
        this.employeeArrayList = employeeArrayList;
    }



    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.employee_row, parent, false);

        TextView nameTV = convertView.findViewById(R.id.textviewEmployeeName);
        TextView designationTV = convertView.findViewById(R.id.textviewEmployeeDesignation);

        nameTV.setText(employeeArrayList.get(position).getEmployeeName());
        designationTV.setText(employeeArrayList.get(position).getEmployeeDesignation());
        return convertView;
    }
}
