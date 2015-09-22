package com.eintern.spring.hellospringjersey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
}
