package koitt.ratta.doeat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koitt.ratta.doeat.dao.FollowDao;
import koitt.ratta.doeat.dao.GalleryDao;
import koitt.ratta.doeat.domain.GalleryListVo;
import koitt.ratta.doeat.domain.GalleryVo;
import koitt.ratta.doeat.domain.FollowVo;
import koitt.ratta.doeat.domain.GalleryLikeVo;

/**
 * 
 * @author 진민영, 송정은
 *
 */
@Service
public class GalleryServiceImpl implements GalleryService{
	
	@Autowired
	GalleryDao dao;
	
	@Autowired
	FollowDao followDao;
	
	/**
	 * 작성중 입니다
	 */
	@Override
	public List<GalleryListVo> viewAll(int loginUIdx) {
		
		// 유저 정보 없이 게시글 조회
		// 조회해온 데이터에는 isFollow, isLike 의 내용이 없음
		List<GalleryListVo> galleryWithoutUserInfo = dao.viewAll();
		
		// 유저 정보가 없는 경우 추가 가공 없이 리턴
		if (loginUIdx == 0) {
			return galleryWithoutUserInfo;
		}
		
		// 유저 정보가 있는 경우
		List<GalleryListVo> gallery = new ArrayList<GalleryListVo>();
		FollowVo followVo;
		GalleryLikeVo likeVo;
		
		// 게시글별로 추가 필드 데이터 생성하여 새로운 리스트를 작성
		for (GalleryListVo post : galleryWithoutUserInfo) {
			
			// 팔로우 여부 조회용 vo 생성
			// 게시글 글쓴이를 기준으로 로그인 유저의 팔로우 여부 조회
			followVo = FollowVo.builder().fromUIdx(loginUIdx)
										 .toUIdx(post.getUIdx()).build();
			// 좋아요 여부 조회용 vo 생성
			// 게시글을 기준으로 로그인 유저의 좋아요 여부 조회
			likeVo = GalleryLikeVo.builder().gIdx(post.getGIdx())
											.uIdx(loginUIdx).build();
			
			// 팔로우 테이블 존재시 true 삽입
			if (followDao.isFollow(followVo) == 1) {
				GalleryListVo tmpPost = GalleryListVo.builder()
													 .gIdx(post.getGIdx())
													 .uIdx(post.getUIdx())
													 .content(post.getContent())
													 .regDate(post.getRegDate())
													 .modifyDate(post.getModifyDate())
													 .hit(post.getHit())
													 .type1(post.getType1())
													 .type2(post.getType2())
													 .likeCnt(post.getLikeCnt())
													 .scarpCnt(post.getScrapCnt())
													 .isFollow(true).build();
				gallery.add(tmpPost);
				
			// 팔로우 테이블 존재하지 않을 시 false 삽입
			} else if (followDao.isFollow(followVo) == 0){
				GalleryListVo tmpPost = GalleryListVo.builder()
													 .gIdx(post.getGIdx())
													 .uIdx(post.getUIdx())
													 .content(post.getContent())
													 .regDate(post.getRegDate())
													 .modifyDate(post.getModifyDate())
													 .hit(post.getHit())
													 .type1(post.getType1())
													 .type2(post.getType2())
													 .likeCnt(post.getLikeCnt())
													 .scarpCnt(post.getScrapCnt())
													 .isFollow(false).build();
				gallery.add(tmpPost);
			}
			
		}
		
		return gallery;
	}
	
	@Override
	public int insertG(GalleryVo vo) {
		return dao.insertG(vo);
	}

	@Override
	public GalleryVo viewDetail(int gIdx) {
		return dao.viewDetail(gIdx);
	}

//	@Override
//	public String userName(int gIdx) {
//		return mapper.userName(gIdx);
//	}
}
