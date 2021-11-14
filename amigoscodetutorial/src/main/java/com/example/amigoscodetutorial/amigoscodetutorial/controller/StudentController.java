package com.example.amigoscodetutorial.amigoscodetutorial.controller;

import com.example.amigoscodetutorial.amigoscodetutorial.model.Student;
import com.example.amigoscodetutorial.amigoscodetutorial.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

  @PostMapping("/add")
  public void addStudent(@RequestBody Student student) {
    studentService.addStudent(student);
  }
}
