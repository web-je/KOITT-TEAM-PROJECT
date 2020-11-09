package koitt.ratta.doeat.domain;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ContentVO {

	String content;
	int rIdx, uIdx, hit, likeNum, scrapNum;
	Date regDate, modifyDate;
	
}
