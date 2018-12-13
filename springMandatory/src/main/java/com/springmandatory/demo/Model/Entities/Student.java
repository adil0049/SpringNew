package com.springmandatory.demo.Model.Entities;

import com.springmandatory.demo.Model.Entities.Grade;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="s_id")
    private int studentId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "classname")
    private String classname;

    @Column(name = "age")
    private int age;


    private List<Grade> grades;

    public Student(int studentId, String name, String email, String classname, int age) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.classname = classname;
        this.age = age;
        grades = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

}