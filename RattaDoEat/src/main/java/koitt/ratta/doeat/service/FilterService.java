package koitt.ratta.doeat.service;

import java.util.List;

import koitt.ratta.doeat.domain.GalleryVo;

public interface FilterService {

	List<GalleryVo> addFilter(String[] types);

}
