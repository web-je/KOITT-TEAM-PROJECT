package koitt.ratta.doeat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import koitt.ratta.doeat.service.FilterService;
import koitt.ratta.doeat.service.SortService;

@Controller
public class FilterController {
	
	@Autowired
	FilterService service;
	
	// 갤러리 필터
	@GetMapping("add_filter")
	public String addFilter(String type, Model model) {
		model.addAttribute("gallery", service.addFilter(type));
		return "galleryList :: #galList";
	}
}
