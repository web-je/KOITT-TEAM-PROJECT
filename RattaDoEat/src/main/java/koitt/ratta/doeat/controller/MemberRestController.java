package koitt.ratta.doeat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRestController {

	/**
	 * 로그인 상태에서 회원가입 시도 에러
	 */
	@GetMapping("loginError")
	public String loginError() {
		return "<script>alert('이미 로그인 되어있습니다.'); history.back();</script>";
	}
}
