package koitt.ratta.doeat.domain;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, BigDecimal> {
//	public AccountEntity findByUIdx(Long uIdx);
	public AccountEntity findByUserId(String id);
//	public AccountEntity findByPhone(String phone);
}
