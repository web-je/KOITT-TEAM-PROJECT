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
 * @author koitt04a
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
		
		//gw 수정
		AccountEntity userInfo=(AccountEntity)session.getAttribute("userInfo");
		model.addAttribute("gallery", service.viewAll(userInfo.getUIdx().intValue()));
		//model.addAttribute("gallery", service.viewAll(3);
		return "galleryList";
	}
	
	@GetMapping("post")
	public String viewGallery(Model model, int gIdx) {
		model.addAttribute("gIdx", gIdx);
		return "gallery";
	}
	
	@GetMapping("test")
	public String test() {
		return "test";
	}
	
	@GetMapping("test2")
	public String test2() {
		return "galleryList";
	}

}
