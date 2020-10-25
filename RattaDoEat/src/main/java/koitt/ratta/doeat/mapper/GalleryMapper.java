package koitt.ratta.doeat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import koitt.ratta.doeat.domain.GalleryVo;

@Mapper
public interface GalleryMapper {
	
	@Select("SELECT * FROM com_gallery")
	public List<GalleryVo> viewAll();
	
	@Update("UPDATE com_gallery"
			+ " SET LIKE_NUM = LIKE_NUM+1"
			+ " WHERE G_IDX = #{gIdx, jdbcType=INTEGER}")
	public int addLike(int gIdx);
	
	@Select("SELECT LIKE_NUM"
			+ " FROM com_gallery"
			+ " WHERE G_IDX = #{gIdx}")
	public int viewLike(int gIdx);

}
