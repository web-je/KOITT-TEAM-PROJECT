package koitt.ratta.doeat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import koitt.ratta.doeat.service.ContentService;
import koitt.ratta.doeat.domain.ContentVO;
//import lombok.extern.java.Log;

@Controller
//@Log
public class ComRecipeContoller {

	@Autowired
	private ContentService service;

	@RequestMapping("/getAll")
	public String getAll(Model model) {
//		log.info("getAll");
		model.addAttribute("list", service.getAll());
		return "recipe/getAll";
	}
	
	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	@GetMapping("/recipeInsert")
	public String home() {
		return "recipe/insertDemo";
	}

	@PostMapping("/insert")
	public String insert(ContentVO vo) {
		service.write(vo);
//		log.info(vo.toString());
		return "redirect:/getAll";
	}

	@RequestMapping("/updatePage")
	public String updatePage(@RequestParam("rIdx") int rIdx, Model model) {
		model.addAttribute("rIdxList", service.read(rIdx));
		return "recipe/update";
	}

	@RequestMapping("/update")
	public String update(ContentVO vo) {
		service.update(vo);
		return "redirect:/getAll";
	}

	@RequestMapping("/detail")
	public String detail(@RequestParam("rIdx") int rIdx, Model model) {
		model.addAttribute("rIdxList", service.read(rIdx));
		return "recipe/detail";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("rIdx") int rIdx) {
		service.delete(rIdx);
		return "redirect:/getAll";
	}

	@RequestMapping("/likeNumUpdate")
	public String likeNumUpdate(@RequestParam("rIdx") int rIdx) {
		service.likeNumUpdate(rIdx);
		return "redirect:/getAll";
	}

	@RequestMapping("/scrapNumUpdate")
	public String scrapNumUpdate(@RequestParam("rIdx") int rIdx) {
		service.scrapNumUpdate(rIdx);
		return "redirect:/getAll";
	}
}
