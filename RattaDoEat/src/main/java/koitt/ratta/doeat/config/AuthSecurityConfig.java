package koitt.ratta.doeat.config;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import koitt.ratta.doeat.service.CustomProvider;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

/**
 * @author javateam
 *
 */
@Slf4j
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class AuthSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SessionRegistry sessionRegistry; //세션 등록 담당빈
	@Autowired
	private DataSource dataSource; // 추가
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private CustomProvider customProvider;

	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(4);
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception { //인증 객체 관리자
		return super.authenticationManagerBean();
	}

	@Bean(name = "sessionRegistry")
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception { //커스텀 프로바이더 추가. 없으면 기본프로바이더로 작동. 
		auth.authenticationProvider(customProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.headers().frameOptions().sameOrigin();

		http.authorizeRequests()
					.antMatchers("/error.go").permitAll()
					.antMatchers("/static/**", "/home", "/", "/join**", "/gallery").permitAll()
					.antMatchers("/admin**","/admin/**").hasAuthority("ROLE_ADMIN") //hasAuthority DB용
					.antMatchers("/user/**").hasAuthority("ROLE_USER")
					.anyRequest().authenticated() //어떤 롤이든 상관없이 인증만되면 된다. 나머지 모든 리퀘스트는 인증이 필요하다
					.and()
//				.csrf()
//					.ignoringAntMatchers("/member/member_join.do") //제외
//					.ignoringAntMatchers("/login.do")
//					.ignoringAntMatchers("/login_error.do")
//					.and()
				.formLogin()
					.loginPage("/login.go")
					// .loginProcessingUrl("/login.do")
					// .defaultSuccessUrl("/welcome.do")
					// .failureUrl("/login_error.do") //아래 핸들러 역할과 같은 구문. 
					.successHandler(new CustomAuthenticationSuccess()) // 로그인 성공시 핸들러
					.failureHandler(new CustomAuthenticationFailure()) // 로그인 실패시 핸들러
					.permitAll()
					.and()
				.logout()
					.permitAll()
					.logoutUrl("/logout.go")
					.deleteCookies("JSESSIONID") //쿠키는 클라이언트에만 저장. 안해도 되지만 확실하게 브라우저 제이세션까지 모두 삭제. 
					.and()
				.exceptionHandling()
					.accessDeniedPage("/accessDenied.go") // 권한이 없을경우 해당 url로 이동 /403대응
					.and()
				.sessionManagement() // 세션 제어
					.maximumSessions(1) // 최대 동시 세션 사용수(중복 로그인 가능 설정시 활용) //한계정에서 여러명 XXX
					.expiredUrl("/login.do")
					.sessionRegistry(sessionRegistry);

		//리멤버미 아직 구현안함 ----------
		// 추가된 부분 : remember-me 관련
		// remember-me cookie
		// => 사용자이름 + cookie expired time(만료 시간) + 패쓰워드 => Base64(Md5방식) 암호화
		/*
		 * base64(username + ":" + expirationTime + ":" + md5Hex(username + ":" +
		 * expirationTime + ":" password + ":" + key))
		 */
		http.rememberMe().key("javateam").userDetailsService(userDetailsService).tokenRepository(getJDBCRepository())
				.tokenValiditySeconds(60 * 60 * 24); // 24시간(1일)
	}

	// 추가된 remember-me 관련 메서드
	private PersistentTokenRepository getJDBCRepository() {

		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();

		repo.setDataSource(dataSource);

		return repo;
	}

}