package com.example.demo.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import com.example.demo.entity.TUser;
import com.example.demo.repository.TUserRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	private TUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
		TUser user = userRepository.getById(userId);
	
		if(user != null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

			authorities.add(new SimpleGrantedAuthority(user.getRole()));
			
			boolean isEnabled = StringUtils.equals(user.getStatus(),"1") ? true : false;
			
			return new User(user.getUserId(),new BCryptPasswordEncoder().encode(user.getUserPwd()), isEnabled, true, true, true, authorities);
		}
		
		throw new UsernameNotFoundException("認證錯誤");

	}

}
