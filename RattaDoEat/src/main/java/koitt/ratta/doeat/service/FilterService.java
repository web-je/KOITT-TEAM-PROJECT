package koitt.ratta.doeat.service;

import java.util.List;

import koitt.ratta.doeat.domain.GalleryListVo;

public interface FilterService {

	List<GalleryListVo> addFilter(String[] types);

}
