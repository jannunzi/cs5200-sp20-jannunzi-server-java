package com.example.cs5200sp20jannunziserverjava.models;

public class CourseReviewId {
    public Integer courseId;
    public Integer studentId;
    public boolean equals(Object other) {
        if(!(other instanceof CourseReviewId))
            return false;
        if( this.courseId.equals(((CourseReviewId) other).courseId) &&
            this.studentId.equals(((CourseReviewId) other).studentId)) {
            return true;
        }
        return false;
    }
    public int hash() {
        return courseId + studentId;
    }
}
