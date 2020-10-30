package koitt.ratta.doeat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import koitt.ratta.doeat.domain.GalleryScrapVo;
import koitt.ratta.doeat.service.ScrapService;

@RestController
public class ScrapController {
	
	@Autowired
	ScrapService service;
	
	// 갤러리 게시글 스크랩
	@GetMapping("gallery_scrap")
	public int addScrap(int gIdx, Model model) {
		GalleryScrapVo galleryScrapVo = GalleryScrapVo.builder().gIdx(gIdx).build();
		return service.addScrap(galleryScrapVo);
	}

}
