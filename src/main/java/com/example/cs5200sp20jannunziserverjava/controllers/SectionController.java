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
public class SectionController {

    @Autowired
    SectionRepository sectionRepository;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/sections")
    public List<Section> findAllSection() {
        return (List<Section>)sectionRepository.findAll();
    }


    @GetMapping("/sections/{scid}/students/{stid}")
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

    @GetMapping("/sections/create")
    public Section[] createSomeSections() {
        Section s1 = new Section();
        s1.setTitle("Section 1");
        sectionRepository.save(s1);

        Section s2 = new Section();
        s2.setTitle("Section 2");
        sectionRepository.save(s2);

        Section[] sections = {s1, s2};
        return sections;
    }
}
