package koitt.ratta.doeat.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import koitt.ratta.doeat.domain.FileVo;

@Repository
public class FileUploadDaoImpl implements FileUploadDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertP(FileVo fileVo) {
		return sqlSession.insert("insetP", fileVo);
	}

	@Override
	public List<FileVo> viewPhoto(int gIdx) {
		return sqlSession.selectList("viewPhoto");
	}

}
