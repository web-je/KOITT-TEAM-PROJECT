package koitt.ratta.doeat.domain;

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

	int g_idx;
	int r_idx;
	int u_idx;
	String content;
	String img_uuid;

}