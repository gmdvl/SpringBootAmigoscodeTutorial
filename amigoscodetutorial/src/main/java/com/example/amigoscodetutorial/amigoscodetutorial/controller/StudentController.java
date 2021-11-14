package com.example.amigoscodetutorial.amigoscodetutorial.controller;

import com.example.amigoscodetutorial.amigoscodetutorial.model.Student;
import com.example.amigoscodetutorial.amigoscodetutorial.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/students")
  public List<Student> getStudents() {
    return studentService.getStudents();
  }
}
