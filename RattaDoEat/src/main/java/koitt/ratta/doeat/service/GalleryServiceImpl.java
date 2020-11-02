package koitt.ratta.doeat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koitt.ratta.doeat.dao.GalleryDao;
import koitt.ratta.doeat.domain.GalleryListVo;
import koitt.ratta.doeat.domain.FollowVo;

@Service
public class GalleryServiceImpl implements GalleryService{
	
	@Autowired
	GalleryDao dao;
	
	@Override
	public List<GalleryListVo> viewAll(int loginUIdx) {
//		 로그인 정보에서 가져온 uIdx로 대체 예정
		
		List<GalleryListVo> galleryWithoutFollow = dao.viewAll();
		FollowVo followVo;
		List<GalleryListVo> gallery = new ArrayList<GalleryListVo>();
		
		for (GalleryListVo post : galleryWithoutFollow) {

			followVo = FollowVo.builder().fromUIdx(loginUIdx)
										 .toUIdx(post.getUIdx()).build();
			if (dao.isFollow(followVo) == 1) {
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
			} else if (dao.isFollow(followVo) == 0){
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
	
}
