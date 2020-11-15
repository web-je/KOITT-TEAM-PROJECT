package koitt.ratta.doeat.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 
 * 갤러리 게시판 리스트를 위한 vo
 * @author 진민영
 * @since 
 * 
 */
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
	String nickname;
	String name;
	
	// 갤러리 첨부파일 테이블에서 조인한 것을 파일단위로 저장
	String imgUuid;
	String imgUuid2;
	String imgUuid3;
	String imgUuid4;
	String imgUuid5;
	
	// 라이크 테이블 집계하여 조인
	int likeCnt;
	
	// 스크랩 테이블 집계하여 조인 
	int scrapCnt;
	
	// 이하의 필드는 테이블에 포함된 데이터가 아닙니다 (조인 아님)
	// 좋아요 여부 유저정보로 조회한 정보 삽입
	Boolean isLike;
	
	// 팔로우 테이블 유저정보로 조회한 정보 삽입
	Boolean isFollow;
	
	@Builder
	public GalleryListVo(int gIdx, int uIdx, String content, LocalDateTime regDate, LocalDateTime modifyDate, int hit, String type1, String type2, String nickname, String name, String imgUuid, String imgUuid2, String imgUuid3, String imgUuid4, String imgUuid5, int likeCnt, int scarpCnt, Boolean isLike, Boolean isFollow) {
		this.gIdx = gIdx;
		this.uIdx = uIdx;
		this.content = content;
		this.regDate = regDate;
		this.modifyDate = modifyDate;
		this.hit = hit;
		this.type1 = type1;
		this.type2 = type2;
		this.nickname = nickname;
		this.name = name;
		this.imgUuid = imgUuid;
		this.imgUuid2 = imgUuid2;
		this.imgUuid3 = imgUuid3;
		this.imgUuid4 = imgUuid4;
		this.imgUuid5 = imgUuid5;
		this.likeCnt = likeCnt;
		this.scrapCnt = scarpCnt;
		this.isLike = isLike;
		this.isFollow = isFollow;
	}
	
}
