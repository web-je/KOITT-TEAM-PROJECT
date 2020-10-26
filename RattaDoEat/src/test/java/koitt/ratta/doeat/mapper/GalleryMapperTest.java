package koitt.ratta.doeat.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import koitt.ratta.doeat.domain.GalleryVo;

@SpringBootTest
public class GalleryMapperTest {
	
	@Autowired
	GalleryMapper mapper;
	GalleryVo testVo;
	
	@BeforeEach
	public void setUp() {
		testVo = GalleryVo.builder().content("test content").build();
	}
	
	@Test
	public void viewAllTest() {
		assertThat(mapper.viewAll().contains(testVo));
	}
	
}
