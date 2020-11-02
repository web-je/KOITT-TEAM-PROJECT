package koitt.ratta.doeat.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koitt.ratta.doeat.dao.FilterDao;
import koitt.ratta.doeat.domain.GalleryListVo;

@Service
public class FilterServiceImpl implements FilterService {
	
	@Autowired
	FilterDao dao;

	@Override
	public List<GalleryListVo> changeFilter(Map<String, String[]> types) {
		String[] types1 = types.get("types1");
		String[] types2 = types.get("types2");
		String column = types.get("column")[0];
		
		String types1ForSQL = "";
		String types2ForSQL = "";
		
		types1ForSQL = "(TYPE1 LIKE '%" + types1[0] + "%'";
		
		for(int i=1; i<types1.length; i++) {
			types1ForSQL += " OR TYPE1 LIKE '%" + types1[i] + "%'";
		}
		
		types1ForSQL += ")";
		

		types2ForSQL = " AND (TYPE2 LIKE '%" + types2[0] + "%'";
			
		for(int i=1; i<types2.length; i++) {
				types2ForSQL += " AND TYPE2 LIKE '%" + types2[i] + "%'";
		}
			
		types2ForSQL += ")";
		
		System.out.println("WHERE " + types1ForSQL + types2ForSQL + " ORDER BY " + column);
			
		return dao.changeFilter("WHERE " + types1ForSQL + types2ForSQL + " ORDER BY " + column);
	}

}
