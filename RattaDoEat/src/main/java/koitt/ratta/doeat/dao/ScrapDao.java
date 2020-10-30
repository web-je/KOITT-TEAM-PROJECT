package koitt.ratta.doeat.dao;

import koitt.ratta.doeat.domain.GalleryScrapVo;

public interface ScrapDao {

	int addScrap(GalleryScrapVo galleryScrapVo);

	int viewScrap(int gIdx);

}
