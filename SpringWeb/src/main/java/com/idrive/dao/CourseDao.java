package com.idrive.dao;

import com.idrive.bean.Course;

import java.util.List;

/**
 * Created by SESA439295 on 8/23/2018.
 */
public interface CourseDao {
    List<Course> getCourses();

    Course getCourse(String  id);
    void saveCourse(Course course);

    void deleteCourse(Course course);

    void updateCourse(Course course);
}
