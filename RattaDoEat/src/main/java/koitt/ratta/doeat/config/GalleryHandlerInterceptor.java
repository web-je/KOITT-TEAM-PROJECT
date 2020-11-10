package koitt.ratta.doeat.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GalleryHandlerInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("~~~~~ 요청 uri : " + request.getRequestURI());
		HttpSession session= request.getSession(true);
		log.info("~~~~~ 인터셉터 로그인 여부 : " + session.getAttribute("userInfo"));
		//if(request.authenticate(response)) {
		if(session.getAttribute("userInfo") != null) {
			
			ModelAndView mv = new ModelAndView(); //여기서 안보내짐. 이미로그인 레스트컨트롤러로 얼럿보내기.
			mv.setViewName("/");
			mv.addObject("login", "이미 로그인 하셨습니다.");
			log.info("~~~~~mv객체  : " +mv.addObject("login", "이미 로그인 하셨습니다."));
			response.sendRedirect("/RattaDoEat/loginError");
		return true;
			
		}
		// TODO Auto-generated method stub
		response.sendRedirect("/RattaDoEat/join2.go");
		return false;
}	
	
}
