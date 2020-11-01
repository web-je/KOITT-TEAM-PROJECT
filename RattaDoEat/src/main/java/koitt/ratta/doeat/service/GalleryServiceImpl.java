package koitt.ratta.doeat.service;

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
	public List<GalleryListVo> viewAll() {
		// 로그인 정보에서 가져온 uIdx로 대체 예정
//		int loginUIdx = 3;
//		List<FollowVo> followers = dao.isFollow(loginUIdx);
//		List<GalleryListVo> gallery = dao.viewAll();
//		
//		for (GalleryListVo post : gallery) {
//			for (FollowVo follower : followers) {
//				follower.getToUIdx();
//				if(post.getUIdx() == follower.getToUIdx());
//			}
//		}
//		
//		for (GalleryListVo post : gallery) {
//			System.out.println(post.getUIdx());
//			System.out.println(post.getIsFollow());
//		}
		
		return dao.viewAll();
	}
	
}
