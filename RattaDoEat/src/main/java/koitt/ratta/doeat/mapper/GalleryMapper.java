package koitt.ratta.doeat.mapper;

import java.util.List;

import koitt.ratta.doeat.domain.FileVo;
import koitt.ratta.doeat.domain.GalleryVo;

public interface GalleryMapper {

	public List<GalleryVo> viewAll() throws Exception;
	
	public int insertG(GalleryVo vo);
	
	//파일 업로드
	int insertP(FileVo file);
}
