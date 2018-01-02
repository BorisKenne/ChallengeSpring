package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {
	@RequestMapping("/")
	public String bienvenueUser(){
		return "pages/connection";
	}
	@RequestMapping("/nouveauUser")
	public String nouvelUtilisateur(){
		return "pages/newUser";
	}
	@RequestMapping("/acceuil")
	public String acceuil(){
		return "pages/acceuil";
	}
}


