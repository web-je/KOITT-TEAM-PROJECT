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
	@PostMapping("filter_on")
	public String filterType1(@RequestBody Map<String, String[]> types, Model model) {
		System.out.println(model.getAttribute("gallery"));
		model.addAttribute("gallery", service.changeFilter(types));
		return "galleryList :: #galList";
	}
	
}
