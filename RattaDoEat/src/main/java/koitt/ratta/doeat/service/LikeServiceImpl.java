package koitt.ratta.doeat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koitt.ratta.doeat.dao.LikeDao;
import koitt.ratta.doeat.domain.GalleryLikeVo;

/**
 * 
 * @author 진민영
 * @since
 * 
 */
@Service
public class LikeServiceImpl implements LikeService{
	
	@Autowired
	LikeDao likeDao;
	
	/**
	 * gallery_like 테이블에 데이터를 삽입
	 * 
	 * @param 좋아요 한 유저, 게시글 번호
	 */
	@Override
	public void addLike(GalleryLikeVo galleryLikeVo) {
		
		// 좋아요 존재 여부 조회
		int isLike = likeDao.isLike(galleryLikeVo);
		
		// 존재하지 않을 시에만 좋아요 데이터 삽입
		if (isLike == 0) {
			likeDao.addLike(galleryLikeVo);
		}
		
	}
	
	/**
	 * gallery_like 테이블에서 데이터를 삭제
	 * 
	 * @param galleryLikeVo 좋아요 한 유저, 게시글 번호
	 */
	@Override
	public void unLike(GalleryLikeVo galleryLikeVo) {
		
		// 좋아요 존재 여부 조회
		int isLike = likeDao.isLike(galleryLikeVo);
		
		// 존재시에만 좋아요 데이터 삭제
		if (isLike == 1) {
			likeDao.unLike(galleryLikeVo);
		}
	}

}
