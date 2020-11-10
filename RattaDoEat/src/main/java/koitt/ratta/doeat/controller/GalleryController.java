package koitt.ratta.doeat.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import koitt.ratta.doeat.domain.AccountEntity;
import koitt.ratta.doeat.service.GalleryService;
import lombok.extern.slf4j.Slf4j;
/**
 * 11.03 수정 GW  : 갤러리 리스트 출력 viewAllGallery 에 세션으로 유저 정보 받는 코드 추가. 
 */
@Slf4j
@Controller
public class GalleryController {
	
	@Autowired
	GalleryService service;
	
	// 갤러리 리스트 출력
	@GetMapping("gallery")
	public String viewAllGallery(Model model, HttpSession session) {
		// 로그인 정보
		AccountEntity userInfo = (AccountEntity) session.getAttribute("userInfo");
		int loginUIdx = 0;
		
		// 로그인 정보 없을 경우
		if (userInfo == null) {
			log.info("host 갤러리 접속");
			
		// 로그인 정보 있을 경우
		} else {
			loginUIdx = userInfo.getUIdx().intValue();
			log.info("유저 " + loginUIdx + " 갤러리 접속");
		}
		
		model.addAttribute("gallery", service.viewAll(loginUIdx));
		
		return "galleryList";
	}
	
	@GetMapping("post")
	public String viewGallery(Model model, int gIdx) {
		model.addAttribute("gIdx", gIdx);
		return "gallery";
	}

}
