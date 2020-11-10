package koitt.ratta.doeat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import koitt.ratta.doeat.service.FollowService;
import koitt.ratta.doeat.service.GalleryService;

/**
 * 
 * @author seanxxo
 *
 */
@Controller
public class FollowController {
	
	@Autowired
	FollowService service;
	
	@Autowired
	GalleryService galleryService;
	
	@GetMapping("following")
	public String addFollow(int uIdx, Model model) {
		int loginUIdx = 3;
		service.addFollow(loginUIdx, uIdx);
		model.addAttribute("gallery", galleryService.viewAll(loginUIdx));
		return "galleryList :: #galList";
	}
	
	@GetMapping("unfollow")
	public String unFollow(int uIdx, Model model) {
		int loginUIdx = 3;
		service.unFollow(loginUIdx, uIdx);
		model.addAttribute("gallery", galleryService.viewAll(loginUIdx));
		return "galleryList :: #galList";
	}

}
