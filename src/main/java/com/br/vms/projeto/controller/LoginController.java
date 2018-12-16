package com.br.vms.projeto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.vms.projeto.model.Login;

@Controller
@RequestMapping("projeto/login")
public class LoginController {

	
	@RequestMapping(method = RequestMethod.POST)
	private String logar(Login login) {
		
		System.out.println(login.getLogin());
	
			return "index";
	}
}
