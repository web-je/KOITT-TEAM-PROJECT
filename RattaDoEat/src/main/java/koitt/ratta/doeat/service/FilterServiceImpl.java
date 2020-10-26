package koitt.ratta.doeat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koitt.ratta.doeat.dao.FilterDao;
import koitt.ratta.doeat.domain.GalleryVo;

@Service
public class FilterServiceImpl implements FilterService {
	
	@Autowired
	FilterDao dao;

	@Override
	public List<GalleryVo> addFilter(String type) {
		return dao.addFilter(type);
	}

}
