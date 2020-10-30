package koitt.ratta.doeat.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import koitt.ratta.doeat.domain.GalleryScrapVo;

@Repository
public class ScrapDaoImpl implements ScrapDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	String path = "koitt.ratta.doeat.mapper.ScrapMapper.";

	@Override
	public int addScrap(GalleryScrapVo galleryScrapVo) {
		return sqlSession.update(path + "addScrap", galleryScrapVo);
	}

	@Override
	public int viewScrap(int gIdx) {
		return sqlSession.selectOne(path + "viewScrap", gIdx);
	}
}
