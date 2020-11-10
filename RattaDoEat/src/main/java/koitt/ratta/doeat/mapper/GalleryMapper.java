package koitt.ratta.doeat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import koitt.ratta.doeat.domain.GalleryListVo;
import koitt.ratta.doeat.domain.GalleryVo;

@Mapper
public interface GalleryMapper {
	
	// 갤러리 테이블 전체 조회
	@Select("SELECT *"
			+ " FROM gallery_list")
	public List<GalleryListVo> viewAll();
	
	@Select("SELECT *"
			+ " FROM gallery_list"
			+ " WHERE u_idx = #{uIdx}")
	public List<GalleryListVo> viewAllByUser(int uIdx);
	
	// 게시물 작성
	@Insert("INSERT INTO COM_GALLERY (g_idx, u_idx, content, reg_date, modify_date, hit, type1, type2, tag) VALUES (g_idx_seq.NEXTVAL, 1, #{content}, SYSDATE, SYSDATE, 0, #{type1}, #{type2}, #{tag})")
	GalleryVo insertG(GalleryVo galleryVo);
	
	// 게시물 상세보기
	@Select("SELECT * FROM COM_GALLERY WHERE G_IDX = #{gIdx}")
	List<GalleryVo> viewDetail();
	
//	// 유저 이름 조회
//	@Select("SELECT TMPUSER.U_NAME as uName FROM TMPUSER LEFT JOIN COM_GALLERY ON TMPUSER.U_IDX = COM_GALLERY.U_IDX WHERE COM_GALLERY.G_IDX = #{gIdx}")
//	public String userName(int gIdx);
}
