package koitt.ratta.doeat.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import koitt.ratta.doeat.domain.GalleryListVo;

@Repository
public class SortDaoImpl implements SortDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	String path = "koitt.ratta.doeat.mapper.SortMapper.";

	@Override
	public List<GalleryListVo> sortBy(String column){
		return sqlSession.selectList(path + "sortBy", column);
	}

}
