package koitt.ratta.doeat.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GalleryMapperTest {
	
	@Autowired
	GalleryMapper galleryMapper;
	
	@Test
	public void viewAllTest() throws Exception {
		assertThat(galleryMapper.viewAll()
								.get(0)
								.getContent()).isEqualTo("content");
	}

}
