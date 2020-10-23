package koitt.ratta.doeat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import koitt.ratta.doeat.domain.GalleryVo;

@Mapper
public interface GalleryMapper {
	
	@Select("SELECT * FROM com_gallery")
	List<GalleryVo> viewAll();

}
