package koitt.ratta.doeat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import koitt.ratta.doeat.domain.GalleryVo;

@Mapper
public interface GalleryMapper {
	
	@Select("SELECT * FROM com_gallery")
	List<GalleryVo> viewAll();
	
	@Update("UPDATE com_gallery"
			+ " SET LIKE_NUM = LIKE_NUM+1"
			+ " WHERE G_IDX = #{gIdx}")
	int addLike(int gIdx);
	
	@Select("SELECT LIKE_NUM"
			+ " FROM com_gallery"
			+ " WHERE G_IDX = #{gIdx}")
	int viewLike(int gIdx);

}
