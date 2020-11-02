package koitt.ratta.doeat.service;

import java.util.List;

import koitt.ratta.doeat.domain.GalleryListVo;

public interface GalleryService {

	List<GalleryListVo> viewAll(int loginUIdx);

}
