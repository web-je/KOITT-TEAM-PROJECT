package koitt.ratta.doeat.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface LikeMapper {
	
	@Update("UPDATE com_gallery"
			+ " SET LIKE_NUM = LIKE_NUM+1"
			+ " WHERE G_IDX = #{gIdx}")
	public int addLike(int gIdx);
	
	@Select("SELECT LIKE_NUM"
			+ " FROM com_gallery"
			+ " WHERE G_IDX = #{gIdx}")
	public int viewLike(int gIdx);

}
