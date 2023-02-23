package part04;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//http://localhost:8090/myapp/model.htm

@Controller
public class HelloModelController {

	public HelloModelController() {
		
	}
	
	@GetMapping("/model.htm")
	// @RequestMapping(value="/mem.htm", method=RequestMethod.GET)
	public String form() {
		return "part04/memForm";
	}
	
	
	@PostMapping("/model.htm")
	// @RequestMapping(value="/mem.htm", method=RequestMethod.POST)
	public String submit(String name, int age, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "part04/memPro"; //submit을 요청하는 곳에 데이터만 넘겨줄 때 model에 넣어서 넘겨줄 수 있음
		
	}
}























