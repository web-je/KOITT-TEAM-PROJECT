package koitt.ratta.doeat.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GalleryListVo {
	
	// gallery 테이블 기준으로 left outer join
	int gIdx;
	int uIdx;
	String content;
	LocalDateTime regDate;
	LocalDateTime modifyDate;
	int hit;
	String type1;
	String type2;
	
	// 유저 테이블에서 조인
	
	// 라이크 테이블 집계하여 조인
	int likeCnt;
	
	// 스크랩 테이블 집계하여 조인 
	int scrapCnt;
	
	// 팔로우 테이블 유저정보로 조회한 정보 삽입
	// 조인 아님!
	Boolean isFollow;
	
	@Builder
	public GalleryListVo(int gIdx, int uIdx, String content, LocalDateTime regDate, LocalDateTime modifyDate, int hit,
			String type1, String type2, int likeCnt, int scarpCnt, Boolean isFollow) {
		this.gIdx = gIdx;
		this.uIdx = uIdx;
		this.content = content;
		this.regDate = regDate;
		this.modifyDate = modifyDate;
		this.hit = hit;
		this.type1 = type1;
		this.type2 = type2;
		this.likeCnt = likeCnt;
		this.scrapCnt = scarpCnt;
		this.isFollow = isFollow;
	}
	
}
