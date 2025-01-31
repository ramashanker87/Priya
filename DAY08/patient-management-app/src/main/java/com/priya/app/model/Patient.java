package com.priya.app.model;

public class Patient {
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getName() {
        return name;
    }


    public String getId() {
        return id;
    }


    public String getHospitalName() {
        return hospitalName;
    }



    public int getAge() {
        return age;
    }



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    String name;
    String id;
    String hospitalName;
    int age;
    String gender;
    public Patient(){}
    public Patient(String name, String id, String hospitalName, int age, String gender){
        super();
        this.name = name;
        this.id = id;
        this.hospitalName = hospitalName;
        this.age = age;
        this.gender = gender;
    }



}
