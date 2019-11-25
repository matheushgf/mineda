package com.fatec.lab.mineda.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LoginController {
	
	String projectUrl = "http://localhost:8080/";
	
	@GetMapping("/login")
    public RedirectView  redirectTo(){
		 RedirectView redirectView = new RedirectView();
		 redirectView.setUrl(projectUrl);
		 return redirectView;
        
    }
	
	/*@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	@GetMapping("/login")
	public ModelAndView method() {
	    return new ModelAndView("redirect:" + projectUrl);
	}*/

}
