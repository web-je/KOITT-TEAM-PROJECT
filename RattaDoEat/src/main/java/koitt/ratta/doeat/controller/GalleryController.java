package koitt.ratta.doeat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import koitt.ratta.doeat.service.GalleryService;

@Controller
public class GalleryController {
	
	@Autowired
	GalleryService service;
	
	// 갤러리 리스트 출력
	@GetMapping("gallery")
	public String viewAllGallery(Model model) {
		model.addAttribute("gallery", service.viewAll(3));
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
