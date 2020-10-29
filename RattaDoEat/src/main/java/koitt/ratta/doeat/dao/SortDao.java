package koitt.ratta.doeat.dao;

import java.util.List;

import koitt.ratta.doeat.domain.GalleryListVo;

public interface SortDao {

	List<GalleryListVo> sortBy(String column);

}
