package com.example.cs5200sp20jannunziserverjava.repositories;

import com.example.cs5200sp20jannunziserverjava.models.Course;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface CourseRepository
    extends CrudRepository<Course, Integer>
{
}
