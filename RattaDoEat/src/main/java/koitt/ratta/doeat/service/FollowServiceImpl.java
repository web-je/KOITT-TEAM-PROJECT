package koitt.ratta.doeat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koitt.ratta.doeat.dao.FollowDao;
import koitt.ratta.doeat.domain.FollowVo;

/**
 * 
 * @author seanxxo
 *
 */
@Service
public class FollowServiceImpl implements FollowService {

	@Autowired
	FollowDao dao;
	
	/**
	 * 팔로우 테이블 데이터 삽입
	 * 
	 * @param loginUIdx 로그인한 유저 인덱스
	 * @param uIdx 팔로우할 유저 인덱스
	 */
	@Override
	public void addFollow(int loginUIdx, int uIdx) {
		// 팔로우 유저 정보를 담은 vo 생성
		FollowVo followVo = FollowVo.builder().fromUIdx(loginUIdx)
											  .toUIdx(uIdx).build();
		
		// 팔로우 여부 조회하여 존재하지 않을 시 데이터 삽입
		if (dao.isFollow(followVo) == 0) {
			dao.addFollow(followVo);
		}
	}
	
	/**
	 * 팔로우 테이블 데이터 삭제
	 * 
	 * @param loginUIdx 로그인한 유저 인덱스
	 * @param uIdx 언팔로우할 유저 인덱스
	 */
	@Override
	public void unFollow(int loginUIdx, int uIdx) {
		// 팔로우 유저 정보를 담은 vo 생성
		FollowVo followVo = FollowVo.builder().fromUIdx(loginUIdx)
											  .toUIdx(uIdx).build();
		
		// 팔로우 여부 조회하여 존재시 데이터 삭제
		if (dao.isFollow(followVo) == 1) {
			dao.unFollow(followVo);
		}
	}
	
}
