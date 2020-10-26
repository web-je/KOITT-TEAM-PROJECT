package koitt.ratta.doeat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import koitt.ratta.doeat.service.ScrapService;

@Controller
public class ScrapController {
	
	@Autowired
	ScrapService service;
	
	// 갤러리 게시글 스크랩
	@GetMapping("gallery_scrap")
	public @ResponseBody int addScrap(int gIdx) {
		int result = service.addScrap(gIdx);
		return result;
	}

}
