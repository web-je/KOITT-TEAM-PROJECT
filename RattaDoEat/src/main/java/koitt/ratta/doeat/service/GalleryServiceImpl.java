package koitt.ratta.doeat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koitt.ratta.doeat.dao.FollowDao;
import koitt.ratta.doeat.dao.GalleryDao;
import koitt.ratta.doeat.dao.LikeDao;
import koitt.ratta.doeat.domain.GalleryListVo;
import koitt.ratta.doeat.domain.GalleryVo;
import lombok.var;
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
	
	@Autowired
	LikeDao likeDao;
	
	/**
	 * galleryList.html용 list 생성
	 * @author 진민영
	 */
	@Override
	public List<GalleryListVo> viewAll(int loginUIdx) {
		
		// 유저 정보 없이, 사진 정보 가공안된 상태로 데이터 조회
		// 유저정보 없음 == isFollow, isLike 의 내용이 없음
		List<GalleryListVo> galleryWithoutUserInfo = dao.viewAll();
		
		// 유저 정보가 있는 경우
		List<GalleryListVo> gallery = new ArrayList<GalleryListVo>();
		FollowVo followVo;
		GalleryLikeVo likeVo;
		
		// 게시글별로 추가 필드 데이터 생성하여 새로운 리스트를 작성
		for (GalleryListVo post : galleryWithoutUserInfo) {
			
			// 빌더 타입 추론
			var builder = GalleryListVo.builder();
			
			// 사전에 조회한 정보들
			builder.gIdx(post.getGIdx())
				   .uIdx(post.getUIdx())
				   .content(post.getContent())
				   .regDate(post.getRegDate())
				   .modifyDate(post.getModifyDate())
				   .hit(post.getHit())
				   .type1(post.getType1())
				   .type2(post.getType2())
				   .nickname(post.getNickname())
				   .name(post.getName())
				   .likeCnt(post.getLikeCnt())
				   .scarpCnt(post.getScrapCnt());
			
			
			// 갤러리 이미지 파일 uuid 구분자 기준으로 나누기
			if (post.getImgUuid() != null) {
				
				String[] images = post.getImgUuid().split("/");
				
				builderUuidMapper[] arr = {
					() -> {builder.imgUuid(images[0]);},
					() -> {builder.imgUuid2(images[1]);},
					() -> {builder.imgUuid3(images[2]);},
					() -> {builder.imgUuid4(images[3]);},
					() -> {builder.imgUuid5(images[4]);}
				};

				for (int i=0; i<images.length; i++) {
					arr[i].map();
				}
				
			}
			
			// 유저 정보가 없는 경우 여기서 빌드 완료
			if (loginUIdx == 0) {
				gallery.add(builder.build());
				
			// 유저 정보가 있는 경우
			} else {
				
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
				
				builder.isFollow(isFollow)
					   .isLike(isLike);
				
				gallery.add(builder.build());
			}
			
		}
		
		return gallery;
	}
	
	/**
	 * img_uuid 빌드를 위한 인터페이스
	 * @author 진민영
	 */
	public static interface builderUuidMapper{
		public void map();
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
