package koitt.ratta.doeat.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import koitt.ratta.doeat.domain.GalleryVo;

@SpringBootTest
public class FilterMapperTest {
	
	@Autowired
	FilterMapper mapper;
	GalleryVo testVo;
	
	@Test
	public void sortBy() {
		List<GalleryVo> list = mapper.addFilter("한식");
		
		for(GalleryVo post : list) {
			assertEquals(post.getType1(), "한식");
		}
		
	}
	
	

}
