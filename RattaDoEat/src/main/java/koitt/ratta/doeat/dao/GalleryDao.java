package koitt.ratta.doeat.dao;

import java.util.List;

import koitt.ratta.doeat.domain.GLikeVo;
import koitt.ratta.doeat.domain.GalleryVo;

public interface GalleryDao {

	List<GalleryVo> viewAll();

	List<GLikeVo> countLike();

}
