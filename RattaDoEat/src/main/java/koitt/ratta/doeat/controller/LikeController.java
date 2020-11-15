package koitt.ratta.doeat.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import koitt.ratta.doeat.domain.AccountEntity;
import koitt.ratta.doeat.domain.GalleryLikeVo;
import koitt.ratta.doeat.service.GalleryService;
import koitt.ratta.doeat.service.LikeService;

/**
 * 
 * @author 진민영
 *
 */
@Controller
public class LikeController {
	
	@Autowired
	LikeService service;
	
	@Autowired
	GalleryService galleryService;
	
	/**
	 * 갤러리 좋아요 데이터 삽입
	 * 
	 * @param gIdx 게시글 인덱스
	 * @param session 로그인 정보
	 * @return 
	 */
	@GetMapping("gallery_like")
	public String addLike(int gIdx, HttpSession session, Model model) {
		
		// 로그인한 유저 인덱스
		AccountEntity userInfo = (AccountEntity) session.getAttribute("userInfo");
		int uIdx = userInfo.getUIdx().intValue();
		
		// 좋아요 정보 vo 생성해 서비스에 전달
		GalleryLikeVo galleryLikeVo = GalleryLikeVo.builder().uIdx(uIdx)
															 .gIdx(gIdx).build();
		service.addLike(galleryLikeVo);
		
		// 전체 게시글 재조회하여 리턴
		model.addAttribute("gallery", galleryService.viewAll(uIdx));
		return "galleryList :: #galList";
	}
	
	/**
	 * 갤러리 좋아요 데이터 삭제
	 * 
	 * @param gIdx 게시글 인덱스
	 * @param session 로그인 정보
	 * @return 
	 */
	@GetMapping("gallery_unlike")
	public String unLike(int gIdx, HttpSession session, Model model) {
		
		// 로그인한 유저 인덱스
		AccountEntity userInfo = (AccountEntity) session.getAttribute("userInfo");
		int uIdx = userInfo.getUIdx().intValue();
		
		// 쿼리용 vo 생성해 서비스에 전달
		GalleryLikeVo galleryLikeVo = GalleryLikeVo.builder().uIdx(uIdx)
															 .gIdx(gIdx).build();
		service.unLike(galleryLikeVo);
		
		// 전체 게시글 재조회하여 리턴
		model.addAttribute("gallery", galleryService.viewAll(uIdx));
		return "galleryList :: #galList"; 
	}
}
