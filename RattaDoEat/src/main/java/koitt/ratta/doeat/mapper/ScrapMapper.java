package koitt.ratta.doeat.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import koitt.ratta.doeat.domain.GalleryScrapVo;

@Mapper
public interface ScrapMapper {
	
	@Insert("INSERT INTO gallery_scrap"
			+ " VALUES(g_s_idx_seq.NEXTVAL, #{uIdx}, #{gIdx})")
	public int addScrap(GalleryScrapVo vo);

}
