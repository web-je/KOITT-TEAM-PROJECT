package koitt.ratta.doeat.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import koitt.ratta.doeat.domain.AccountDto;
import koitt.ratta.doeat.domain.AccountEntity;
import koitt.ratta.doeat.domain.AccountRepository;
import koitt.ratta.doeat.domain.CustomUser;
import koitt.ratta.doeat.domain.Role;
import koitt.ratta.doeat.domain.RoleRepository;
import koitt.ratta.doeat.domain.Users;
import koitt.ratta.doeat.domain.UsersRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountServiceImpl implements  AccountService{
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;


	private Role role = new Role();
	private Users users = new Users();
	
	//회원가입 서비스
	@Transactional
	@Override
	public void saveUser(AccountDto dto) throws Exception {
		
		AccountEntity entity= new AccountEntity();
		entity.accountEntityFromDto(dto);
		
		log.info(" ~~~~~~~  서비스 saveUser 엔티티 : " + entity.toString());
		
		accountRepository.save(entity);
		
		log.info(" ~~~~~~~  로그인 서비스 dto : " + dto);
		users = new Users();
		users.setPassword(passwordEncoder.encode(dto.getUserPw()));
		users.setEnable(1);
		users.setUsername(dto.getUserId());
		usersRepository.save(users);
		
		Role role = new Role();
		role.setRole("ROLE_USER");
		role.setUsername(dto.getUserId());
		roleRepository.save(role);
		
		log.info("계정 서비스 saveUser 의 role : "+ role);
	}
	
	//username(=userId)로 유저 인포 찾기
	@Override
	public AccountEntity findByuserId(String userId) throws Exception{
		AccountEntity userInfo = accountRepository.findAllByUserId(userId);
		return userInfo;
	}

}
