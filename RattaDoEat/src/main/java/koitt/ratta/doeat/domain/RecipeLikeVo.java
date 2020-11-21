package koitt.ratta.doeat.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RecipeLikeVo {
	
	int rLIdx;
	int uIdx;
	int lIdx;
	
	@Builder
	public RecipeLikeVo(int rLIdx, int uIdx, int lIdx) {
		this.rLIdx = rLIdx;
		this.uIdx = uIdx;
		this.lIdx = lIdx;
	}

}
