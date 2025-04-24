package com.pluralsight;

public class Employee {

    private int id = 0;
    private String name = "";
    private float hoursWorked = 0;
    private float payRate = 0;

    public Employee(int id, String name, float hoursWorked, float payRate) {
        this.id = id;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public float getPayRate() {
        return payRate;
    }

    public void setPayRate(float payRate) {
        this.payRate = payRate;
    }

    public float getGrossPay(float hoursWorked, float payRate) {
        return hoursWorked * payRate;
    }
}
