package koitt.ratta.doeat.dao;

import java.util.List;

import koitt.ratta.doeat.domain.GalleryListVo;

public interface GalleryDao {

	List<GalleryListVo> viewAll();
	
	List<GalleryListVo> viewAllByUser(int u_idx);

}
