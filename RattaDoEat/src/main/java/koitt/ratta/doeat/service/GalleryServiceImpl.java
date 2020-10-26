package koitt.ratta.doeat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koitt.ratta.doeat.domain.FileVo;
import koitt.ratta.doeat.domain.GalleryVo;
import koitt.ratta.doeat.mapper.GalleryMapper;

@Service
public class GalleryServiceImpl implements GalleryService{
	
	@Autowired
	GalleryMapper mapper;
	
	@Override
	public List<GalleryVo> viewAll() throws Exception {
		return mapper.viewAll();
	}

	@Override
	public int insertG(GalleryVo vo) {
		return mapper.insertG(vo);
	}

	@Override
	public int insertP(FileVo file) {
		return mapper.insertP(file);
	}

}
