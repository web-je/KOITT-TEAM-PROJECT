package koitt.ratta.doeat.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GalleryVo {

	int gIdx, uIdx, hit, likeNum, scrapNum;
	String content;
	LocalDateTime regDate, modifyDate;
	
	@Builder
	public GalleryVo(int gIdx, int uIdx, int hit, int likeNum, int scrapNum, String content, LocalDateTime regDate,
			LocalDateTime modifyDate) {
		this.gIdx = gIdx;
		this.uIdx = uIdx;
		this.hit = hit;
		this.likeNum = likeNum;
		this.scrapNum = scrapNum;
		this.content = content;
		this.regDate = regDate;
		this.modifyDate = modifyDate;
	}
	
	
	
}
