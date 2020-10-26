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
	
	String galleryPath = "koitt.ratta.doeat.mapper.GalleryMapper.";

	@Override
	public List<GalleryVo> viewAll() {
		return sqlSession.selectList(galleryPath + "viewAll");
	}
	
	@Override
	public int addLike(int gIdx) {
		return sqlSession.update(galleryPath + "addLike", gIdx);
	}
	
	@Override
	public int viewLike(int gIdx) {
		return sqlSession.selectOne(galleryPath + "viewLike", gIdx);
	}

}
