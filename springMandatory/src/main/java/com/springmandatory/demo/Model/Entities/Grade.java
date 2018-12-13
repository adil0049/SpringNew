package com.springmandatory.demo.Model.Entities;

import com.springmandatory.demo.Model.Entities.Grade;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="g_id")
    private int id;

    @Column(name = "studentId")
    private int studentId;

    @Column(name = "grade")
    private String grade;

    @Column(name = "date")
    private String date;

    public Grade(int studentId, String grade, String date) {
        this.studentId = studentId;
        this.grade = grade;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
