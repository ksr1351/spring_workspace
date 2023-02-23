package part03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//http://localhost:8090/myapp/mem.htm

@Controller
public class HelloCommandController {

	public HelloCommandController() {

	}

	@GetMapping("/mem.htm")
	// 하나의 url로 2개의 메소드 처리 가능 (method=RequestMethod.GET)
	// @RequestMapping(value="/mem.htm", method=RequestMethod.GET)
	public String form() {
		return "part03/memForm";

	}

	// @PostMapping("/mem.htm")
	// @RequestMapping(value="/mem.htm", method=RequestMethod.POST)
//	public ModelAndView submit(String name, int age, ModelAndView mav) {
//		mav.addObject("name", name);
//		mav.addObject("age", age);
//		mav.setViewName("part03/memPro");
//		return mav;
//	}

	
//	@PostMapping("/mem.htm")
//	// @RequestMapping(value="/mem.htm", method=RequestMethod.POST)
//	public String submit(MemDTO dto) {
//		return "part03/memPro"; //dto에서 선언된 값을 "part03/memPro"에서 사용가능
//	}
	
	
	@PostMapping("/mem.htm")
	// @RequestMapping(value="/mem.htm", method=RequestMethod.POST)
	public String submit(@ModelAttribute("mt") MemDTO dto) { //mt를 이용해서 MemDTO의 데이터에 접근 가능
		return "part03/memPro";
	}

}






















