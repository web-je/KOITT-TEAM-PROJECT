package koitt.ratta.doeat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koitt.ratta.doeat.domain.GalleryVo;

@Service
public class SortServiceImpl implements SortService{
	
	@Autowired
	SortService dao;
	
	@Override
	public List<GalleryVo> sortBy(String column) {
		return dao.sortBy(column);
	}

}
