package koitt.ratta.doeat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koitt.ratta.doeat.dao.GalleryDao;
import koitt.ratta.doeat.domain.GLikeVo;
import koitt.ratta.doeat.domain.GalleryVo;

@Service
public class GalleryServiceImpl implements GalleryService{
	
	@Autowired
	GalleryDao dao;
	
	@Override
	public List<GalleryVo> viewAll() {
		return dao.viewAll();
	}

	@Override
	public List<GLikeVo> countLike() {
		return dao.countLike();
	}
	
}
