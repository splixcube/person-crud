package com.ksh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ksh.entities.User;
import com.ksh.repositories.UserRepository;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserRepository userRepository; 
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findById(username).get();
		System.out.println("Username : "+username);
		System.out.println("User : "+user);
	    UserBuilder builder = null;
	    if (user != null) {
	    	try {
	    		builder = org.springframework.security.core.userdetails.User.withUsername(username);
		    	builder.disabled(!user.isEnabled());
		    	builder.password(user.getPassword());
		    	System.out.println(user.getPassword());
		    	System.out.println("Size : "+user.getAuthorities().size());
		    	String[] authorities = user.getAuthorities().stream().map(a -> a.getAuthority()).toArray(String[]::new);
		    	builder.authorities(authorities);
		    	System.out.println("User Found...");
	    	}
	    	catch (Exception e) {
	    		e.printStackTrace();
			}
	    } 
	    else {
	    	throw new UsernameNotFoundException("User not found.");
	    }
	    return builder.build();
	}
	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = new User("kshitij", "kshitij", new ArrayList<GrantedAuthority>());
//		return user;
//	}

}
