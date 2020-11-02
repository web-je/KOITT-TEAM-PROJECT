package koitt.ratta.doeat.domain;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	
	
	//엔티티를 dto로 변환하는 빌더.
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
