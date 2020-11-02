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
//public class AccountServiceImpl implements UserDetailsService, AccountService{ //유저디테일 여기에 구현한 이유: 로그인권한체크(시큐리티 자체;
public class AccountServiceImpl implements  AccountService{ //유저디테일 여기에 구현한 이유: 로그인권한체크(시큐리티 자체;
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	//private CustomUser customUser;
	//private Users users; //이건 빈등록된 개체가 아님 엔티티라 오토와이어드XX, 텅빈껍데기임 사용하면 new로 초기화시켜주고사용. 무의미한 코드입니다.
	
	private Role role = new Role();
	private Users users = new Users();
	
	
	//secutiry에서 사용하는 User Class정보를 내가 Custom한user에 매핑해서 권한체크. 
	/*
	 * @Transactional
	 * 
	 * @Override public UserDetails loadUserByUsername(String username) throws
	 * UsernameNotFoundException {
	 * 
	 * Role role = roleRepository.findByUsername(username); users =
	 * usersRepository.findByUsername(username); //List<GrantedAuthority>
	 * authorities = new ArrayList<>(); //인증된권한 타입의 관계자 생성. List<Role> authorities =
	 * new ArrayList<>(); //인증된권한 타입의 관계자 생성. //authorities.add(new
	 * SimpleGrantedAuthority(role.getRole())); //간단한인증된권한에 role_user를추가해서 인증권한에 넣음.
	 * 
	 * users.getPassword(); //users에 변환된 비번 users.getUsername(); users.getEnable();
	 * CustomUser customUser =new CustomUser(users);
	 * //customUser.setAuthorities(authorities);
	 * customUser.setAuthorities(authorities); return customUser; }
	 */
	
	/* 프로바이더
	//로그인 
	public void selectUserLogin(AccountDto dto, HttpSession session) throws Exception {
		UserDetails user = loadUserByUsername(dto.getUserId());
		
		AccountEntity userInfo = accountRepository.findByUserId(dto.getUserId());
		session.setAttribute("userInfo", userInfo); //세션에 띄워서 로그인한 동안 유저정보 사용할 수 있게.
		//세션으로 띄우는거 대신 서큐티리의 prinsiple로 로그인된 사용자의 정보를 가져오는걸로 
	}
	*/
	/************************  위는 유저디테일  *************************/
	
	
	//회원가입 서비스
	@Transactional
	@Override
	public void saveUser(AccountDto dto) throws Exception {
		
		//유저인포저장
		AccountEntity entity= new AccountEntity();
		entity.accountEntityFromDto(dto);
		
		log.info(" ~~~~~~~  서비스 saveUser 엔티티 : " + entity.toString());
		
		//new CustomUser(users); 유저가 롤을 참조하기때문에 먼저 유저를 생성해야한다. 참조무결성!!!!!
		accountRepository.save(entity);
		
		//users 저장 
		log.info(" ~~~~~~~  로그인 서비스 dto : " + dto);
		users = new Users();
		users.setPassword(passwordEncoder.encode(dto.getUserPw()));
		users.setEnable(1);
		users.setUsername(dto.getUserId());
		usersRepository.save(users);
		
		//role 저장 롤테이블의 username은 users의 username을 참조합니다. 자식테이블의 데이터가 마지막에 들어옵니다.
		Role role = new Role();
		role.setRole("ROLE_USER");
		role.setUsername(dto.getUserId());
		roleRepository.save(role);
		
		log.info("계정 서비스 saveUser 의 role : "+ role);
	}

}
