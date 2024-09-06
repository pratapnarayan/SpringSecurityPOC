package com.pratap.SpringSecurityDemo.controller;

import com.pratap.SpringSecurityDemo.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(101, "John", 59),
            new Student(102, "Doe", 65),
            new Student(103, "Jim", 78),
            new Student(104, "Jack", 88)
    ));

    @GetMapping("/student")
    public List<Student> getStudent() {
        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

}
