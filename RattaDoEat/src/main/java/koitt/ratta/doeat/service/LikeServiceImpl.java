package koitt.ratta.doeat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koitt.ratta.doeat.dao.LikeDao;
import koitt.ratta.doeat.domain.GalleryLikeVo;

/**
 * @author seanxxo
 * @since
 */
@Service
public class LikeServiceImpl implements LikeService{
	
	@Autowired
	LikeDao likeDao;
	
	/**
	 * gallery_like 테이블에 좋아요 데이터를 삽입합니다.
	 * 
	 * @param 좋아요 한 유저, 게시글 번호
	 * @return 게시글 좋아요 횟수
	 */
	@Override
	public int addLike(GalleryLikeVo galleryLikeVo) {
		
		// 좋아요 존재 여부 조회
		int isLike = likeDao.isLike(galleryLikeVo);
		
		// 존재하지 않을 시 좋아요 데이터 삽입
		if (isLike == 0) {
			likeDao.addLike(galleryLikeVo);
		}
		
		// 좋아요 횟수 조회하여 리턴
		return likeDao.viewLike(galleryLikeVo.getGIdx());
	}

}
