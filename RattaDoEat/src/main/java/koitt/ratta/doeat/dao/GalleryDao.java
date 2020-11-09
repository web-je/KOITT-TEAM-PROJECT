package koitt.ratta.doeat.dao;

import java.util.List;

import koitt.ratta.doeat.domain.GalleryListVo;

public interface GalleryDao {

	/**
	 * 갤러리 리스트 전부 출력.
	 * @return
	 */
	List<GalleryListVo> viewAll();

	List<GalleryListVo> viewAllByUser(int uIdx);
}
