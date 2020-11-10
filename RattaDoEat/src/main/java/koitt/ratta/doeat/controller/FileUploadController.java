package koitt.ratta.doeat.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import koitt.ratta.doeat.domain.FileVo;
import koitt.ratta.doeat.domain.GalleryVo;
import koitt.ratta.doeat.service.FileUploadService;
import koitt.ratta.doeat.service.GalleryService;
/**
 * @author JeongEun
 * @since 2020-10-25
 */
@Controller
public class FileUploadController {

	@Autowired
	public GalleryService galleryService;

	@Autowired
	public FileUploadService fileUploadService;
	
	/**
	 * gallery 게시판 업로드 처리
	 * 
	 * @param HashMap<Object, Object>
	 * @param MultipartHttpServletRequest
	 * @return
	 */
	@ResponseBody
	@PostMapping("/uploadP")
	public String uploadP(@RequestParam HashMap<Object, Object> param, MultipartHttpServletRequest mtfRequest) {
		GalleryVo galleryVo = new GalleryVo();
		FileVo file = new FileVo();
		
		List<MultipartFile> multipartFileList = new ArrayList<>();
		String originFileName = ""; // 파일 이름
		String fileNameExtension; // 파일 확장자 
		String uuidFileName; // 파일 uuid
//		String path = "C:\\Users\\koitt04a\\Downloads\\RattaDoEat\\src\\main\\resources\\upload\\";
		String path = "C:\\workSpace\\RattaDoEat\\src\\main\\resources\\static\\upload\\";
		String saveFile; // 경로 + 암호화된 파일 이름
		
		try {
			galleryVo.setType1(param.get("type1").toString()); // GalleryVo에 type1값 저장
			galleryVo.setType2(param.get("type2").toString()); // GalleryVo에 type2값 저장
			galleryVo.setContent(param.get("content").toString()); // GalleryVo에 content값 저장
			galleryVo.setTag(param.get("keywordList").toString()); // GalleryVo에 tag값 저장
			galleryService.insertG(galleryVo); // content DB에 저장
			MultiValueMap<String, MultipartFile> files = mtfRequest.getMultiFileMap(); //file값 Map으로 받기
			for (Map.Entry<String, List<MultipartFile>> entry : files.entrySet()) { // 메소드 entrySet은 Map의 데이터를 담고 있는 Set을 반환한다. 반환한 Set의 값이 사용할 데이터 탑입은 Map.Entry이다.
				List<MultipartFile> fileList = entry.getValue(); // Map.Entry는 인터페이스로 getKey, getValue API를 지원한다.
				for (MultipartFile mf : fileList) {
					if (mf.isEmpty()) continue;
					multipartFileList.add(mf); // multipartFileList에 fileList값 담기
                }
			}
			if(multipartFileList.size() > 0) {
				for(MultipartFile mf : multipartFileList) {
					originFileName = mf.getOriginalFilename(); // 파일 original명 추출
					fileNameExtension = FilenameUtils.getExtension(originFileName).toLowerCase(); // 파일 확장자 추출
					uuidFileName = UUID.randomUUID().toString(); // 파일명 uuid로 변환
					saveFile = path + uuidFileName + "." + fileNameExtension; // 저장할 파일

					try {
						mf.transferTo(new File(saveFile)); // 업로드 폴더로 파일 전송
						file.setImgUuid(uuidFileName + "." + fileNameExtension); // FileVo에 값 저장
						file.setImgOri(originFileName);
						file.setImgUrl(path);
						fileUploadService.insertP(file); // file db에 저장
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "success";
	}
}
