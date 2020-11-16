package koitt.ratta.doeat.dao;

import java.util.List;

import koitt.ratta.doeat.domain.comCommentVO;

public interface CommentDao {

	List<comCommentVO> viewAllByGIdx(int gIdx);

	List<comCommentVO> viewAllByRIdx(int rIdx);

}
