package koitt.ratta.doeat.service;

import java.util.List;

import koitt.ratta.doeat.domain.GalleryListVo;
import koitt.ratta.doeat.domain.GalleryVo;

public interface GalleryService {

	List<GalleryListVo> viewAll(int loginUIdx);

	// 게시물 작성
	public int insertG(GalleryVo vo);
	
	// 게시물 상세보기
	public GalleryVo viewDetail(int gIdx);
		
//	// 유저 이름 조회
//	public String userName(int gIdx);
}
