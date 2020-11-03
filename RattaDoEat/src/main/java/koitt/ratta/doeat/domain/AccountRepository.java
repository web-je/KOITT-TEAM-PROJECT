/**
 * 작성자 GW
 */
package koitt.ratta.doeat.domain;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, BigDecimal> {
//	public AccountEntity findByUIdx(Long uIdx);
	/**
	 * 유저 이메일 아이디로 유저 정보 가져오기
	 * @param id
	 */
	public AccountEntity findByUserId(String id);
//	public AccountEntity findByPhone(String phone);
}
