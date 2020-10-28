package koitt.ratta.doeat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koitt.ratta.doeat.dao.GalleryDao;
import koitt.ratta.doeat.domain.GalleryJoinLikeVo;
import koitt.ratta.doeat.domain.GalleryVo;

@Service
public class GalleryServiceImpl implements GalleryService{
	
	@Autowired
	GalleryDao dao;
	
	@Override
	public List<GalleryJoinLikeVo> viewAll() {
		return dao.viewAll();
	}
	
}
