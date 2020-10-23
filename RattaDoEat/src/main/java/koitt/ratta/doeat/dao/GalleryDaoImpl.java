package koitt.ratta.doeat.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import koitt.ratta.doeat.domain.GalleryVo;

@Repository
public class GalleryDaoImpl implements GalleryDao{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<GalleryVo> viewAll() {
		return sqlSession.selectList("koitt.ratta.doeat.mapper.GalleryMapper.viewAll");
	}

}
