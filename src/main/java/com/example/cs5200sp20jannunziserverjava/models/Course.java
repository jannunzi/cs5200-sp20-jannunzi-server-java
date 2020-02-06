package com.example.cs5200sp20jannunziserverjava.models;

public class Course {
    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Course(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Course() {}
}
