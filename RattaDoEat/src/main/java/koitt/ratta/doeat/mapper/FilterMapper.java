package koitt.ratta.doeat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import koitt.ratta.doeat.domain.GalleryListVo;

@Mapper
public interface FilterMapper {
	
	@Select("SELECT *"
			+ " FROM gallery_list"
			+ " WHERE ${typesForSQL}")
	public List<GalleryListVo> addFilter(String typesForSQL);

}
