package koitt.ratta.doeat.service;

import java.util.List;

import koitt.ratta.doeat.domain.GalleryListVo;
import koitt.ratta.doeat.domain.GalleryScrapVo;

public interface ScrapService {

	List<GalleryListVo> addScrap(GalleryScrapVo galleryScrapVo);

}
