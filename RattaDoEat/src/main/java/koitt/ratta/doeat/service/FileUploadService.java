package koitt.ratta.doeat.service;

import java.util.List;

import koitt.ratta.doeat.domain.FileVo;

public interface FileUploadService {

	//파일 업로드 메서드 추가
	public int insertP(FileVo file);
	
	// 사진 조회
	public List<FileVo> viewPhoto(int gIdx);
}
