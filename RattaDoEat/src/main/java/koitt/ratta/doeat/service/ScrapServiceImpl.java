package koitt.ratta.doeat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koitt.ratta.doeat.dao.GalleryDao;
import koitt.ratta.doeat.dao.ScrapDao;
import koitt.ratta.doeat.domain.GalleryListVo;
import koitt.ratta.doeat.domain.GalleryScrapVo;

@Service
public class ScrapServiceImpl implements ScrapService{
	
	@Autowired
	ScrapDao scrapDao;
	
	@Autowired
	GalleryDao galleryDao;

	@Override
	public List<GalleryListVo> addScrap(GalleryScrapVo galleryScrapVo) {
		scrapDao.addScrap(galleryScrapVo);	
		return galleryDao.viewAll();
	}

}
