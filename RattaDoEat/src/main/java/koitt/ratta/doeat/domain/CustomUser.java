package koitt.ratta.doeat.domain;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 커스텀유저 모델 클래스. 
 * UserDetails를 구현하며 시큐리티에 사용됩니다.
 * 
 * @author GW
 *
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomUser implements UserDetails {

	private static final long serialVersionUID = 1L;

	
	private String username;
	private String password;
	
	//Security 관련된 필드
	//private List<Role> authorities;
	private List<Role> authorities;
	//private List<GrantedAuthority> authorities;
	private boolean accountNonExpired = true; //계정만료되지 않음
	private boolean accountNonLocked = true; //잠겨지지 않음.
	private boolean credentialsNonExpired = true; //인증서 만료되지 않음.
	private boolean enabled = true;
	
	public CustomUser(Users users) { 
		this.username = users.getUsername();
		this.password = users.getPassword();
		this.enabled = users.getEnable()==1? true : false;
	}
	
}
