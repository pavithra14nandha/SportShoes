package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
@Autowired
AdminService servicea;

@PostMapping("/insertadmin")
public Admin insert(@RequestBody Admin a)
{
	return servicea.insert(a);
}

@RequestMapping("/loginadmin")
public ModelAndView loginadmin(HttpServletRequest request,HttpServletResponse response)
{
	ModelAndView mv= new ModelAndView();
	String name=request.getParameter("name");
	String password=request.getParameter("password");
	Admin a=servicea.findbynamepassword(name, password);
	if(a!=null) {
	mv.setViewName("admin.jsp");
	mv.addObject("a", a);
	}
	else{
		mv.setViewName("fail.jsp");
	}
	return mv;
}
}
