package com.springmandatory.demo.Repositories;

import com.springmandatory.demo.Model.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository <Student, Integer> {
}
