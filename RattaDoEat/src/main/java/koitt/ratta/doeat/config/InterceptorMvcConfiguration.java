package koitt.ratta.doeat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 인터셉터 설정
 * 
 * @author GW
 */
@Configuration
public class InterceptorMvcConfiguration implements WebMvcConfigurer {

	//스프링 MVC 라이프사이클에 사전처리, 사후처리 (요청 실행 처리 전,후를  가로챔)를 위한 인터셉터 추가.
	//현재 기능 : 아래 추가된 uri 는 인터셉터 핸들러를 탄다.
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new AccountHandlerInterceptor())
		.addPathPatterns("/join.go");
		
	}
}
