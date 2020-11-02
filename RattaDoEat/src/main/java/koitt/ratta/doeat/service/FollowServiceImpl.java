package koitt.ratta.doeat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koitt.ratta.doeat.dao.FollowDao;
import koitt.ratta.doeat.domain.FollowVo;

@Service
public class FollowServiceImpl implements FollowService {

	@Autowired
	FollowDao dao;
	
	@Override
	public int addFollow(int loginUIdx, int uIdx) {
		FollowVo followVo = FollowVo.builder().fromUIdx(loginUIdx)
											  .toUIdx(uIdx).build();
		if (dao.isFollow(followVo) != 0) {
			return 0;
		}
		int result = dao.addFollow(followVo);
		if (result != 1) {
			return 0;
		}
		return 0;
	}
	
	@Override
	public int unFollow(int loginUIdx, int uIdx) {
		FollowVo followVo = FollowVo.builder().fromUIdx(loginUIdx)
											  .toUIdx(uIdx).build();
		if (dao.isFollow(followVo) != 0) {
			return 0;
		}
		int result = dao.unFollow(followVo);
		if (result != 1) {
			return 0;
		}
		return 0;
	}
	
}
