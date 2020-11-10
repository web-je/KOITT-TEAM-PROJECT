
package koitt.ratta.doeat.config;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import koitt.ratta.doeat.domain.AccountEntity;
import koitt.ratta.doeat.domain.AccountRepository;
import koitt.ratta.doeat.service.AccountService;
import koitt.ratta.doeat.service.AccountServiceImpl;
import lombok.extern.slf4j.Slf4j;
/**
 * 커스텀 프로바이더 성공 핸들러
 * 로그인에 성공시 이 핸들러를 탑니다.
 * 
 * @author GW
 */
@Slf4j
public class CustomAuthenticationSuccess implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	// 로그인 성공시 이 메소드를 탑니다. 
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		log.info(" 커스텀 프로바이더 ~~~~ 로그인 성공");
		redirectStrategy.sendRedirect(request, response, "/login.do"); //성공하면 uri를 탄다.
	
	}
}