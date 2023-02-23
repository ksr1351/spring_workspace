package part02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// http://localhost:8090/myapp/name.do

@Controller
public class NameController {

	public NameController() {
		
	}
	
	//클라이언트로부터 데이터를 입력받을 수 있는 view페이지를 가져온다.
	@RequestMapping(value="/name.do", method=RequestMethod.GET)
	public String execute() {
		return "part02/form";
	}
	
	@RequestMapping(value="/name.do", method=RequestMethod.POST)
	public ModelAndView process(String name, ModelAndView mav) {
		mav.addObject("name", name);
		mav.setViewName("part02/res");	
		return mav;
	}
	
}//end class
