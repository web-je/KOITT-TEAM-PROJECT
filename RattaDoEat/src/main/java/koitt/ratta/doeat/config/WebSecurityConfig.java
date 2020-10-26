package koitt.ratta.doeat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { //url 보안경로지정
		http.authorizeRequests()
			.antMatchers("/resources/**", "/home", "/", "/join.go", "/gallery").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login.go")
			.permitAll()
			.and()
		.logout() //기본값 "/logout" 세션 무효화
			.permitAll();
	}
	
	//테스트용 인메모리 유저, 어드민 데이터
	@Override
	protected UserDetailsService userDetailsService() {
		UserDetails user = 
				User.withDefaultPasswordEncoder()
				.username("user").password("1234").roles("USER").build();
		UserDetails admin =
				User.withDefaultPasswordEncoder()
				.username("admin").password("1234").roles("admin").build();
				
		return new InMemoryUserDetailsManager(user, admin);
	}
	
}
