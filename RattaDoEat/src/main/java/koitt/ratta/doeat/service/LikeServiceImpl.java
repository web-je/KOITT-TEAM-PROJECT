package koitt.ratta.doeat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koitt.ratta.doeat.dao.LikeDao;

@Service
public class LikeServiceImpl implements LikeService{
	
	@Autowired
	LikeDao dao;
	
	@Override
	public int addLike(int gIdx) {
		int result = dao.addLike(gIdx);	
		if (result == 1) {
			return dao.viewLike(gIdx);
		}
		return 0;
	}

}
