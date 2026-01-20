package com.idrive.bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SESA439295 on 8/17/2018.
 */
@Entity
@Table(name = "course")
public class Course {

    int id;

    private List<Student> students = new ArrayList<>();
    private String courseName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "course_student",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_email")})
    public List<Student> getStudents() {
        return students;
    }


    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
