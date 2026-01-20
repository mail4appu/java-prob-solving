package com.idrive.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.idrive.bean.Student;
import com.idrive.util.SpringWebUtil;
import com.idrive.util.WebUtil;

/**
 * @author Test
 *
 */
@Controller
public class SpringWebController {


	ReloadableResourceBundleMessageSource messageSource1;

	@Autowired
	public void setMessageSource(ReloadableResourceBundleMessageSource messageSource) {
		this.messageSource1 = messageSource;
	}

	@RequestMapping( value = "/mypage" , method = RequestMethod.GET)
	public ModelAndView showPage(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		String localizedMsg=messageSource1.
				getMessage("contrl.msg", null,  RequestContextUtils.getLocale(request));
		RequestContextUtils.getLocale(request);
		System.out.println("########: "+RequestContextUtils.getLocale(request));
		ModelAndView mav = null;
		System.out.println("controller message: "+localizedMsg);
		//System.out.println("*********: "+request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME));
		mav = new ModelAndView("mypage");
		SpringWebUtil webutil= new SpringWebUtil();
		webutil.sayHi();
		System.out.println("date from util in controller: "+SpringWebUtil.getLocalizedDate("2013-04-12 10:02:12"));
		mav.addObject("contrlmsg", localizedMsg);
		return mav;
	}

	@RequestMapping( value = "/myServlet" , method = RequestMethod.GET)
	public void test(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/webutil").forward(request, response);
		return ;
	}

	@RequestMapping( value = "/getResult" , method = RequestMethod.POST)
	public ModelAndView getResult(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = null;
		try {
			System.out.println("inside get result***********");
			WebUtil.printAllReqParams(request);
			int number1=Integer.parseInt(request.getParameter("number1").trim());
			int number2=Integer.parseInt(request.getParameter("number2").trim());
			int result=WebUtil.getResult(number1, number2);
			request.getSession().setAttribute("result", result);
			return new ModelAndView("../../redirect");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	@RequestMapping( value = "/getJson" , method = RequestMethod.GET)
	@SuppressWarnings("unchecked")
	public @ResponseBody String   getJson(){
		JSONObject json= new JSONObject();
		try {
			//BufferedReader br= new BufferedReader(new InputStreamReader( new FileInputStream(new File("/home/Test/workspace/MyJava/src/messages_en.properties"))));
			String lang=LocaleContextHolder.getLocale().getLanguage();
			String fileName="messages_"+lang+".properties";
			System.out.println("file name is "+fileName);
			BufferedReader br= new BufferedReader(new InputStreamReader(SpringWebController.class.getClassLoader().getResourceAsStream(fileName)));
			//BufferedReader br= new BufferedReader(new InputStreamReader( new FileInputStream(new File("/WEB-INF/"+fileName))));
			String line="";
			while((line=br.readLine())!=null){
				if(!line.equals("") && line.contains("=")){
					String keyValues[]=line.split("=");
                    //json.put(keyValues[0].replace(".", "_"), keyValues[1]);
					json.put(keyValues[0], keyValues[1]);

				}

			}
			return json.toJSONString();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	

	
	@RequestMapping( value = "/result" , method = RequestMethod.GET)
	public ModelAndView showLinkResult(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = null;
		try {
			
			return new ModelAndView("../../redirect");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	
	/*@ModelAttribute("student1")
	public Student addModelToSession(){
		 return new Student();
	}*/
	
	/*@RequestMapping( value = "/submit" , method = RequestMethod.POST)
	public String showResults(@Valid @ModelAttribute(value="student1") Student student1, BindingResult result, RedirectAttributes redirectAttributes) {

		try {
			MultipartFile file= (MultipartFile)student1.getStdPic();
			
			if(result.hasErrors()){
				System.out.println("binding result has errors after submit");
				if(file.getSize()==0){
				
					result.rejectValue("stdPic", "please.provide.file");
				}
				redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.student1", result);
			    redirectAttributes.addFlashAttribute("student1", student1);
				
				//ModelAndView mav= new ModelAndView("../../index");
				//mav.addObject("student1", student1);
			    System.out.println("before redirecting to init after submit");
			    return "redirect:init";    
			}
			ModelAndView mav= new ModelAndView("../../redirect");
			mav.addObject("message", "Welcome to My College");
			//return  mav;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "";
	}
	*/
	
	
	@RequestMapping( value = "/init" , method = RequestMethod.GET)
	public ModelAndView refresh(Model model) {

		try {
			if(model.containsAttribute("org.springframework.validation.BindingResult.student1")){
				System.out.println("After redirecting inside init");
				ModelAndView mav= new ModelAndView("../../index");
				mav.addObject("student1", model.asMap().get("student1"));
				return mav;
			}
			ModelAndView mav= new ModelAndView("../../redirect");
			mav.addObject("message", "Welcome to My College");
			return  mav;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}


    /*@RequestMapping( value = "/login" , method = RequestMethod.GET)
    public ModelAndView login(Model model) {

        try {

            ModelAndView mav= new ModelAndView("../../redirect");
            mav.addObject("message", "Welcome to My College");
            return  mav;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }*/

    @RequestMapping( value = "/signup" , method = RequestMethod.GET)
    public ModelAndView signup(Model model) {

        try {
            ModelAndView mav= new ModelAndView("../../register", "student1", new Student());
            mav.addObject("message", "Please register with below values");
            return  mav;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
	
}