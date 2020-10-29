package koitt.ratta.doeat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import koitt.ratta.doeat.domain.GalleryScrapVo;
import koitt.ratta.doeat.service.ScrapService;

@Controller
public class ScrapController {
	
	@Autowired
	ScrapService service;
	
	// 갤러리 게시글 스크랩
	@GetMapping("gallery_scrap")
	public String addScrap(int gIdx, Model model) {
		GalleryScrapVo galleryScrapVo = GalleryScrapVo.builder().gIdx(gIdx).build();
		model.addAttribute("gallery", service.addScrap(galleryScrapVo));
		return "galleryList :: #galList";
	}

}
