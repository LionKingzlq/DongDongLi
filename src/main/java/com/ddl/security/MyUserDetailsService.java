package com.ddl.security;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.ddl.model.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.ddl.dao.AdminDao;

public class MyUserDetailsService implements UserDetailsService {

	@Resource(name="adminDao")
    private AdminDao adminDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		List<Admin> admins = this.adminDao.getAuthorityName(username);
		if(admins == null || admins.size() == 0){
			return null;
		}

		Admin admin = admins.get(0);
		String roles = admin.getRole();

		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(roles);
		auths.add(authority);

		return new User(username,admin.getPassWord(),true,true,true,true,auths);
	}
}