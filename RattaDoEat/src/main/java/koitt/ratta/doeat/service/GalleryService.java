package koitt.ratta.doeat.service;

import java.util.List;

import koitt.ratta.doeat.domain.FileVo;
import koitt.ratta.doeat.domain.GalleryVo;

public interface GalleryService {

	public List<GalleryVo> viewAll() throws Exception;
	
	//업로드
	public int insertG(GalleryVo vo);

	//파일 업로드
	int insertP(FileVo file);
}
