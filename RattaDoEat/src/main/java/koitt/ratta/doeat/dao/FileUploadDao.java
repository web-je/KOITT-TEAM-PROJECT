package koitt.ratta.doeat.dao;

import java.util.List;

import koitt.ratta.doeat.domain.FileVo;

public interface FileUploadDao {
	
	//파일 업로드 메서드 추가
	public int insertP(FileVo file);
	
	// 사진 조회
	public List<FileVo> viewPhoto(int gIdx);

}
