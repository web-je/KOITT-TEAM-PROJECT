package koitt.ratta.doeat.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import koitt.ratta.doeat.domain.GalleryVo;

@SpringBootTest
public class SortMapperTest {
	
	@Autowired
	SortMapper mapper;
	GalleryVo testVo;
	
	@Test
	public void sortBy() {
		List<GalleryVo> list = mapper.sortBy("like_num");
		GalleryVo greaterValue = list.get(0);
		
		for(GalleryVo post : list) {
			if (post.getLikeNum() > greaterValue.getLikeNum()) {
				greaterValue = post;
			}
		}
		
		assertEquals(greaterValue, list.get(0));
	}
	
	

}
