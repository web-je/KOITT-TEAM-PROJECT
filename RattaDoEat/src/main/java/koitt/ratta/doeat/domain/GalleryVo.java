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
	String type1;
	String type2;
	
	@Builder
	public GalleryVo(int gIdx, int uIdx, String content, LocalDateTime regDate, LocalDateTime modifyDate, int hit,
			String type1, String type2) {
		this.gIdx = gIdx;
		this.uIdx = uIdx;
		this.content = content;
		this.regDate = regDate;
		this.modifyDate = modifyDate;
		this.hit = hit;
		this.type1 = type1;
		this.type2 = type2;
	}
	
}
