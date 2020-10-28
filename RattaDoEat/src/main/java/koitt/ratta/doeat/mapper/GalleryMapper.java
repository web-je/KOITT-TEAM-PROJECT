package koitt.ratta.doeat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import koitt.ratta.doeat.domain.GLikeVo;
import koitt.ratta.doeat.domain.GalleryVo;

@Mapper
public interface GalleryMapper {
	
	@Select("SELECT * FROM com_gallery g"
			+ " LEFT OUTER JOIN"
				+ " (SELECT g_idx, COUNT(*) AS \"like\""
				+ " FROM com_gallery NATURAL JOIN gallery_like"
				+ " GROUP BY g_idx) c"
			+ " ON g.g_idx = c.g_idx")
	public List<GalleryVo> viewAll();
	
}
