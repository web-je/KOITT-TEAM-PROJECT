package koitt.ratta.doeat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koitt.ratta.doeat.dao.FileUploadDao;
import koitt.ratta.doeat.domain.FileVo;
/**
 * @author JeongEun
 * @since 2020-10-25
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

	@Autowired
	FileUploadDao fileUploadDao;

	@Override
	public int insertP(FileVo file) {
		return fileUploadDao.insertP(file);
	}

	@Override
	public List<FileVo> viewPhoto(int gIdx) {
		return fileUploadDao.viewPhoto(gIdx);
	}
}
