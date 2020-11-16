package com.sunsoft;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/login")
	public String helloWorld(HttpServletRequest request,HttpServletResponse res,Model m) {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String id=request.getParameter("id");
		String dept=request.getParameter("dept");
		String designation=request.getParameter("designation");
		
		if(password.equals("admin")) {
			String message = "You are a valid User, Welcome"+name;
			//System.out.println("Employee Details are:");
			m.addAttribute("message", message);
			m.addAttribute("id", id);
			m.addAttribute("name", name);
			m.addAttribute("dept", dept);
			m.addAttribute("designation", designation);
			return "hellopage";
			}
		else{
			m.addAttribute("message","Sorry, Username or password error");
			return "errorpage";
		}
	}

}
