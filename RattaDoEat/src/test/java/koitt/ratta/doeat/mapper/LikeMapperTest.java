package koitt.ratta.doeat.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import koitt.ratta.doeat.domain.GalleryLikeVo;

@SpringBootTest
public class LikeMapperTest {
	
	@Autowired
	LikeMapper mapper;
	GalleryLikeVo vo;
	
	@BeforeEach
	public void setUp() {
		vo = GalleryLikeVo.builder().gLIdx(9999999)
									.uIdx(1)
									.gIdx(1)
									.build();
	}
	
	@Test
	@Rollback(true)
	public void addLikeTest() {
		assertThat(mapper.addLike(vo))
		// 결과가 1이면 인서트 성공
		.isEqualTo(1);
	}
	
}
