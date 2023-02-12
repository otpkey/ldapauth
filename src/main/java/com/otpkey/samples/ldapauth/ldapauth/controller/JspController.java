package com.otpkey.samples.ldapauth.ldapauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class JspController {
    @RequestMapping("")
    public String jsp1() throws Exception {		
		  return "index";
	}
    @RequestMapping("/")
    public String jsp2() throws Exception {		
		  return "index";
	}
}
