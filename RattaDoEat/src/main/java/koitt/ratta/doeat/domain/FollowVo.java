package koitt.ratta.doeat.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FollowVo {
	
	int fIdx;
	int fromUIdx;
	int toUIdx;
	
	@Builder
	public FollowVo(int fIdx, int fromUIdx, int toUIdx) {
		this.fIdx = fIdx;
		this.fromUIdx = fromUIdx;
		this.toUIdx = toUIdx;
	}

}
