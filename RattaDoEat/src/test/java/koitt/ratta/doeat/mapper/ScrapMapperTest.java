package koitt.ratta.doeat.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import koitt.ratta.doeat.domain.GalleryScrapVo;

@SpringBootTest
public class ScrapMapperTest {
	
	@Autowired
	ScrapMapper mapper;
	GalleryScrapVo vo;
	
	@BeforeEach
	public void setUp() {
		vo = GalleryScrapVo.builder().gSIdx(9999999)
									.uIdx(1)
									.gIdx(1)
									.build();
	}
	
	@Test
	@Rollback(true)
	public void addScrapTest() {
		assertThat(mapper.addScrap(vo))
		// 결과가 1이면 인서트 성공
		.isEqualTo(1);
	}
	
	
}
