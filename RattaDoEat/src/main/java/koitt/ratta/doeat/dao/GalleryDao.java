package koitt.ratta.doeat.dao;

import java.util.List;

import koitt.ratta.doeat.domain.GalleryVo;

public interface GalleryDao {

	List<GalleryVo> viewAll();

	int addLike(int gIdx);

	int viewLike(int gIdx);

}
