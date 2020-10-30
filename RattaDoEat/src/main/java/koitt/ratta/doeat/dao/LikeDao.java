package koitt.ratta.doeat.dao;

import koitt.ratta.doeat.domain.GalleryLikeVo;

public interface LikeDao {

	int addLike(GalleryLikeVo galleryLikeVo);

	int viewLike(int gIdx);

}
