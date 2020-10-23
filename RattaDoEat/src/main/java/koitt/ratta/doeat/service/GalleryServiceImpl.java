package koitt.ratta.doeat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koitt.ratta.doeat.dao.GalleryDao;
import koitt.ratta.doeat.domain.GalleryVo;

@Service
public class GalleryServiceImpl implements GalleryService{
	
	@Autowired
	GalleryDao dao;
	
	@Override
	public List<GalleryVo> viewAll() {
		return dao.viewAll();
	}
	
//	@Override
//	public int addLike(int gIdx) {
//		int result = dao.addLike(gIdx);	
//		if (result != 1) {
//			return false;
//		}
//		return true;
//	}
//	
//	@Override
//	public int viewLike(int gIdx) {
//		return dao.viewLike(gIdx);
//	}
	
	@Override
	public int addLike(int gIdx) {
		dao.addLike(gIdx);
		
		return dao.viewLike(gIdx);
	}

}
