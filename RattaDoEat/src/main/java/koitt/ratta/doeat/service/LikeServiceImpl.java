package koitt.ratta.doeat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koitt.ratta.doeat.dao.LikeDao;
import koitt.ratta.doeat.domain.GalleryLikeVo;

@Service
public class LikeServiceImpl implements LikeService{
	
	@Autowired
	LikeDao likeDao;
	
	@Override
	public int addLike(GalleryLikeVo galleryLikeVo) {
		int result = likeDao.addLike(galleryLikeVo);
		
		if (result == 0) {
			return 0;
		}
		
		return likeDao.viewLike(galleryLikeVo.getGIdx());
	}

}
