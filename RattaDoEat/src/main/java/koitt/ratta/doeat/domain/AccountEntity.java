package koitt.ratta.doeat.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sun.tools.classfile.Opcode.Set;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Entity
@Table(name="user_info")
public class AccountEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="u_idx")
	private Long id;
	
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
	
	
	//private java.util.Set<Role> roles;
}
