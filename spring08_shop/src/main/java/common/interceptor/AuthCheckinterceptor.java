package common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import members.dto.AuthInfo;

public class AuthCheckinterceptor extends HandlerInterceptorAdapter {

	public AuthCheckinterceptor() {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception { // 컨트롤러가 수행되기 전

		// 로그인 여부 확인
		// false이면 현재 생성된 세션이 없으면 null값 리턴
		// true이면 현재 생성된 세션이 없으면 세션을 생성함
		HttpSession session = request.getSession(false);

		if (session != null) {
			AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
			if (authInfo != null) {
				return true; // session != null와 authInfo != null를 만족하면 true
			}
		}
		response.sendRedirect(request.getContextPath() + "/member/login.do");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView); // 컨트롤러가 수행 된 후
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex); // 컨트롤러가 수행 된 후 뷰페이지를 응답하기 직전
	}

}// end class
