package koitt.ratta.doeat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koitt.ratta.doeat.dao.GalleryDao;
import koitt.ratta.doeat.domain.GalleryListVo;

@Service
public class GalleryServiceImpl implements GalleryService{
	
	@Autowired
	GalleryDao dao;
	
	@Override
	public List<GalleryListVo> viewAll() {
		return dao.viewAll();
	}
	
}
