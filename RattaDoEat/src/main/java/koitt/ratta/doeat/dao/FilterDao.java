package koitt.ratta.doeat.dao;

import java.util.List;

import koitt.ratta.doeat.domain.GalleryListVo;

public interface FilterDao {

	List<GalleryListVo> addFilter(String typesForSQL);

}