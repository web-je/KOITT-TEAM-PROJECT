package koitt.ratta.doeat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import koitt.ratta.doeat.domain.GalleryJoinLikeVo;

@Mapper
public interface GalleryMapper {
	
	@Select("SELECT * FROM com_gallery g"
			+ " LEFT OUTER JOIN"
				+ " (SELECT g_idx, COUNT(*) AS \"like\""
				+ " FROM gallery_like"
				+ " GROUP BY g_idx) c"
			+ " ON g.g_idx = c.g_idx"
			+ " ORDER BY g.g_idx")
	public List<GalleryJoinLikeVo> viewAll();
	
}
