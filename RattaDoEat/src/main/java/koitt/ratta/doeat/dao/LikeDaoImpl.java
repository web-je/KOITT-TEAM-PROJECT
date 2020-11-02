package koitt.ratta.doeat.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import koitt.ratta.doeat.domain.GalleryLikeVo;

@Repository
public class LikeDaoImpl implements LikeDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	String path = "koitt.ratta.doeat.mapper.LikeMapper.";

	@Override
	public int addLike(GalleryLikeVo galleryLikeVo) {
		return sqlSession.insert(path + "addLike", galleryLikeVo);
	}

	@Override
	public int viewLike(int gIdx) {
		return sqlSession.selectOne(path + "viewLike", gIdx);
	}
}
