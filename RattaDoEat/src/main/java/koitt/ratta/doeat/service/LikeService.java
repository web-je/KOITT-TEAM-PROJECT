package koitt.ratta.doeat.service;

import koitt.ratta.doeat.domain.GalleryLikeVo;

public interface LikeService {

	void addLike(GalleryLikeVo galleryLikeVo);

	void unLike(GalleryLikeVo galleryLikeVo);

}
