package com.example.sqlite.Database;

public class Employee {

    private int emplopyeeId;
    private String employeeName;
    private String employeeDesignation;

    public Employee(int emplopyeeId, String employeeName, String employeeDesignation) {
        this.emplopyeeId = emplopyeeId;
        this.employeeName = employeeName;
        this.employeeDesignation = employeeDesignation;
    }

    public Employee(String employeeName, String employeeDesignation) {
        this.employeeName = employeeName;
        this.employeeDesignation = employeeDesignation;
    }

    public int getEmplopyeeId() {
        return emplopyeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeDesignation() {
        return employeeDesignation;
    }







}
