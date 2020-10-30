package koitt.ratta.doeat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koitt.ratta.doeat.dao.GalleryDao;
import koitt.ratta.doeat.dao.ScrapDao;
import koitt.ratta.doeat.domain.GalleryScrapVo;

@Service
public class ScrapServiceImpl implements ScrapService{
	
	@Autowired
	ScrapDao scrapDao;
	
	@Autowired
	GalleryDao galleryDao;

	@Override
	public int addScrap(GalleryScrapVo galleryScrapVo) {
		int result = scrapDao.addScrap(galleryScrapVo);
		
		if (result == 0) {
			return 0;
		}
		
		return scrapDao.viewScrap(galleryScrapVo.getGIdx());
	}

}
