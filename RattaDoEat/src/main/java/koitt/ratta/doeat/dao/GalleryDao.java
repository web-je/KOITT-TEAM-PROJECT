package koitt.ratta.doeat.dao;

import java.util.List;

import koitt.ratta.doeat.domain.GalleryListVo;
import koitt.ratta.doeat.domain.FollowVo;

public interface GalleryDao {

	List<GalleryListVo> viewAll();

	int isFollow(FollowVo followVo);

}
