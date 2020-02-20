package com.example.cs5200sp20jannunziserverjava.models;

import javax.persistence.*;

@Entity
@IdClass(CourseReviewId.class)
public class CourseReview {
    @Id
    private Integer courseId;
    @Id
    private Integer studentId;
    private String title;
    private String review;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Student student;

}
