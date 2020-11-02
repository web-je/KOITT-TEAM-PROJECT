package koitt.ratta.doeat.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import koitt.ratta.doeat.domain.GalleryListVo;
import koitt.ratta.doeat.domain.FollowVo;

@Repository
public class GalleryDaoImpl implements GalleryDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	String path = "koitt.ratta.doeat.mapper.GalleryMapper.";

	@Override
	public List<GalleryListVo> viewAll() {
		return sqlSession.selectList(path + "viewAll");
	}
	
	@Override
	public int isFollow(FollowVo followVo) {
		return sqlSession.selectOne(path + "isFollow", followVo);
	}

}
