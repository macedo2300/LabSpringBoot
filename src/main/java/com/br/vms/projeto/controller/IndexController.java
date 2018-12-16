
package com.br.vms.projeto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	
	@RequestMapping(value = "/projeto/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/projeto/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/projeto/login")
	public String login() {
		return "login";
	}

}
