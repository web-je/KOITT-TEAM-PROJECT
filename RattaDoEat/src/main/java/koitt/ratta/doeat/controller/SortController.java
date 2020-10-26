package koitt.ratta.doeat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import koitt.ratta.doeat.service.SortService;

@Controller
public class SortController {
	
	@Autowired
	SortService service;
	
	// 갤러리 정렬
	@GetMapping("sort_by")
	public String sortBy(String column, Model model) {
		model.addAttribute("gallery", service.sortBy(column));
		return "galleryList :: #galList";
	}
}
