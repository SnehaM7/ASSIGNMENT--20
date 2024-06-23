package com.app.studentapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.studentapi.model.User;
import com.app.studentapi.repository.UserRepository;

@Service
public class UserService  implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userOptional =	userRepository.findByUsername(username);
		return userOptional.orElseThrow(()->new UsernameNotFoundException("Username doesn't exist"));
	}
	
	public void register(User user) {
		String textPassword = user.getPassword();
		String encodedPassword = passwordEncoder.encode(textPassword);
		user.setPassword(encodedPassword);
		userRepository.save(user);
	}

}
