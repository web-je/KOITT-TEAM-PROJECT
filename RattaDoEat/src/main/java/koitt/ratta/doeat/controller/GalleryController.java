package koitt.ratta.doeat.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import koitt.ratta.doeat.domain.FileVo;
import koitt.ratta.doeat.domain.GalleryVo;
import koitt.ratta.doeat.service.GalleryService;

@Controller
public class GalleryController {
	
	@Autowired
	GalleryService galleryService;
	
	// 갤러리 목록
	@GetMapping("/")
	public String viewAllGallery(Model model) throws Exception {
		model.addAttribute("gallery", galleryService.viewAll());
		return "gallery";
	}
	
	// 게시물 작성
	@GetMapping("g_insert")
	public String insertG() {
	  return "gallery/insert";
	}
	
	@PostMapping("g_insert")
	public String insertP(@ModelAttribute GalleryVo vo, @RequestPart MultipartFile files, HttpServletRequest request) throws IllegalStateException, IOException {
		if(files.isEmpty()) {
	    	galleryService.insertG(vo);
	    } else {
	    	String fileName = files.getOriginalFilename(); // 사용자 컴에 저장된 파일명 그대로
	        String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase(); //확장자
	        File destinationFile; // DB에 저장할 파일 고유명
	        String destinationFileName;
	        String fileUrl = "C:\\Users\\koitt04a\\Downloads\\study-ratta\\RattaDoEat\\src\\main\\resources\\upload\\"; //업로드한 파일이 저장되는 저장소(절대 경로)
		
			do { //우선 실행 후
				//고유명 생성
				destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension;
				destinationFile = new File(fileUrl + destinationFileName); //합쳐주기
			} while (destinationFile.exists()); 
	
			destinationFile.getParentFile().mkdirs(); //디렉토리
			files.transferTo(destinationFile);
	
			galleryService.insertG(vo);
	
			FileVo file = new FileVo();
			file.setGIdx(vo.getGIdx());
			file.setImg(destinationFileName);
			file.setImg_ori(fileName);
			file.setImg_url(fileUrl);
			      
			galleryService.insertP(file);
			}
		    
		return "gallery";
	}
	
	
	
}
