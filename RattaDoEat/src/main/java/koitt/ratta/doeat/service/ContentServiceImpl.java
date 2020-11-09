package koitt.ratta.doeat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import koitt.ratta.doeat.domain.ContentVO;

import koitt.ratta.doeat.dao.ContentDao;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentDao dao;
	
	@Transactional(readOnly=true)
	@Override
	public List<ContentVO> getAll(){
		return dao.getAll();
	}
	
	@Override
	public void write(ContentVO vo) {
		dao.write(vo);
	}
	
	@Override
	public ContentVO read(int rIdx) {
		dao.hitUpdate(rIdx);
		return dao.read(rIdx);
	}
	
	@Override
	public void update(ContentVO vo) {
		dao.update(vo);
	}
	
	@Override
	public void delete(int rIdx) {
		dao.delete(rIdx);
	}
	
	@Override
	public void likeNumUpdate(int rIdx) {
		dao.likeNumUpdate(rIdx);
	}
	
	@Override
	public void scrapNumUpdate(int rIdx) {
		dao.scrapNumUpdate(rIdx);
	}
	
}
