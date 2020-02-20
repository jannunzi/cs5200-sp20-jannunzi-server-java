package com.example.cs5200sp20jannunziserverjava.repositories;

import com.example.cs5200sp20jannunziserverjava.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository
        extends CrudRepository<Student, Integer> {
}
