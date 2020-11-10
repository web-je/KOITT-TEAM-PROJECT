package koitt.ratta.doeat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import koitt.ratta.doeat.domain.GalleryListVo;

@Mapper
public interface GalleryMapper {
	
	// 갤러리 테이블 전체 조회
	@Select("SELECT *"
			+ " FROM gallery_list")
	public List<GalleryListVo> viewAll();
	
	@Select("SELECT *"
			+ " FROM gallery_list"
			+ " WHERE u_idx = #{uIdx}")
	public List<GalleryListVo> viewAllByUser(int uIdx);
	
}
