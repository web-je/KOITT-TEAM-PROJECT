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
	
	@Override
	public int addLike(int gIdx) {
		int result = dao.addLike(gIdx);	
		System.out.println("@@@@@@@@@@" + result);
		if (result == 1) {
			return dao.viewLike(gIdx);
		}
		return 0;
	}

}
