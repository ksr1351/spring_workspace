package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import dao.MemDAO;
import model.MemDTO;

// http://localhost:8090/myapp/mem/list

/*
 * @Controller + @ResponseBody(바디값만보냄) == @RestController (둘다 같은 의미)
 */


@RestController
//@Controller
public class MemController {

	private MemDAO memDao;

	public MemController() {

	}

	public void setMemDao(MemDAO memDao) {
		this.memDao = memDao;
	}

	// 전체 출력 ---------------------------------------------------
	// http://localhost:8090/myapp/mem/list
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	public List<MemDTO> process() {
//		return memDao.list();
//	}//전체 데이터를 출력

//	public ResponseEntity<List<MemDTO>> process() {
//		List<MemDTO> aList = memDao.list();
//		try {
//			return new ResponseEntity<List<MemDTO>>(aList, HttpStatus.OK);
//			return ResponseEntity.ok().body(aList);
//		} catch (Exception e) {
//			return new ResponseEntity<List<MemDTO>>(aList, HttpStatus.NOT_FOUND);
//			return ResponseEntity.notFound().build();
//		}
//	}// 첫번째 인자값에 바디값, 두번째 인자값에 status 넣기(aList, HttpStatus.OK )

	
//	public ResponseEntity<Map<String, Object>> process() {
//		
//		try {
//			List<MemDTO> aList = memDao.list();
//			int cnt = aList.size();
//			
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("aList", aList);
//			map.put("cnt", cnt);
//			return ResponseEntity.ok().body(map);
//			
//		} catch (Exception e) {
//			return ResponseEntity.notFound().build();
//		}
//	}
	
	
	
	
	public ResponseEntity<Result<List<MemDTO>>> process() {
		
		try {
			List<MemDTO> aList = memDao.list();
			return ResponseEntity.ok().body(new Result<>(aList, aList.size()));
													   //data(aList),cnt(aList.size())에 담아서 넘겨줌
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	static class Result <T> {
		private T data;
		private int cnt;
		
		public Result(T data, int cnt) {
			this.data = data;
			this.cnt = cnt;
			
		}
		
		public T getData() {
			return data;
		}
		
		public int getCnt() {
			return cnt;
		}
	}
	
	
	
	// http://localhost:8090/myapp/mem/list/107
	@ResponseBody
	@RequestMapping(value = "/list/{ss}", method = RequestMethod.GET)
	public MemDTO process2(@PathVariable("ss") int num) {
		return memDao.one(num);
	}// 특정인덱스 값만 출력 : 102번의 데이터값을 가져오라는 의미이다. : 넘어오는 값의 이름을 ss로 지정(@pathVariable)

	
	
	
	// insert -----------------------------------------------------

	// http://localhost:8090/myapp/mem/list/107/용팔이
	@ResponseBody
	@RequestMapping(value = "/list/{ss}/{name}", method = RequestMethod.GET)
	public MemDTO listMethod(@PathVariable("ss") int num, @PathVariable("name") String name) {
		return memDao.list(new MemDTO(num, name));
	}

	@ResponseBody
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<String> insert(@RequestBody MemDTO dto) {
		System.out.println("insert");
		System.out.println(dto.getLoc());
		try {
			memDao.insertMethod(dto);
			// return new ResponseEntity<String>("SUCCESS", HttpStatus.CREATED); //삽입된 후 다시
			// list를 출력하도록 redirect
			return ResponseEntity.ok().body("SUCCESS"); // 빌더 방식으로 리턴
		} catch (Exception e) {
			// return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			return ResponseEntity.badRequest().body(e.getMessage()); // 권장되는 방식
		}
	}// end insert()

	
	
	
	
	// update -----------------------------------------------------
	// one() : 수정할 데이터를 가져온다, updateMethod() : 데이터를 수정한다.

	// http://localhost:8090/myapp/mem/update

	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.PUT) // update는 무조건 put
	public ResponseEntity<String> update(@RequestBody MemDTO dto) {
		try {
			memDao.updateMethod(dto);
			//return new ResponseEntity<String>("SUCCESS", HttpStatus.CREATED);
			return ResponseEntity.ok().body("SUCCESS");
		} catch (Exception e) {
			//return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	
	
	
	// delete -----------------------------------------------------
	@ResponseBody
	@RequestMapping(value = "/delete/{num}")
	public ResponseEntity<String> delete(@PathVariable("num") int num) {
		try {
			memDao.deletMethod(num);
			//return new ResponseEntity<String>("SUCCESS", HttpStatus.CREATED);
			return ResponseEntity.ok().body("SUCCESS");
		} catch (Exception e) {
			//return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}// end class










