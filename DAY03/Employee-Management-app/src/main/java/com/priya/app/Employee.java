package com.priya.app;

public class Employee {
    String name;
    int age;
    String company;
    String rollNo;
    int salary;

    public Employee(String name, int age, String company, String rollNo, int salary) {
        this.name = name;
        this.age = age;
        this.company = company;
        this.rollNo = rollNo;
        this.salary = salary;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Company: " + company);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Salary: " + salary);


    }
}
