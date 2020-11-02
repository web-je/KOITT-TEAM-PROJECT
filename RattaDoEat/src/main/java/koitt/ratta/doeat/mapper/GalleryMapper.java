package koitt.ratta.doeat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import koitt.ratta.doeat.domain.GalleryListVo;
import koitt.ratta.doeat.domain.FollowVo;

@Mapper
public interface GalleryMapper {
	
	@Select("SELECT *"
			+ " FROM gallery_list")
	public List<GalleryListVo> viewAll();
	
	@Select("SELECT COUNT(ROWNUM)"
			+ " FROM follow"
			+ " WHERE from_u_idx = #{fromUIdx} AND to_u_idx = #{toUIdx}")
	public int isFollow(FollowVo followVo);
	
}
