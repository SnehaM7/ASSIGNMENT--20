package com.app.studentapi.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.studentapi.constants.ResponseKey;
import com.app.studentapi.constants.ResponseMessage;
import com.app.studentapi.model.AuthRequest;
import com.app.studentapi.model.User;
import com.app.studentapi.service.JwtService;
import com.app.studentapi.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User user){
		userService.register(user);
		HashMap<String, String> body = new HashMap<>();
		body.put(ResponseKey.MESSAGE, ResponseMessage.USER_REGISTERED);
		return new ResponseEntity<>(body,HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthRequest authRequest){
		// java object that will represent the req body of auth request
		HashMap<String, String> body = new HashMap<>();
		try {
			UsernamePasswordAuthenticationToken authentication=	new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
			authenticationManager.authenticate(authentication);
		} catch (BadCredentialsException e) {
			
			body.put(ResponseKey.MESSAGE, ResponseMessage.INVALID_CREDENTIALS);
			return new ResponseEntity<>(body,HttpStatus.BAD_REQUEST);
		}
		String token = jwtService.generateToken(authRequest.getUsername());
		body.put(ResponseKey.TOKEN, token);
		return new ResponseEntity<>(body,HttpStatus.OK);
	}
	
}
