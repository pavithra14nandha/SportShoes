package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
@Autowired
UserService serviceu;
@Autowired
UserRepo repou;
@RequestMapping("/registeruser")
public ModelAndView insertUser(HttpServletRequest request,HttpServletResponse response,@RequestParam("username")String username,@RequestParam("password")String password,@RequestParam("email")String email)
{
	ModelAndView mv= new ModelAndView();
	User u= new User();
	u.setUsername(username);
	u.setPassword(password);
	u.setEmail(email);
	
	User uu=serviceu.insertUser(u);
	if(uu!=null)
	{
		mv.setViewName("registersuccess.jsp");
	}
	return mv;
}
@RequestMapping("/userlogin")
public ModelAndView checkloginUser(HttpServletRequest request,HttpServletResponse response)
{
	ModelAndView mv= new ModelAndView();
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	User uu=repou.findbyNamePassword(username, password);
	if(uu!=null)
	{
		mv.setViewName("display.jsp");
		mv.addObject("uu", uu);
	}
	else
	{
		mv.setViewName("fail.jsp");
	}
	return mv;
}
@RequestMapping("/viewuser")
public ModelAndView viewuser(HttpServletRequest request,HttpServletResponse response)
{
	ModelAndView mv= new ModelAndView();
	List<User> uu=serviceu.getAllUser();
	mv.setViewName("displayuser.jsp");
	mv.addObject("uu", uu);
	return mv;
}
public ModelAndView deleteuser(HttpServletRequest request,HttpServletResponse response)
{
	ModelAndView mv= new ModelAndView();
	User u= new User();
	u.setUserid(Integer.parseInt(request.getParameter("userid")));
	String s=serviceu.delete(u);
	if(s.equals("deleted"))
	{
		mv.setViewName("userdeleted.jsp");
	}
	return mv;
}

}
