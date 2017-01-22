package com.smertbox.common.error;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

	@RequestMapping("/404")
	public String error404(Model model){
		return "error/404";
	}
	
	@RequestMapping("/500")
	public String error500(Model model){
		return "error/500";
	}
	
	@RequestMapping("/403")
	public String error403(Model model){
		return "error/403";
	}
	
	@RequestMapping("/204")
	public String error204(Model model){
		return "error/204";
	}
}
