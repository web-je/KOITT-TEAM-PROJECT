package koitt.ratta.doeat.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koitt.ratta.doeat.dao.FilterDao;
import koitt.ratta.doeat.dao.FollowDao;
import koitt.ratta.doeat.dao.LikeDao;
import koitt.ratta.doeat.domain.FollowVo;
import koitt.ratta.doeat.domain.GalleryLikeVo;
import koitt.ratta.doeat.domain.GalleryListVo;

@Service
public class FilterServiceImpl implements FilterService {
	
	@Autowired
	FilterDao dao;
	
	@Autowired
	FollowDao followDao;
	
	@Autowired
	LikeDao likeDao;

	@Override
	public List<GalleryListVo>changeFilter(Map<String, String[]> types, int loginUIdx) {
		String[] types1 = types.get("types1");
		String[] types2 = types.get("types2");
		String column = types.get("column")[0];
		
		String types1ForSQL = "";
		String types2ForSQL = "";
		
		types1ForSQL = "(TYPE1 LIKE '%" + types1[0] + "%'";
		
		for(int i=1; i<types1.length; i++) {
			types1ForSQL += " OR TYPE1 LIKE '%" + types1[i] + "%'";
		}
		
		types1ForSQL += ")";
		

		types2ForSQL = " AND (TYPE2 LIKE '%" + types2[0] + "%'";
			
		for(int i=1; i<types2.length; i++) {
				types2ForSQL += " AND TYPE2 LIKE '%" + types2[i] + "%'";
		}
			
		types2ForSQL += ")";
		
		List<GalleryListVo> galleryWithoutUserInfo = dao.changeFilter("WHERE " + types1ForSQL + types2ForSQL + " ORDER BY " + column);
		
		// 유저 정보가 없는 경우 추가 가공 없이 리턴
		if (loginUIdx == 0) {
			return galleryWithoutUserInfo;
		}

		List<GalleryListVo> gallery = new ArrayList<GalleryListVo>();
		FollowVo followVo;
		GalleryLikeVo likeVo;
		
		// 게시글별로 추가 필드 데이터 생성하여 새로운 리스트를 작성
		for (GalleryListVo post : galleryWithoutUserInfo) {
			
			// 팔로우 여부 조회용 vo 생성
			// 게시글 글쓴이를 기준으로 로그인 유저의 팔로우 여부 조회
			followVo = FollowVo.builder().fromUIdx(loginUIdx)
										 .toUIdx(post.getUIdx()).build();
			boolean isFollow = followDao.isFollow(followVo) == 1;
			
			// 좋아요 여부 조회용 vo 생성
			// 게시글을 기준으로 로그인 유저의 좋아요 여부 조회
			likeVo = GalleryLikeVo.builder().gIdx(post.getGIdx())
											.uIdx(loginUIdx).build();
			boolean isLike = likeDao.isLike(likeVo) == 1;
			
			GalleryListVo tmpPost = GalleryListVo.builder().gIdx(post.getGIdx())
														   .uIdx(post.getUIdx())
														   .content(post.getContent())
														   .regDate(post.getRegDate())
														   .modifyDate(post.getModifyDate())
														   .hit(post.getHit())
														   .type1(post.getType1())
														   .type2(post.getType2())
														   .likeCnt(post.getLikeCnt())
														   .scarpCnt(post.getScrapCnt())
														   .isFollow(isFollow)
														   .isLike(isLike).build();
			
			gallery.add(tmpPost);
			
		}
		
		return gallery;
		
	}

}
