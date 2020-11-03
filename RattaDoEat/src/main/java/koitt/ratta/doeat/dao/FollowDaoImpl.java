package koitt.ratta.doeat.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import koitt.ratta.doeat.domain.FollowVo;

@Repository
public class FollowDaoImpl implements FollowDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	String path = "koitt.ratta.doeat.mapper.FollowMapper.";

	@Override
	public int isFollow(FollowVo followVo) {
		return sqlSession.selectOne(path + "isFollow", followVo);
	}
	
	@Override
	public int addFollow(FollowVo followVo) {
		return sqlSession.insert(path + "addFollow", followVo);
	}
	
	@Override
	public int unFollow(FollowVo followVo) {
		return sqlSession.delete(path + "unFollow", followVo);
	}

}
