package koitt.ratta.doeat.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface LikeMapper {
	
	@Insert("INSERT gallery_like"
			+ " VALUES(g_l_idx_seq.NEXTVAL, #{uIdx}, #{gIdx})")
	public int addLike(int gIdx);
	
	


}
