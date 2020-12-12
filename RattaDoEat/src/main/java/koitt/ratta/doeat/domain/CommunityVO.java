package koitt.ratta.doeat.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * 
 * 게시판 통합 조회용 VO
 * @author 진민영
 *
 */
@Getter
@ToString
public class CommunityVO {

	int gIdx;
	int rIdx;
	int uIdx;
	String imgPath;
	
	@Builder
	public CommunityVO(int gIdx, int rIdx, int uIdx, String imgPath) {
		this.gIdx = gIdx;
		this.rIdx = rIdx;
		this.uIdx = uIdx;
		this.imgPath = imgPath;
	}

}