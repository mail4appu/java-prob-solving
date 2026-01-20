package com.idrive.dao;

import com.idrive.bean.Student;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

/**
 * Created by SESA439295 on 8/9/2018.
 */
@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<Student> getStudents() {
        return null;
    }

    @Override
    public Student getStudent(String id) {
        long start=System.currentTimeMillis();
        Session currentSession = sessionFactory.getCurrentSession();
        Student student=(Student)currentSession.get(Student.class, id);
        System.out.println("Time taken to get student details "+(System.currentTimeMillis()-start));
        return student;
    }

    @Override
    public void saveStudent(Student student) {
        Session currentSession = sessionFactory.getCurrentSession();
        try {
            Blob blob=Hibernate.getLobCreator(currentSession).createBlob(student.getStdPic().getBytes());
            student.setPassword(passwordEncoder.encode(student.getPassword()));
            student.getAuthorities().add("ROLE_USER");
            student.setPhoto(blob);
            currentSession.save(student);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void deleteStudent(Student student) {

    }

    @Override
    public void updateStudent(Student student) {

    }
}
