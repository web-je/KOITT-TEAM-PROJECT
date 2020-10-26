package koitt.ratta.doeat.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import koitt.ratta.doeat.domain.GalleryVo;

@SpringBootTest
public class ScrapMapperTest {
	
	@Autowired
	ScrapMapper mapper;
	GalleryVo testVo;
	
	@Test
	public void addScrapTest() {
		assertThat(mapper.addScrap(1))
		// 결과가 1이면 업데이트 성공
		.isEqualTo(1);
	}
	
	@Test
	public void viewScrapTest() {
		assertThat(mapper.viewScrap(2)).isEqualTo(0);
	}
	
}
