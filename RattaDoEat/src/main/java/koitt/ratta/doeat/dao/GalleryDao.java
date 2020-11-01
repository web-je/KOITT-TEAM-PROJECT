package koitt.ratta.doeat.dao;

import java.util.List;
import java.util.Map;

import koitt.ratta.doeat.domain.GalleryListVo;
import koitt.ratta.doeat.domain.FollowVo;

public interface GalleryDao {

	List<GalleryListVo> viewAll();

	List<FollowVo> isFollow(Map<String, Integer> uIdxs);

}
