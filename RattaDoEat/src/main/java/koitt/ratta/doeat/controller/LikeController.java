package koitt.ratta.doeat.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import koitt.ratta.doeat.domain.AccountEntity;
import koitt.ratta.doeat.domain.GalleryLikeVo;
import koitt.ratta.doeat.service.LikeService;

/**
 * 
 * @author 진민영
 *
 */
@RestController
public class LikeController {
	
	@Autowired
	LikeService service;
	
	/**
	 * 갤러리 좋아요 데이터 삽입
	 * 
	 * @param gIdx 게시글 인덱스
	 * @param model
	 * @param session
	 * @return 좋아요 횟수
	 */
	@GetMapping("gallery_like")
	public int addLike(int gIdx, Model model, HttpSession session) {
		
		// 로그인한 유저 인덱스
		AccountEntity userInfo = (AccountEntity) session.getAttribute("userInfo");
		int uIdx = userInfo.getUIdx().intValue();
		
		// 쿼리용 vo 생성해 서비스에 전달
		GalleryLikeVo galleryLikeVo = GalleryLikeVo.builder().uIdx(uIdx)
															 .gIdx(gIdx).build();
		
		return service.addLike(galleryLikeVo);
	}
}
