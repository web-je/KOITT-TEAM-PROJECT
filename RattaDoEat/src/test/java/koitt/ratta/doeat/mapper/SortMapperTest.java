package koitt.ratta.doeat.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import koitt.ratta.doeat.domain.GalleryListVo;

@SpringBootTest
public class SortMapperTest {
	
	@Autowired
	SortMapper mapper;
	GalleryListVo testVo;
	
	@BeforeEach
	public void setUp() {
		testVo = GalleryListVo.builder().likeCnt(9999999).build();
	}
	
	@Test
	public void sortBy() {
		List<GalleryListVo> list = mapper.sortBy("like_cnt");
		int index = list.size();
		list.add(index, testVo);
		GalleryListVo greaterValue = list.get(index);
		
		for(GalleryListVo post : list) {
			if (post.getLikeCnt() > greaterValue.getLikeCnt()) {
				greaterValue = post;
			}
		}
		
		assertEquals(greaterValue, list.get(index));
	}
	
	

}
