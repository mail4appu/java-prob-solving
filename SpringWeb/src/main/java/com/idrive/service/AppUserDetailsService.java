package com.idrive.service;

import com.idrive.bean.Student;
import com.idrive.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SESA439295 on 7/16/2018.
 */
public class AppUserDetailsService extends JdbcUserDetailsManager {

    @Autowired
    StudentDao studentDao;

    @Override
    @Transactional // This is very important here. if not present, during loading of authorities we get " Lazy initialization has failed"
                   //as hibernate session is closed after "studentDao.getStudent(xxxx) method call
                   //Lazy loading can happen only untill session is alive. Hence making this method transactional would solve the problem
    public UserDetails loadUserByUsername(String  id) throws UsernameNotFoundException {
        long start=System.currentTimeMillis();
        Student student = studentDao.getStudent(id);
        System.out.println("before validation user from db");
        List<String> authorities = student.getAuthorities();
        List<GrantedAuthority> grantedAuthorities= new ArrayList<>();
        for(String authority:authorities){
            grantedAuthorities.add(new SimpleGrantedAuthority(authority));
        }
        System.out.println("load user and his authorities "+(System.currentTimeMillis()-start));
        return new User(student.getEmail(), student.getPassword(), grantedAuthorities);
    }
}
