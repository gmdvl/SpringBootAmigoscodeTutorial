package com.example.amigoscodetutorial.amigoscodetutorial.dto;

import com.example.amigoscodetutorial.amigoscodetutorial.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  // This is what this is the query structure that the 'findStudentByEmail' use internally
  // @Query("SELECT s from Student s where s.email=?1")
  Optional<Student> findStudentByEmail(String email);
}
