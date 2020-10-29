package koitt.ratta.doeat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import koitt.ratta.doeat.domain.GalleryLikeVo;
import koitt.ratta.doeat.service.LikeService;

@Controller
public class LikeController {
	
	@Autowired
	LikeService service;
	
	// 갤러리 게시글 좋아요
	@GetMapping("gallery_like")
	public String addLike(int gIdx, Model model) {
		GalleryLikeVo galleryLikeVo = GalleryLikeVo.builder().gIdx(gIdx).build();
		model.addAttribute("gallery", service.addLike(galleryLikeVo));
		return "galleryList :: #galList";
	}

}
