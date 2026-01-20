package com.idrive.controller;

import com.idrive.bean.Student;
import com.idrive.dao.CourseDao;
import com.idrive.dao.StudentDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by SESA439295 on 7/10/2018.
 */
@Controller
public class RegistrationController {

    private static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    StudentDao studentDao;

    @Autowired
    CourseDao courseDao;

    @RequestMapping( value = "/submit" , method = RequestMethod.POST)
    public String showResults(@Valid @ModelAttribute(value="student1")Student student1, BindingResult result, RedirectAttributes redirectAttributes) {

        try {
            MultipartFile file= (MultipartFile)student1.getStdPic();

            LOG.debug("student object after submission"+student1+"   :  Name "+student1.getStudentName() + " File is : "+file);
            if(result.hasErrors()){
                System.out.println("binding result has errors after submit");
               /* if(file.getSize()==0){

                    result.rejectValue("stdPic", "please.provide.file");
                }*/
               /* redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.student1", result);
                redirectAttributes.addFlashAttribute("student1", student1);*/

                //ModelAndView mav= new ModelAndView("../../index");
                //mav.addObject("student1", student1);
                System.out.println("before redirecting to init after submit");

                return "../../register";
            }

            studentDao.saveStudent(student1);
            ModelAndView mav= new ModelAndView("../../redirect");
            mav.addObject("message", "Welcome to My College");
            System.out.println("Student details after saving in database "+student1);
            return  "../../redirect";
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return "";
    }




}
