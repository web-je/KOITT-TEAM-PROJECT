package koitt.ratta.doeat.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user_roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name="user_role_seq", sequenceName = "USER_ROLES_SEQ", initialValue = 1, allocationSize = 1)
public class Role implements GrantedAuthority{

	private static final long serialVersionUID = -7504679258252967630L;

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO) // 오토, 하이버네이트로 알아서 만듬.  spring.jpa.hibernate.ddl-auto=update 있어야함. hidernate-sequence는 jap/hibernate의 기본시퀀스이다. 이던 auto 자동생성으로 해줘야함.
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "user_role_seq")
	@Column(name="user_role_id")
	private Long id;
	@Column
	private String username;
	@Column
	private String role;
	
	@Override
	public String getAuthority() {
		return this.role;
	}
	
}
