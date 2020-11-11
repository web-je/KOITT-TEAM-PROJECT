package koitt.ratta.doeat.service;

import koitt.ratta.doeat.domain.GalleryLikeVo;

public interface LikeService {

	int addLike(GalleryLikeVo galleryLikeVo);

	int unLike(GalleryLikeVo galleryLikeVo);

}
