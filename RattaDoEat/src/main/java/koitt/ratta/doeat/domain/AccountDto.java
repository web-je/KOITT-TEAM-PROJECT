package koitt.ratta.doeat.domain;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 회원 정보 DTO
 * 회원 가입할 때, 회원 정보 변경 시에 사용.
 * 
 * @author GW
 *
 */
@NoArgsConstructor
@Data
public class AccountDto {

	private BigDecimal uIdx;

	private String userId;
	private String userPw;
	
	private String name;
	
	private String nickname;
	
	private Date regdate;
	
	private String ip;
	
	private int social;
	
	private String phone;
	
	private Date birth;
	
	private String address;
	
	
	//엔티티를 dto로 변환
	@Builder
	public AccountDto(AccountEntity entity) {
		this.uIdx = entity.getUIdx();
		this.userId = entity.getUserId();
		this.name = entity.getName();
		this.nickname = entity.getNickname();
		this.regdate = entity.getRegdate();
		this.ip = entity.getIp();
		this.social = entity.getSocial();
		this.phone = entity.getPhone();
		this.birth = entity.getBirth();
		this.address = entity.getAddress();
	}
	
	
	
}
