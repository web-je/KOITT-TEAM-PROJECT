package koitt.ratta.doeat.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 계정 인터셉터 핸들러 테스트
 * 
 * @author GW
 *
 */
@SpringBootTest
public class AccountHandlerInterceptorTest extends HandlerInterceptorAdapter{

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		request.authenticate(response);
		
		return super.preHandle(request, response, handler);
		}
}
