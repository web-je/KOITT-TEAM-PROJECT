package koitt.ratta.doeat.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
// import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import lombok.extern.slf4j.Slf4j; 
 /**
  * 커스텀 프로바이더 실패 핸들러
  * 
  * @author GW
  */
@Slf4j
public class CustomAuthenticationFailure extends SimpleUrlAuthenticationFailureHandler { // implements AuthenticationFailureHandler {

	//로그인 실패시 아래 메소드를 탑니다.
	@Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {

		log.info("로그인 실패");
		
		this.setDefaultFailureUrl("/error.go");
		super.onAuthenticationFailure(request, response, exception);

    }
	
}