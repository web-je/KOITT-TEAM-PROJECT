package koitt.ratta.doeat.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import koitt.ratta.doeat.domain.AccountEntity;
import koitt.ratta.doeat.service.FilterService;

/**
 * 
 * @author 진민영
 *
 */
@Controller
public class FilterController {
	
	@Autowired
	FilterService service;
	
	// 갤러리 필터
	@PostMapping("filter_on")
	public String filterType1(@RequestBody Map<String, String[]> types, Model model, HttpSession session) {

		// 로그인 정보
		AccountEntity userInfo = (AccountEntity) session.getAttribute("userInfo");
		int loginUIdx = 0;
		
		// 로그인 정보 있을 경우
		if (userInfo != null) {
			loginUIdx = userInfo.getUIdx().intValue();
		}
		
		model.addAttribute("gallery", service.changeFilter(types, loginUIdx));
		return "galleryList :: #galList";
	}
	
}
