package com.example.amigoscodetutorial.amigoscodetutorial.config;

import com.example.amigoscodetutorial.amigoscodetutorial.dto.StudentRepository;
import com.example.amigoscodetutorial.amigoscodetutorial.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

  private StudentRepository studentRepository;

  @Autowired
  public StudentConfig(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Bean
  CommandLineRunner commandLineRunner() {
    return args -> {
      Student maria = new Student("Maria", "m.a@gmasd.com", LocalDate.of(2000, Month.DECEMBER, 5));
      Student laura = new Student("laura", "l.a@gmasd.com", LocalDate.of(2005, Month.JANUARY, 5));

      studentRepository.saveAll(List.of(maria, laura));
    };
  }
}
