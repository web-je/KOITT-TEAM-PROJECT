package koitt.ratta.doeat.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import koitt.ratta.doeat.service.FilterService;

@Controller
public class FilterController {
	
	@Autowired
	FilterService service;
	
	// 갤러리 필터
	@PostMapping("add_filter")
	public String addFilter(@RequestBody Map<String, String[]> types, Model model) {
		model.addAttribute("gallery", service.addFilter(types.get("types")));
		return "galleryList :: #galList";
	}
}
