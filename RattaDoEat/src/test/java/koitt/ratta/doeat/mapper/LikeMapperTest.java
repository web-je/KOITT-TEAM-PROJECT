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
		// 외래키 제약조건 무시할 방법을 찾지 못해 부득이하게 유저 인덱스 1번을 씀
		vo = GalleryLikeVo.builder().uIdx(1)
									.gIdx(9999999)
									.build();
	}
	
	@Test
	@Rollback(true)
	public void addLikeTest() {
		// 결과가 1이면 인서트 성공
		assertThat(mapper.addLike(vo))
		.isEqualTo(1);
	}
	
	@Test
	@Rollback(true)
	public void isLikeTest() {
		// 존재하지 않는 데이터 조회
		// 결과가 null이면 데이터 없음으로 조회 성공
		assertThat(mapper.isLike(vo)).isEqualTo(null);
		
		// 존재하는 데이터 조회
		// 결과가 0 보다 크면 데이터 없음으로 조회 성공
		mapper.addLike(vo);
		assertThat(mapper.isLike(vo)).isGreaterThan(0);
	}
	
	@Test
	@Rollback(true)
	public void viewLikeTest() {
		assertThat(mapper.addLike(vo))
		// 결과가 1이면 인서트 성공
		.isEqualTo(1);
	}
	
}
