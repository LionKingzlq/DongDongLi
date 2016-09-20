package com.ddl.security;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.abraham.dj.dao.UserDao;

public class MyUserDetailsService implements UserDetailsService {

	@Resource(name="userDao")
    private UserDao userDao;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	      List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
	      List<String> authorityName = this.userDao.getAuthorityName(username);
	      for(String roleName : authorityName) {
	          SimpleGrantedAuthority authority = new SimpleGrantedAuthority(roleName);
	          auths.add(authority);
	      }
	      String pwd = this.userDao.get(username).getPassWord();
	      return new User(username,pwd,true,true,true,true,auths);
	}
}