package koitt.ratta.doeat.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GalleryScrapVo {
	
	int gSIdx;
	int uIdx;
	int gIdx;
	
	@Builder
	public GalleryScrapVo(int gSIdx, int uIdx, int gIdx) {
		this.gSIdx = gSIdx;
		this.uIdx = uIdx;
		this.gIdx = gIdx;
	}

}
