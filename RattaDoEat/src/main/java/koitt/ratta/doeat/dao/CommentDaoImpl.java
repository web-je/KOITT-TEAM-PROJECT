package koitt.ratta.doeat.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import koitt.ratta.doeat.domain.comCommentVO;

@Repository
public class CommentDaoImpl implements CommentDao {
	
	@Autowired
	SqlSession sqlsession;
	
	String path = "koitt.ratta.doeat.mapper.CommentMapper.";

	@Override
	public List<comCommentVO> viewAllByGIdx(int gIdx) {
		return sqlsession.selectList(path + "viewAllByGIdx", gIdx);
	}
	
	@Override
	public List<comCommentVO> viewAllByRIdx(int rIdx) {
		return sqlsession.selectList(path + "viewAllByUIdx", rIdx);
	}

}
