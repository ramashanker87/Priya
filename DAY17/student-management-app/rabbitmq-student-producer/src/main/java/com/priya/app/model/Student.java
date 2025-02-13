package com.priya.app.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String name;
    public String schoolName;
    public Integer age;
    public String gender;

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

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Student() {}
    public Student(int id, String name, String schoolName, int age, String gender) {
        super();
        this.id = id;
        this.name = name;
        this.schoolName = schoolName;
        this.age = age;
        this.gender = gender;

    }
}
