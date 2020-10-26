package koitt.ratta.doeat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import koitt.ratta.doeat.service.LikeService;

@Controller
public class LikeController {
	
	@Autowired
	LikeService service;
	
	// 갤러리 게시글 좋아요
	@GetMapping("gallery_like")
	public @ResponseBody int addLike(int gIdx) {
		int result = service.addLike(gIdx);
		return result;
	}

}
