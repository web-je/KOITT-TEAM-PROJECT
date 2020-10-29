package koitt.ratta.doeat.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import koitt.ratta.doeat.domain.GalleryLikeVo;


@Mapper
public interface LikeMapper {
	
	@Insert("INSERT INTO gallery_like"
			+ " VALUES(g_l_idx_seq.NEXTVAL, #{uIdx}, #{gIdx})")
	public int addLike(GalleryLikeVo galleryLikeVo);
	
	


}
