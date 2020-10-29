package koitt.ratta.doeat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koitt.ratta.doeat.dao.GalleryDao;
import koitt.ratta.doeat.dao.LikeDao;
import koitt.ratta.doeat.domain.GalleryLikeVo;
import koitt.ratta.doeat.domain.GalleryListVo;

@Service
public class LikeServiceImpl implements LikeService{
	
	@Autowired
	LikeDao likeDao;
	
	@Autowired
	GalleryDao galleryDao;
	
	@Override
	public List<GalleryListVo> addLike(GalleryLikeVo galleryLikeVo) {
		likeDao.addLike(galleryLikeVo);	
		return galleryDao.viewAll();
	}

}
