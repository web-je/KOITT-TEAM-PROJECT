package koitt.ratta.doeat.service;

import java.util.List;

import koitt.ratta.doeat.domain.GalleryLikeVo;
import koitt.ratta.doeat.domain.GalleryListVo;

public interface LikeService {

	List<GalleryListVo> addLike(GalleryLikeVo galleryLikeVo);

}
