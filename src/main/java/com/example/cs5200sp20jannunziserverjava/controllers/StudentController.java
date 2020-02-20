package com.example.cs5200sp20jannunziserverjava.controllers;

import com.example.cs5200sp20jannunziserverjava.models.Section;
import com.example.cs5200sp20jannunziserverjava.models.Student;
import com.example.cs5200sp20jannunziserverjava.repositories.SectionRepository;
import com.example.cs5200sp20jannunziserverjava.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SectionRepository sectionRepository;

    @GetMapping("/students/create")
    public Student[] createSomeStudents() {
        Student alice = new Student();
        alice.setName("Alice");
        studentRepository.save(alice);

        Student bob = new Student();
        bob.setName("Bob");
        studentRepository.save(bob);

        Student[] students = {alice, bob};
        return students;
    }

    @GetMapping("/students/{stid}/sections")
    public List<Section> findSectionsForStudent(
            @PathVariable("stid") Integer studentId
    ) {
        Student student = studentRepository.findById(studentId).get();
        return student.getSections();
    }

    @GetMapping("/students/{stid}/sections/{scid}")
    public Student enrollStudentInSection(
            @PathVariable("stid") Integer studentId,
            @PathVariable("scid") Integer sectionId
    ) {
        Student student = studentRepository.findById(studentId).get();
        Section section = sectionRepository.findById(sectionId).get();
        student.getSections().add(section);
        studentRepository.save(student);
        return student;
    }
}
