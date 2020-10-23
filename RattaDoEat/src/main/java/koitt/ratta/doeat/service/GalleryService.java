package koitt.ratta.doeat.service;

import java.util.List;

import koitt.ratta.doeat.domain.GalleryVo;

public interface GalleryService {

	List<GalleryVo> viewAll();

	int addLike(int gIdx);

}
