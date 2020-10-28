package koitt.ratta.doeat.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import koitt.ratta.doeat.domain.GalleryVo;

@SpringBootTest
public class LikeMapperTest {
	
	@Autowired
	LikeMapper mapper;
	GalleryVo testVo;
	
	@Test
	@Rollback(true)
	public void addLikeTest() {
		assertThat(mapper.addLike(1))
		// 결과가 1이면 업데이트 성공
		.isEqualTo(1);
	}
	
	@Test
	public void viewLikeTest() {
//		assertThat(mapper.viewLike(2)).isEqualTo(0);
	}
	
}
