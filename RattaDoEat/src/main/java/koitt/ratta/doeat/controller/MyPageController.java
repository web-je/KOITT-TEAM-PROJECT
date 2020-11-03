package koitt.ratta.doeat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import koitt.ratta.doeat.service.MyPageService;

@Controller
public class MyPageController {
	
	@Autowired
	MyPageService service;
	
	@GetMapping("mypage")
	public String viewMyPage(Model model) {
		// 서버에서 받은 로그인 정보로 대체할 것
		int uIdx = 3;
		
		// 모델 1. 유저 정보
		model.addAttribute("user", uIdx);
		
		// 모델 2. 유저 작성 갤러리 리스트 최근 10개
		model.addAttribute("gallery", service.viewMyGallery(uIdx));
		
		// 모델 3. 유저 작성 레시피북 리스트 최근 10개
		model.addAttribute("recipe", service.viewMyGallery(uIdx));
		
		return "myPage";
	}
}
