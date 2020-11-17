package com.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	private static Map<Integer, Student> std = new HashMap<Integer, Student>();
	private int c = 1;
	@RequestMapping("addstudent")
	public String addStudent(HttpServletRequest req, HttpServletResponse res, Model m) {

		std.put(c,new Student(Integer.parseInt(req.getParameter("pin")), req.getParameter("name"), Integer.parseInt(req.getParameter("age"))));
		c++;
		return "add_student";
		
	}
	
	@RequestMapping("deletestudent")
	public String deleteStudent(HttpServletRequest req, HttpServletResponse res, Model m) {
		
		int id = Integer.parseInt(req.getParameter("id"));
		Student delStd = (Student)std.remove(id);
		m.addAttribute("deletedStd", delStd);
		return "delete_student";
		
	}
	
	@RequestMapping("updatestudent")
	public String updateStudent(HttpServletRequest req, HttpServletResponse res, Model m) {

		int id = Integer.parseInt(req.getParameter("id"));
		int pin = Integer.parseInt(req.getParameter("pin"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		Student updStd = std.get(id);
		if(pin!=0)	updStd.setPin(pin);
		if(age!=0)	updStd.setAge(age);
		if(!name.equals(""))	updStd.setName(name);
		return "update_student";
		
	}
	
	@RequestMapping("/view_student")
	public String newController(Model m) {
		String st = "";
		for (Map.Entry<Integer, Student> e : std.entrySet()) {
			st+=(e.getValue().toString()+"\n");
		}
		m.addAttribute("students",st);
		return "view_student";
	}
}
