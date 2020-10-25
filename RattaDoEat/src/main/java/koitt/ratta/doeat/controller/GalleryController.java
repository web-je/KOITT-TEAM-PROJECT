package koitt.ratta.doeat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import koitt.ratta.doeat.service.GalleryService;

@Controller
public class GalleryController {
	
	@Autowired
	GalleryService service;
	
	@GetMapping("gallery")
	public String viewAllGallery(Model model) {
		model.addAttribute("gallery", service.viewAll());
		return "galleryList";
	}
	
	@GetMapping("gallery_like")
	public @ResponseBody int addLike(int gIdx) {
		int result = service.addLike(gIdx);
		return result;
	}

}
