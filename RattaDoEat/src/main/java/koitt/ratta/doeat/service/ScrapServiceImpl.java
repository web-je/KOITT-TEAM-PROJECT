package koitt.ratta.doeat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koitt.ratta.doeat.dao.ScrapDao;

@Service
public class ScrapServiceImpl implements ScrapService{
	
	@Autowired
	ScrapDao dao;
	
	@Override
	public int addScrap(int gIdx) {
		int result = dao.addScrap(gIdx);	
		if (result == 1) {
			return dao.viewScrap(gIdx);
		}
		return 0;
	}

}
