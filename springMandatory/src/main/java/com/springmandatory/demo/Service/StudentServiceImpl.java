package com.springmandatory.demo.Service;

import com.springmandatory.demo.Model.Entities.Student;
import com.springmandatory.demo.Repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    IStudentRepository studentRepository;

    @Override
    public List<Student> fetchAllStudents(){
        return studentRepository.findAll();
    };


    @Override
    public Student fetchOneStudent(int id){
        return studentRepository.getOne(id);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }
}
