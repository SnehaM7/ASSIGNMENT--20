package com.springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AddController {
//	@RequestMapping("/addnumbers")
//	public String add(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("Inside add controller");
//		int a = Integer.parseInt(request.getParameter("n1"));
//		int b = Integer.parseInt(request.getParameter("n2"));
//		int c = a+b;
//		System.out.println("Sum is "+c);
//		return "result.jsp";
//	}
//	@RequestMapping("/addnumbers")
//	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("Inside add controller");
//		int a = Integer.parseInt(request.getParameter("n1"));
//		int b = Integer.parseInt(request.getParameter("n2"));
//		int c = a+b;
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("result.jsp");
//		mv.addObject("sum", c);
//		return mv;
//	}
	@RequestMapping("/addnumbers")
	public ModelAndView add(@RequestParam("n1") int a, @RequestParam("n2") int b) {
		int c = a+b;
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("sum", c);
		return mv;
	}
}
