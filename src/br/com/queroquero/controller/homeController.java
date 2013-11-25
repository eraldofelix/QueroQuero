package br.com.queroquero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {
	@RequestMapping("/")
	  public String index() {
	      return "index";
	  }
	
	@RequestMapping("/home")
	  public String home() {
	      return "index";
	  }
}
