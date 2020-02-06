package com.example.cs5200sp20jannunziserverjava.jdbc;

import com.example.cs5200sp20jannunziserverjava.models.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    CourseDataAccessObject dao = new CourseDataAccessObject();

    @GetMapping("updateCourse")
    public int updateCourse(int id, Course course) {
        return dao.updateCourse(2, course);
    }


    @GetMapping("createCourse")
    public int createCourse(Course course) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cs5200_sp20",
                    "cs5200", "cs5200");
//            statement = conn.createStatement();
//            ResultSet resultSet = statement.executeQuery(FIND_COURSE_BY_ID + "1");
            pStatement = conn.prepareStatement(INSERT_COURSE);
            pStatement.setString(1, "CS5610");
            return pStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @GetMapping("deleteCourse")
    public int deleteCourse(int courseId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cs5200_sp20",
                    "cs5200", "cs5200");
//            statement = conn.createStatement();
//            ResultSet resultSet = statement.executeQuery(FIND_COURSE_BY_ID + "1");
            pStatement = conn.prepareStatement(DELETE_COURSE);
            pStatement.setInt(1, 2);
            return pStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @GetMapping("findCourseById")
    public Course findCourseById(int courseId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cs5200_sp20",
                    "cs5200", "cs5200");
//            statement = conn.createStatement();
//            ResultSet resultSet = statement.executeQuery(FIND_COURSE_BY_ID + "1");
            pStatement = conn.prepareStatement(FIND_COURSE_BY_ID);
            pStatement.setInt(1, 1);
            ResultSet resultSet = pStatement.executeQuery();
            if(resultSet.next()) {
                Course course = new Course(
                        resultSet.getInt("id"),
                        resultSet.getString("title")
                );
                return course;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    @GetMapping("test")
    public List<Course> findAllCourses() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cs5200_sp20",
                    "cs5200", "cs5200");

            statement = conn.createStatement();
            ResultSet results = statement.executeQuery(FIND_ALL_COURSES);
            while (results.next()) {
                String title = results.getString("title");
                int id = results.getInt("id");
                System.out.println(id);
                System.out.println(title);
                Course course = new Course(id, title);
                courses.add(course);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return courses;
    }
}
