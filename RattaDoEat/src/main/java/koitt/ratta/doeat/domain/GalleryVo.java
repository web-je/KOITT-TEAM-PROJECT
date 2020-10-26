package koitt.ratta.doeat.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GalleryVo {

	int gIdx;
	int uIdx;
	String content;
	LocalDateTime regDate;
	LocalDateTime modifyDate;
	int hit;
	int likeNum;
	int scrapNum;
	
	@Builder
	public GalleryVo(int gIdx, int uIdx, String content, LocalDateTime regDate, LocalDateTime modifyDate, int hit,
			int likeNum, int scrapNum) {
		this.gIdx = gIdx;
		this.uIdx = uIdx;
		this.content = content;
		this.regDate = regDate;
		this.modifyDate = modifyDate;
		this.hit = hit;
		this.likeNum = likeNum;
		this.scrapNum = scrapNum;
	}
	
}
