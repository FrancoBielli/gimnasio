package com.gimnasio.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String Index() {
		return "redirect";
	}

	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(){
		return "login";
	}
	
	@RequestMapping(value="/redirect")
	public String redirect()
	{
		return "redirect";
	}
}
