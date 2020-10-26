package koitt.ratta.doeat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import koitt.ratta.doeat.domain.GalleryVo;
import koitt.ratta.doeat.service.SortService;

@Controller
public class SortController {
	
	@Autowired
	SortService service;
	
	// 갤러리 정렬
	@GetMapping("sort_by")
	public @ResponseBody List<GalleryVo> sortBy(String column, Model model) {
		model.addAttribute("sort", column);
		System.out.println(service.sortBy(column).get(0).getContent());
		return service.sortBy(column);
	}

}
