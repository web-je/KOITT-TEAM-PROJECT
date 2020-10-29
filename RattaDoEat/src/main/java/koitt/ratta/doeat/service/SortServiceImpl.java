package koitt.ratta.doeat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koitt.ratta.doeat.dao.SortDao;
import koitt.ratta.doeat.domain.GalleryListVo;

@Service
public class SortServiceImpl implements SortService{
	
	@Autowired
	SortDao dao;
	
	@Override
	public List<GalleryListVo> sortBy(String column) {
		return dao.sortBy(column);
	}

}
