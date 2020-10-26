package koitt.ratta.doeat.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FileVo {
	int pIdx, gIdx;
	String alt, img, img_ori, img_url;
}
