package koitt.ratta.doeat.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ScrapMapper {
	
	@Update("UPDATE com_gallery"
			+ " SET SCRAP_NUM = SCRAP_NUM+1"
			+ " WHERE G_IDX = #{gIdx}")
	public int addScrap(int gIdx);
	
	@Select("SELECT SCRAP_NUM"
			+ " FROM com_gallery"
			+ " WHERE G_IDX = #{gIdx}")
	public int viewScrap(int gIdx);

}
