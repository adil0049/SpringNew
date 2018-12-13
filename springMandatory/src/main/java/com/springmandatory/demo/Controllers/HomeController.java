package com.springmandatory.demo.Controllers;

import com.springmandatory.demo.Model.Entities.Grade;
import com.springmandatory.demo.Model.Entities.Student;
import com.springmandatory.demo.Repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class HomeController {

    @Autowired
    IStudentRepository iStudentRepository;

    private ArrayList<Student> students = new ArrayList<Student>() {{
  //      add(new Student(1, "Lars", "Lars@hotmail.com", "DAT17A", 30));
        //     add(new Student(2, "Hans", "Hans@hotmail.com", "DAT16B", 22));
   //     add(new Student(3, "Peter", "Peter@hotmail.com", "DAT18A", 29));
    }};

    public Student read(int id) {
        for (Student st : students) {
            if (st.getStudentId() == id) {
                return st;
            }
        }
        return null;
    }

    public void updateStudent(Student student) {
        delete(student.getStudentId());
        students.add(student);
    }

    public void delete(int id) {
        Student st = read(id);
        students.remove(st);
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/oneStudent")
    public String oneStudent(@RequestParam("studentId") String studentId, Model model) {
        model.addAttribute("student", read(Integer.parseInt(studentId)));
        return "oneStudent";
    }

    @GetMapping("/allStudents")
    public String allStudents(Model model) {
        model.addAttribute("students", students);
        return "allStudents";
    }

    @GetMapping("/grade")
    public String grade(@RequestParam("studentId") String studentId, Model model) {
        model.addAttribute("student", read(Integer.parseInt(studentId)));
        return "grade";
    }

    @PostMapping("/grade")
    public String grade(@ModelAttribute Grade grade, Model model) {
        System.out.println(grade.getDate());
        System.out.println(grade.getGrade());
        System.out.println(grade.getStudentId());

        Student student = read(grade.getStudentId());
        student.addGrade(grade);
        updateStudent(student);
        model.addAttribute("student", student);
        model.addAttribute("students", students);
        return "allStudents";
    }

    @GetMapping("/update")
    public String update(@RequestParam("studentId") String studentId, Model model) {
        model.addAttribute("student", read(Integer.parseInt(studentId)));
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Student student, Model model) {
        updateStudent(student);
        model.addAttribute("students", students);
        return "allStudents";
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(Model model) {
        model.addAttribute("students", students);
        return "delete";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") String studentId, Model model) {
        delete(Integer.parseInt(studentId));
        model.addAttribute("students", students);
        return "delete";
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student, Model model) {
        students.add(student);
        model.addAttribute("student", student);
        model.addAttribute("students", students);
        return "allStudents";
    }
    //  public void printStudents() {
    //    System.out.println(students);
    // }

}

