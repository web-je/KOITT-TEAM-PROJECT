package koitt.ratta.doeat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import koitt.ratta.doeat.domain.GalleryListVo;

@Mapper
public interface SortMapper {
	
	@Select("SELECT *"
			+ " FROM gallery_list"
			+ " ORDER BY ${column} DESC")
	public List<GalleryListVo> sortBy(String column);

}
