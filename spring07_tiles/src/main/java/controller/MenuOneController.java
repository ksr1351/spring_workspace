package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuOneController {

	
	@RequestMapping("/menu1.do")
	public String execute() {
		return "menu1"; //tiles의 menu1을 찾아서 수행
	}
}
