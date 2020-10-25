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
	public void viewAllTest() {
		assertThat(galleryMapper.viewAll()
								.get(0)
								.getContent()).isEqualTo("content1");
	}
	
	@Test
	public void addLikeTest() {
		assertThat(galleryMapper.addLike(1))
		// 결과가 1이면 업데이트 성공
		.isEqualTo(1);
	}
	
	@Test
	public void viewLikeTest() {
		assertThat(galleryMapper.viewLike(2)).isEqualTo(0);
	}

}
