package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.GuestbookDao;

@Controller
public class HelloController {
	

	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String helloController() {
		System.out.println("헬로우~");
		return "/WEB-INF/views/main.jsp";
	}
	
	
	
}
