package com.uniquindio.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AppController {

	@GetMapping({"/","/login"})
	public String login() {
		return "login";
	}
	
	@GetMapping("/menu")
	public String hello() {
		return "menu";
	}
	
	@GetMapping("/user")
	public String user() {
		return "user";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/default")
	public String porDefecto(HttpServletRequest http) {
		if(http.isUserInRole("ADMIN")) {
			return "redirect:/listar/";
		}else {
			return "redirect:/form/";
		}
	}
}