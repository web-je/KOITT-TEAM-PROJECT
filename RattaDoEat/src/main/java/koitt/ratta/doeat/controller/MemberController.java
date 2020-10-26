package koitt.ratta.doeat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author GW
 * 작성일 2020-10-26
 */
@Controller
public class MemberController {
	
	//기본 홈 이동
	@RequestMapping("/")
	public String main(Model model) {
		model.addAttribute("hello", "model 안녕하세요.");
		return "/home";
	}
	@RequestMapping("home")
	public String main2(Model model) {
		return "/home";
	}
	@RequestMapping("hello")
	public String goHello(Model model) {
		return "hello";
	}
	
	//로그인 페이지 이동
	@RequestMapping("login.go")
	public String goLogin() {
		
		return "auth/login";
	}
	
	//로그인 
	@RequestMapping("login.do")
	public String doLogin() {
		return "auth/login";
		//return "home";
	}
	
	//가입 페이지 이동
	@RequestMapping("join.go")
	public String goJoin() {
		
		return "auth/join";
	}
	
	//가입
	@RequestMapping("join.do")
	public String doJoin() {
		return "auth/userinfo"; //환영, user info 폼 이동
	}
		
	//아이디 찾기 폼 이동
	@RequestMapping("userFindId.go")
	public String userFindIdGo (Model model) {
		return "auth/userFindId";
	}
		
	//비밀번호 찾기 폼 이동 	
	@RequestMapping("userFindPw.go")
	public String userFindIdPw (Model model) {
		return "auth/userFindPw";
	}	
	
	//로그인 에러 
	@RequestMapping("/error2")
	public String loginErrorGo(Model model) {
		return "error/error";
	}	
}
