package koitt.ratta.doeat.domain;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 계정 repository, JPA 사용.
 * 
 * @author GW
 *
 */
@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, BigDecimal> {

	/**
	 * 유저 이메일 아이디로 유저 정보 가져오기
	 * @param id 유저의 이메일 아이디
	 * @return 해당 계정 엔티티(회원 정보 모두)
	 */
	public AccountEntity findByUserId(String id);
	
//	public AccountEntity findByUIdx(Long uIdx);
//	public AccountEntity findByPhone(String phone);
}
