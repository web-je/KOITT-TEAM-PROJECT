package koitt.ratta.doeat.dao;

import java.util.List;

import koitt.ratta.doeat.domain.GalleryVo;

public interface FilterDao {

	List<GalleryVo> addFilter(String type);

}
