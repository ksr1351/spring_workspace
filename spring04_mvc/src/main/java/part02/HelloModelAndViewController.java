package part02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// http://localhost:8090/myapp/helloModelAndView.htm

@Controller
public class HelloModelAndViewController {

	@RequestMapping("/helloModelAndView.htm")
	public ModelAndView search(ModelAndView mav) { // search() 메소드 안에 선언해주면 따로 new 선언할 필요없음
		// ModelAndView mav = new ModelAndView();
		mav.addObject("name", "kim");
		mav.addObject("age", 30);

		mav.setViewName("part02/helloModelView");
		return mav;

	}// end search()

}// end class
