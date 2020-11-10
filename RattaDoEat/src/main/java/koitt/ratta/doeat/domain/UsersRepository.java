package koitt.ratta.doeat.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Users Repository 입니다. JPA 사용.
 * 
 * @author GW
 *
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, String>{

	/**
	 * 유저의 이메일 아이디로 Users모델을 찾습니다. 실제 시큐리티에서 사용되는 회원데이터입니다.
	 * @param username 유저의 이메일 아이디
	 * @return Users 모델.
	 */
	public Users findByUsername(String username);

}
