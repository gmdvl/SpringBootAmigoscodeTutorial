package com.example.amigoscodetutorial.amigoscodetutorial.service;

import com.example.amigoscodetutorial.amigoscodetutorial.dto.StudentRepository;
import com.example.amigoscodetutorial.amigoscodetutorial.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

  private StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getStudents() {
    return studentRepository.findAll();
  }

  public void addStudent(Student student) {
    Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());

    if (studentByEmail.isPresent()) {
      throw new IllegalStateException("email is already register.");
    }

    studentRepository.save(student);
  }

  public void deleteStudent(Long studentId) {
    boolean exists = studentRepository.existsById(studentId);
    if (!exists) {
      throw new IllegalStateException("Student doesn't exit with id: %s".formatted(studentId));
    }
    studentRepository.deleteById(studentId);
  }
}
