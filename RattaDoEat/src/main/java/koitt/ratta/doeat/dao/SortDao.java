package koitt.ratta.doeat.dao;

import java.util.List;

import koitt.ratta.doeat.domain.GalleryVo;

public interface SortDao {

	List<GalleryVo> sortBy(String column);

}
