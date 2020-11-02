package koitt.ratta.doeat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import lombok.extern.slf4j.Slf4j;


@Slf4j
//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(4);
	}
	
	//커스텀프로바이더 사용시
//	@Bean
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
	
	//기본프로바이더사용시에 쓰는 configure. Authentication객체를 받은 매니저가 구조를 검증해서 프로바이더에게 전달합니다. 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		super.configure(auth);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception { //url 보안경로지정
		
		http.authorizeRequests()
			.antMatchers("/static/**", "/home", "/", "/join**", "/gallery").permitAll()
			//.antMatchers("/admin**","/admin/**").hasRole("ADMIN") //hasRole 인메모리 테스트용.
			.antMatchers("/admin**","/admin/**").hasAuthority("ROLE_ADMIN") //hasAuthority DB용
			//.antMatchers("/user/**").hasRole("USER")
			.antMatchers("/user/**").hasAuthority("ROLE_USER")
			.anyRequest().authenticated() //어떤 롤이든 상관없이 인증만되면 된다. 나머지 모든 리퀘스트는 인증이 필요하다, 는 구문
			.and()
		.formLogin()
			.loginPage("/login.go")
			.permitAll()
			.and()
		.logout() //기본값 "/logout" 세션 무효화
			.permitAll()
			.and()
			
		.sessionManagement()
			.maximumSessions(1)//동시세션,중복로그인
			.expiredUrl("/login.go"); 
	}

	
	//테스트용 인메모리 유저, 어드민 데이터
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		UserDetails user = 
				User.withDefaultPasswordEncoder()
				.username("user").password("1234").roles("USER").build();
		UserDetails admin =
				User.withDefaultPasswordEncoder()
				.username("admin").password("1234").roles("ADMIN").build();
				
		return new InMemoryUserDetailsManager(user, admin);
	}
	
}
