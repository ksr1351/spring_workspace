package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// http://localhost:8090/myapp/index.do

@Controller
public class IndexController {

	@RequestMapping("/index.do")
	public String execute() {
		return "index"; //index.do를 요청하면 index가 호출됨(실제론 tiles.xml에서 index가 호출됨)
	}
	
}
