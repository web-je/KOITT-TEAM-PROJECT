package koitt.ratta.doeat.dao;

import koitt.ratta.doeat.domain.FollowVo;

public interface FollowDao {

	int isFollow(FollowVo followVo);

	int addFollow(FollowVo followVo);

	int unFollow(FollowVo followVo);

}
