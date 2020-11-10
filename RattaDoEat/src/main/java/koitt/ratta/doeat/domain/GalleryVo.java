package koitt.ratta.doeat.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GalleryVo {

	int gIdx, uIdx, hit;
	String content, type1, type2, tag;
	LocalDateTime regDate, modifyDate;
	
	@Builder
	public GalleryVo(int gIdx, int uIdx, int hit,
			String content, String type1, String type2, String tag,
			LocalDateTime regDate, LocalDateTime modifyDate) {
		this.gIdx = gIdx;
		this.uIdx = uIdx;
		this.hit = hit;
		this.content = content;
		this.type1 = type1;
		this.type2 = type2;
		this.tag = tag;
		this.regDate = regDate;
		this.modifyDate = modifyDate;
	}
	
}
