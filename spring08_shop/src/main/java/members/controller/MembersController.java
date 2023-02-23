package members.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import common.exception.WrongEmailPasswordException;
import members.dto.AuthInfo;
import members.dto.ChangePwdCommand;
import members.dto.MembersDTO;
import members.service.MembersService;

// http://localhost:8090/myapp/member/signup.do

@Controller
public class MembersController {

	private MembersService membersService;

	public MembersController() {

	}

	public void setMembersService(MembersService membersService) {
		this.membersService = membersService;
	}

	// 회원가입 form 불러오기 (string으로 선언해도 상관없음)
	@RequestMapping(value = "/member/signup.do", method = RequestMethod.GET)
	public ModelAndView addMember(ModelAndView mav) {
		mav.setViewName("member/signup");
		return mav;
	}

	// 회원가입
	@RequestMapping(value = "/member/signup.do", method = RequestMethod.POST)
	public String addMember(MembersDTO membersDTO, HttpSession session) {
		AuthInfo authInfo = membersService.addmemberProcess(membersDTO);
		session.setAttribute("authInfo", authInfo); // session을 걸어둠 -> 로그인 된 상태
		return "redirect:/home.do";
	}

	// 로그아웃
	@RequestMapping(value = "/member/logout.do")
	public String logoutMember(HttpSession session) {
		session.invalidate(); // 현재 세션의 모든 정보를 제거시킴
		return "redirect:/home.do";
	}

	// 로그인 form
	@RequestMapping(value = "/member/login.do", method = RequestMethod.GET)
	public String loginMember() {
		return "member/login";
	}

	// 로그인
	@RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	public String loginMember(MembersDTO membersDTO, HttpSession session, HttpServletResponse resp) {
		try {
			AuthInfo authInfo = membersService.loginProcess(membersDTO);
			session.setAttribute("authInfo", authInfo);
			Cookie rememberCookie = new Cookie("REMEMBER", membersDTO.getMemberEmail());
			rememberCookie.setPath("/"); // 중요한 정보는(ex.로그인정보)는 cookie저장 안됨 , session에 저장

			if (membersDTO.isRememberEmail()) {
				rememberCookie.setMaxAge(60 * 60 * 24 * 30); // 60초*60분*24시간*30일 = 1개월(쿠키값을 30일동안 저장한다)
			} else {
				rememberCookie.setMaxAge(0); // 쿠키를 제거함, 쿠키가 이미 생성되어있을 때 취소하려면 사용
			}
			resp.addCookie(rememberCookie); // 응답을 해줄 때 resp 이용해서 rememberCookie 값도 내보내기
			return "redirect:/home.do";
		} catch (WrongEmailPasswordException e) {
			resp.setContentType("text/html;charset=UTF-8");
			
			try {
				PrintWriter out = resp.getWriter();
				//out.print("아이디 비밀번호 불일치");
				out.print("<script>alert('아이디 비밀번호 불일치');location.href='login.do';</script>");
				out.flush();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		}
		return null;
	}

	//회원정보 수정 폼
	@RequestMapping(value="/member/editmember.do", method = RequestMethod.GET)
	public ModelAndView updateMember(ModelAndView mav, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
			mav.addObject("membersDTO", membersService.updateMemberProcess(authInfo.getMemberEmail()));
			mav.setViewName("member/editmember");
			return mav; // 수정폼에서는 기존에 있는 정보를 가져와서 뿌려주기
	}
	
	//회원정보 수정 처리
	@RequestMapping(value="/member/editmember.do", method = RequestMethod.POST)
	public String updateMember(MembersDTO membersDTO, HttpSession session) {
		AuthInfo authInfo = membersService.updateMemberProcess(membersDTO);
		session.setAttribute("authInfo", authInfo);
		return "redirect:/home.do";
	}
	
	
	//비밀번호 수정 폼
	@RequestMapping(value="/member/changepass.do", method=RequestMethod.GET)
	public String changePassword() {
		return "member/changepass";
	}
	
	//비밀번호 수정 처리
	@RequestMapping(value="/member/changepass.do", method=RequestMethod.POST)
	public String changePassword(ChangePwdCommand changePass, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		try {
			membersService.updatePassProcess(authInfo.getMemberEmail(), changePass);
			return "redirect:/home.do";
		}catch(WrongEmailPasswordException e) {
			return "member/changepass"; //비밀번호 잘 못 적으면 다시 수정하는 곳의 페이지 엶
		}
	}
	
	
	
}// end class










































