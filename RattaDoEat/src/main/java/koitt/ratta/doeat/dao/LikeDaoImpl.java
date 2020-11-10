package koitt.ratta.doeat.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import koitt.ratta.doeat.domain.GalleryLikeVo;

/**
 * 
 * @author seanxxo
 * @since
 *
 */
@Repository
public class LikeDaoImpl implements LikeDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	String path = "koitt.ratta.doeat.mapper.LikeMapper.";

	// galleryLike DB 존재여부
	// 존재시 return g_l_idx
	// 존재하지 않을 시 return 0
	@Override
	public int isLike(GalleryLikeVo galleryLikeVo) {
		return sqlSession.selectOne(path + "isLike", galleryLikeVo);
	}

	@Override
	public int addLike(GalleryLikeVo galleryLikeVo) {
		return sqlSession.insert(path + "addLike", galleryLikeVo);
	}

	@Override
	public int viewLike(int gIdx) {
		return sqlSession.selectOne(path + "viewLike", gIdx);
	}
}
