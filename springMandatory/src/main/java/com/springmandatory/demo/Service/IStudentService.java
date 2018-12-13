package com.springmandatory.demo.Service;

import com.springmandatory.demo.Model.Entities.Student;

import java.util.List;

public interface IStudentService {

    List<Student> fetchAllStudents();
    Student fetchOneStudent(int id);
    Student createStudent(Student student);
    void deleteStudent(int id);
    Student updateStudent(int id);

}
