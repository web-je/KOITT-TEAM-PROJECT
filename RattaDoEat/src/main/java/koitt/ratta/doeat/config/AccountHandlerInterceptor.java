package koitt.ratta.doeat.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;
/**
 * 인터셉터 핸들러
 * 
 * @author GW
 */
@Slf4j
public class AccountHandlerInterceptor extends HandlerInterceptorAdapter{

	//요청이 들어오면 처리하기 이전에 가로채는 메소드
	//현재 기능 : 로그인된 상태이면 회원가입페이지 이동시 가로챔. 
	//실제 구현 : InterceptorMvcConfiguration.java 에서 실행.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("~~~~~ 인터셉터 요청 uri : " + request.getRequestURI());
		HttpSession session= request.getSession(true);
		log.info("~~~~~ 인터셉터 로그인 여부 : " + session.getAttribute("userInfo"));
		
		if(session.getAttribute("userInfo") != null) {
			response.sendRedirect("/RattaDoEat/loginError");
		return true;
			
		}
		response.sendRedirect("/RattaDoEat/join2.go");
		return false;
}	
	
}
