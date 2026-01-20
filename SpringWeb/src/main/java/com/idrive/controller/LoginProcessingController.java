package com.idrive.controller;

import com.idrive.bean.Course;
import com.idrive.bean.Student;
import com.idrive.dao.CourseDao;
import com.idrive.dao.StudentDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by SESA439295 on 7/10/2018.
 */
@Controller
@SessionAttributes("username")
public class LoginProcessingController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginProcessingController.class);

    @Autowired
    StudentDao studentDao;

    @Autowired
    CourseDao courseDao;

    @ModelAttribute("student")
    public Student prepareModel(Model model){
        return new Student();
    }

    @RequestMapping(value="/courses", method=RequestMethod.GET)
    public String displayCourses(Model model, Authentication authentication){
        long start=System.currentTimeMillis();
        System.out.println("Authentication principal"+authentication.getPrincipal()+ " :   "+authentication.getCredentials());
        String authenticatedUser=authentication.getName();
        model.addAttribute("username", authenticatedUser);
        Student studentFromDb=studentDao.getStudent(authenticatedUser);
        List<Course> courses = studentFromDb.getCourses();
        model.addAttribute("courses", courses);
        System.out.println("Time taken to finish:   "+(System.currentTimeMillis()-start));

        return "../../courses";

    }


    @RequestMapping( value = "/tutorials" , method = RequestMethod.POST)
    public String processCourses(HttpServletRequest request, @ModelAttribute("username")String userName, Model model) {
        long start=System.currentTimeMillis();
        try {

            String[] courses = request.getParameterValues("courses");
            Student student = studentDao.getStudent(userName);

            for(String course: courses){
                Course courseObj= new Course();
                courseObj.setCourseName(course);
                courseObj.getStudents().add(student);
                courseDao.saveCourse(courseObj);
            }
            student.getCourses();
            model.addAttribute("student", student);
            System.out.println("Time taken to return tutorials: "+(System.currentTimeMillis()-start));
            return "../../tutorials";
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return "";
    }



}
