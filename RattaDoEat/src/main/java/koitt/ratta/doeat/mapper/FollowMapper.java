package koitt.ratta.doeat.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import koitt.ratta.doeat.domain.FollowVo;

@Mapper
public interface FollowMapper {
	
	@Select("SELECT COUNT(ROWNUM)"
			+ " FROM follow"
			+ " WHERE from_u_idx = #{fromUIdx} AND to_u_idx = #{toUIdx}")
	public Integer isFollow(FollowVo followVo);
	
	@Insert("INSERT INTO follow"
			+ " VALUES(f_idx_seq.NEXTVAL, #{fromUIdx}, #{toUIdx})")
	public int addFollow(FollowVo followVo);
	
	@Delete("DELETE follow"
			+ " WHERE FROM_U_IDX=#{fromUIdx} AND TO_U_IDX=#{toUIdx}")
	public int unFollow(FollowVo followVo);
	
}
