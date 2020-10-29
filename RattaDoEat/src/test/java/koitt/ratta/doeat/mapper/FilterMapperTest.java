package koitt.ratta.doeat.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import koitt.ratta.doeat.domain.GalleryListVo;

@SpringBootTest
public class FilterMapperTest {
	
	@Autowired
	FilterMapper mapper;
	GalleryListVo testVo;
	
	@Test
	public void sortBy() {
		List<GalleryListVo> list = mapper.addFilter("TYPE1 LIKE '%한식%'");

		for(GalleryListVo post : list) {
			assertEquals(post.getType1(), "한식");
		}
		
	}
	
	

}
