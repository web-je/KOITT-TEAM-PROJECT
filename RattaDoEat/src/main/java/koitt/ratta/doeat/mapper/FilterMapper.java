package koitt.ratta.doeat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import koitt.ratta.doeat.domain.GalleryVo;

@Mapper
public interface FilterMapper {
	
	@Select("SELECT *"
			+ " FROM com_gallery"
			+ " WHERE ${typesForSQL}")
	public List<GalleryVo> addFilter(String typesForSQL);

}
