package com.idrive.dao;

import com.idrive.bean.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SESA439295 on 8/23/2018.
 */
@Repository
@Transactional
public class CourseDaoImpl implements CourseDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Course> getCourses() {
        return null;
    }

    @Override
    public Course getCourse(String id) {
        return null;
    }

    @Override
    public void saveCourse(Course course) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(course);


    }

    @Override
    public void deleteCourse(Course course) {


    }

    @Override
    public void updateCourse(Course course) {

    }
}
