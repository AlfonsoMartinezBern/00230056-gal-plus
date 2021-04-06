package com.telefonica.gal.handler;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceWSSE implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails ud = new UserDetails() {
			
			@Override
			public boolean isEnabled() {
				System.out.println("IsEnabled");
				return true;
			}
			
			@Override
			public boolean isCredentialsNonExpired() {
				System.out.println("isCredentialsNonExpired");
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean isAccountNonLocked() {
				// TODO Auto-generated method stub
				System.out.println("isAccountNonLocked");
				return true;
			}
			
			@Override
			public boolean isAccountNonExpired() {
				// TODO Auto-generated method stub
				System.out.println("isAccountNonExpired");
				return true;
			}
			
			@Override
			public String getUsername() {
				// TODO Auto-generated method stub
				System.out.println("getUsername");
				return "gvp_app";
			}
			
			@Override
			public String getPassword() {
				// TODO Auto-generated method stub
				System.out.println("getPassword");
				return "gvp_123456";
			}
			
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		return ud;
	}

}
