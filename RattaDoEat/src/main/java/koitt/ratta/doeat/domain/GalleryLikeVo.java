package koitt.ratta.doeat.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GalleryLikeVo {
	
	int gLIdx;
	int uIdx;
	int gIdx;
	
	@Builder
	public GalleryLikeVo(int gLIdx, int uIdx, int gIdx) {
		this.gLIdx = gLIdx;
		this.uIdx = uIdx;
		this.gIdx = gIdx;
	}

}
