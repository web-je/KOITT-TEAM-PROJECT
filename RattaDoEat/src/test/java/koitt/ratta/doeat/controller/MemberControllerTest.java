package koitt.ratta.doeat.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;

import lombok.extern.slf4j.Slf4j;

/**
 * 멤버 컨트롤러 테스트. 시큐리티가 들어갑니다.
 * 
 * @author GW
 *
 */
@SpringBootTest
@WebAppConfiguration
@Slf4j
public class MemberControllerTest {

	@Autowired
	private WebApplicationContext wac; //웹어플리케이션 패스를 
	
	@Autowired
	private FilterChainProxy fcp;
	
	@Autowired
	private MemberController memberController;
	
	private MockMvc mockMvc;
	
	@BeforeEach //선수작업
	public void setup() {
		log.info("준비작업");
		//mockMvc = MockMvcBuilders.webAppContextSetup(wac) //전통적인 방법
		 mockMvc = MockMvcBuilders.standaloneSetup(memberController)
			    .apply(springSecurity(fcp))
			    .build();
	}
	
//	@Test
//	void test() {
//		log.info("테스트 시작");
//		mockMvc.perform(formLogin(("/login.go")
//				.user("username","id@naver.com").password("password","1234"))
//				.andExpect(authenticated().withUsername("id@naver.com")));
//	}
}
