package koitt.ratta.doeat.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import koitt.ratta.doeat.domain.GLikeVo;
import koitt.ratta.doeat.domain.GalleryVo;

@Repository
public class GalleryDaoImpl implements GalleryDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	String path = "koitt.ratta.doeat.mapper.GalleryMapper.";

	@Override
	public List<GalleryVo> viewAll() {
		return sqlSession.selectList(path + "viewAll");
	}

	@Override
	public List<GLikeVo> countLike() {
		return sqlSession.selectList(path + "countLike");
	}
	
}
