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

@Service
public class GalleryServiceImpl implements GalleryService{
	
	@Autowired
	GalleryDao dao;
	
	@Autowired
	FollowDao followDao;
	
	@Override
	public List<GalleryListVo> viewAll(int loginUIdx) {
		
		// 유저 정보 없이 게시글 조회
		List<GalleryListVo> galleryWithoutFollow = dao.viewAll();
		
		// 유저 정보가 없는 경우 팔로우 없이 리턴
		if (loginUIdx == 0) {
			return galleryWithoutFollow;
		}
		
		// 유저 정보 
		FollowVo followVo;
		List<GalleryListVo> gallery = new ArrayList<GalleryListVo>();
		
		// 조회한 게시글 리스트를 기준으로 팔로 여부 조회하여 삽입하여 리턴
		// (새로운 리스트를 생성함)
		for (GalleryListVo post : galleryWithoutFollow) {
			
			// 로그인 유저 정보, 조회한 게시글의 글쓴이 정보 활용하여 팔로우 여부 조회
			followVo = FollowVo.builder().fromUIdx(loginUIdx)
										 .toUIdx(post.getUIdx()).build();
			
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
			
			// 에러 케이스
			} else {
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
