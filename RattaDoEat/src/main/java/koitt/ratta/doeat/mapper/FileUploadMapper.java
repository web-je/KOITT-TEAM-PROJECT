package koitt.ratta.doeat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import koitt.ratta.doeat.domain.FileVo;

@Mapper
public interface FileUploadMapper {

	// 파일 업로드
	@SelectKey(statement = "SELECT MAX(g_idx) FROM COM_GALLERY", keyProperty = "gIdx", before = true, resultType = int.class)
	@Insert("INSERT INTO GALLERY_PHOTO(p_idx, g_idx, img_uuid, img_ori, img_url) VALUES(p_idx_seq.NEXTVAL, #{gIdx}, #{imgUuid}, #{imgOri}, #{imgUrl})")
	FileVo write(FileVo fileVo);
	
	// 사진 조회
	@Select("SELECT * FROM GALLERY_PHOTO WHERE G_IDX = #{gIdx}")
	List<FileVo> viewPhoto(); 
}
