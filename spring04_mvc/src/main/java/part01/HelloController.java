package part01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// http://localhost:8090/myapp/hello.htm

@Controller //컨트롤러 사용할 클래스에는 annotation controller 무조건 써야함
public class HelloController {

	public HelloController() {

	}
	//jsp 는 view를 view-home.jsp에 저장해둠
	//requestmapping: hello.htm으로 요청이 들어오면 public~hello를 수행하라(응답할 페이지)
	@RequestMapping(value="/hello.htm") 
	public String search() {
		return "part01/hello"; //spring mvc에서는 이렇게 처리해주어야함
	}
}
