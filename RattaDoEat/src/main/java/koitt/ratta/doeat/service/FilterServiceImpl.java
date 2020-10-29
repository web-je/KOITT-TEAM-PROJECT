package koitt.ratta.doeat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koitt.ratta.doeat.dao.FilterDao;
import koitt.ratta.doeat.domain.GalleryListVo;

@Service
public class FilterServiceImpl implements FilterService {
	
	@Autowired
	FilterDao dao;

	@Override
	public List<GalleryListVo> addFilter(String[] types) {
		String typesForSQL = "TYPE1 LIKE '%" + types[0] + "%'";
		
		for(int i=1; i<types.length; i++) {
			typesForSQL += " OR TYPE1 LIKE '%" + types[i] + "%'";
		}
		
		return dao.addFilter(typesForSQL);
	}

}
