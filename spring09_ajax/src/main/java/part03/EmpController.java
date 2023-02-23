package part03;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// http://localhost:8090/myapp/empsearch.do

@Controller
public class EmpController {

	private EmployeesDAO dao;
	
	public EmpController() {
		
	}
	
	public void setDao(EmployeesDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="/empsearch.do", method=RequestMethod.GET)
	public String execute() {
		return "part03/empList";
	}
	
	@ResponseBody
	@RequestMapping(value="/process.do")
	public List<EmployeesDTO> process(String data){
		System.out.println(dao.search(data));	
		return dao.search(data);
/* * List<EmployeesDTO>값이 jquery의 res가 받는다.
   * List는 자바스크립트의 배열로 변경되고 EmployeesDTO는 object로 변경 ( [{}] 구조 )
   * 자바스크립트에서 객체는 {}, 배열은 []
*/
	}
	
}//end class
