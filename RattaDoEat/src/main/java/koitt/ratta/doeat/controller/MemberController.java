package koitt.ratta.doeat.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import koitt.ratta.doeat.domain.AccountDto;
import koitt.ratta.doeat.domain.AccountEntity;
import koitt.ratta.doeat.service.AccountService;
import koitt.ratta.doeat.service.AccountServiceImpl;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
/**
 * @author GW
 * 작성일 2020-10-26
 */
@Slf4j
@Controller
//@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private AccountService accountService;
	
	//기본 홈 이동
	@RequestMapping(value = {"/", "home"})
	public String main(Model model, Principal principal) throws Exception {
		model.addAttribute("hello", "model 안녕하세요.");
		
		
		if(principal.getName() != null) {
			model.addAttribute("username", principal.getName());
			
		log.info("~~~~~ 로그인 유저아이디 확인 : principal.getName(); ~~ " + principal.getName());
		log.info("~~~~~ principal 1 : " + principal);
			
		/* principal 1과 2는 다른 객체이지만 똑같은 값을 가집니다. 코드가 짧은 1번을 쓰세요.*/
		Object principal2 = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails user = (UserDetails)principal2;
		//유저가 있을 경우 유저 정보 엔티티를 꺼내온다.  
		AccountEntity userInfo = accountService.findByuserId(user.getUsername());
		model.addAttribute("userInfo", userInfo);
		log.info(" ~~~~~ principal 2 : " + principal);
		log.info(" ~~~~~ 로그인한 유저의 엔티티 내용 userInfo : "+userInfo);
		}
	
		
	
		
		
		return "/home";
	}
	//테스트 페이지
	@RequestMapping("hello")
	public String goHello(Model model) {
		
		return "hello";
	}
	
	//로그인 페이지 이동
	@RequestMapping("login.go")
	public String goLogin() {
		return "auth/login";
	}
	
	//로그인 -------------서큐리티에서 자동으로 로그인을 해줘서 필요없는 코드입니다. 
	/*
	@RequestMapping("login.do")
	public String doLogin(@RequestParam("userId") String userId, @RequestParam String userPw, Model model) {
		log.info("~~ login.do로 넘어온 accountDto 계정정보 아이디,비밀번호 : " + userId +", "+ userPw);
		
		//로그인 서비스
		
		return "user/mypage";
		//return "home";
	}
	*/
	
	//가입 페이지 이동
	@RequestMapping("join.go")
	public String goJoin(Model model) {
		model.addAttribute("accountDto", new AccountDto()); //join페이지에 th:object에서 사용중인 accountDto가 비어있는걸 보내줘야 해당뷰에서 사용가능 타임리프 오브젝트로 받아서 join.do로 넘길수 있음.
		return "auth/join";
	}

	//가입
	@RequestMapping("join.do")
	public String doJoin(@ModelAttribute AccountDto accountDto, Model model) throws Exception {
	//public String doJoin(@ModelAttribute("accountDto") AccountDto dto, Model model) throws Exception {
		
		log.info("회원가입 폼에서 넘어오는 값 : " + accountDto);
		
		try {
			accountService.saveUser(accountDto);
			model.addAttribute("userName", accountDto.getName());
		} catch (Exception e) {
			model.addAttribute("failed", "가입실패. 다시 시도해주세요.");
			return "join.go";
		}
		
		return "hello"; //환영 페이지, user info 폼 이동
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
	@RequestMapping("/error.go")
	public String goLoginError(Model model, HttpSession session) {
		
		// Spring CustomProvider 인증(Auth) 에러 메시지 처리
    	log.info("##### 로그인 에러 처리 페이지 #####");
        Object secuSess = session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");

        log.info("#### 인증 오류 메시지 : " + secuSess);
        log.info("#### 인증 오류 메시지 : " + secuSess.toString());

        model.addAttribute("error", "true");
        model.addAttribute("msg", secuSess);
        
		//return "error/error";
        return "auth/login";
	}	
	
	@RequestMapping("/accessDenied.go")
	public String goAccessDenied() {
		
		// Spring CustomProvider 인증(Auth) 에러 메시지 처리
    	log.info("##### 접근금지, 에러 처리 페이지 #####");
		return "error/error";
        //return "auth/login";
	}
	
	//어드민 테스트 페이지 
	@RequestMapping("admin.go")
	public String goAdmin(Model model) {
		return "admin/admin";
	}
	//user 테스트 페이지 
	@RequestMapping("user/mypage.go")
	public String goMyPage(Model model) {
		return "user/mypage";
	}
	//user 테스트 페이지 2
	@Secured({"ROLE_USER"})
	@RequestMapping("mypage.go")
	public String goJoinMyPage(Model model) {
		model.addAttribute("환영메세지", "가입을 축하합니다.");
		return "user/mypage";
	}
	
	@RequestMapping("logout.go") //페이지 단순이동 
	public String doLogout() {
		return "auth/logout";
	}
	
	@RequestMapping("logout_proc.go")
	public String goLogout(HttpServletRequest request,
							HttpServletResponse response) {
		Authentication auth 
    	= SecurityContextHolder.getContext().getAuthentication();
    
    log.info("auth : "+auth);
    
    // logout !
    if (auth != null) {    
        new SecurityContextLogoutHandler().logout(request, response, auth);
    }
		return "auth/logout";
	}
	
	//유저 서비스
	
	//비밀번호 변경
	//인코딩된 값을 비교합니다. 
	
}
