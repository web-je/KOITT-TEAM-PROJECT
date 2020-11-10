package koitt.ratta.doeat.service;

import org.springframework.stereotype.Service;

import koitt.ratta.doeat.domain.AccountDto;
import koitt.ratta.doeat.domain.AccountEntity;

/**
 * 회원 계정 서비스 인터페이스.
 * 
 * @author GW
 */
@Service
public interface AccountService {

	/**
	 * 회원가입, 유저 저장
	 * @param 계정dto 
	 */
	public void saveUser(AccountDto user) throws Exception;

	/**
	 * 유저 이메일 아이디로 엔티티 불러오기.
	 * @param 유저의 이메일 아이디
	 * @return 유저 엔티티
	 */
	public AccountEntity findByUserIdService(String userId) throws Exception;

}
