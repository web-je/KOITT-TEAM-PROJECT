package koitt.ratta.doeat.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import koitt.ratta.doeat.domain.AccountEntity;
import koitt.ratta.doeat.service.FollowService;
import koitt.ratta.doeat.service.GalleryService;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author seanxxo
 *
 */
@Slf4j
@Controller
public class FollowController {
	
	@Autowired
	FollowService service;
	
	@Autowired
	GalleryService galleryService;
	
	/**
	 * 로그인한 유저가 다른 유저를 팔로우
	 * 
	 * @param uIdx 팔로우할 유저 인덱스
	 * @param model
	 * @param session
	 * @return 페이지 유지상태로 게시판 정보 갱신하여 리턴
	 */
	@GetMapping("following")
	public String addFollow(int uIdx, Model model, HttpSession session) {
		// 로그인 정보
		AccountEntity userInfo = (AccountEntity) session.getAttribute("userInfo");
		int loginUIdx = 0;
		
		// 로그인 정보 없을 경우 팔로우 없이 리턴
		if (userInfo == null) {
			log.info("host 는 팔로우 접근 금지");
			model.addAttribute("gallery", galleryService.viewAll(loginUIdx));
			return "galleryList :: #galList";
			
		// 로그인 정보 있을 경우 서비스로 유저 정보 전달
		} else {
			loginUIdx = userInfo.getUIdx().intValue();
			log.info("유저 " + loginUIdx + " 팔로우 " + uIdx);
		}
		service.addFollow(loginUIdx, uIdx);
		
		// 게시판 정보 갱신
		model.addAttribute("gallery", galleryService.viewAll(loginUIdx));
		
		return "galleryList :: #galList";
	}
	
	/**
	 * 로그인한 유저가 다른 유저를 언팔로우
	 * 
	 * @param uIdx 언팔로우할 유저 인덱스
	 * @param model
	 * @param session
	 * @return 페이지 유저 상태로 게시판 정보 갱신하여 리턴
	 */
	@GetMapping("unfollow")
	public String unFollow(int uIdx, Model model, HttpSession session) {
		// 로그인 정보
		AccountEntity userInfo = (AccountEntity) session.getAttribute("userInfo");
		int loginUIdx = 0;
		
		// 로그인 정보 없을 경우 언팔로우 없이 리턴
		if (userInfo == null) {
			log.info("host 는 언팔로우 접근 금지");
			model.addAttribute("gallery", galleryService.viewAll(loginUIdx));
			return "galleryList :: #galList";
			
		// 로그인 정보 있을 경우 서비스로 유저 정보 전달
		} else {
			loginUIdx = userInfo.getUIdx().intValue();
			log.info("유저 " + loginUIdx + " 언팔로우 " + uIdx);
		}
		service.unFollow(loginUIdx, uIdx);
		
		// 게시판 정보 갱신
		model.addAttribute("gallery", galleryService.viewAll(loginUIdx));
		
		return "galleryList :: #galList";
	}

}
