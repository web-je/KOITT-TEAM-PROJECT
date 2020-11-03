package koitt.ratta.doeat.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import koitt.ratta.doeat.domain.AccountEntity;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@WebAppConfiguration
@Slf4j
public class AccountServiceTest {

	@Autowired
	AccountService accountService;

	// 필드 // 원래 비포에서 챙겨줌.
	String userId;
	AccountEntity accountEntity;

	@Test public void findByuserIdTest() throws Exception { 
		userId ="id@naver.com"; 
		assertNotNull(accountService.findByuserId(userId));
	 // assertNull(accountService.findByuserId(userId)); 
	  //<AccountEntity(uIdx=1,userId=id@naver.com, name=홍길동, nickname=null, regdate=null, ip=null,social=0, phone=null, birth=null, address=null)> 
	  }
	  

	@Test
	public void findByuserIdTestNull() {
		userId = "id@naver.com";
		try {
			accountEntity = accountService.findByuserId(userId);
		} catch (Exception e) {
			log.error("~~~~ 어카운트엔티티 에러");
			e.printStackTrace();
		}
	}
}
