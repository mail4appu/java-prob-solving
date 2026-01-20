package com.idrive.dao;

import com.idrive.bean.Student;

import java.util.List;

/**
 * Created by SESA439295 on 8/9/2018.
 */
public interface StudentDao {

    List<Student> getStudents();

    Student getStudent(String  id);


    void saveStudent(Student student);

    void deleteStudent(Student student);

    void updateStudent(Student student);
}
