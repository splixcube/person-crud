package com.ksh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ksh.reqrep.AuthenticationReq;
import com.ksh.reqrep.CommonResponse;
import com.ksh.util.Constants;
import com.ksh.util.JwtUtil;

@RestController
@CrossOrigin(value="http://localhost:4200")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtUtil;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public CommonResponse authenticate(@RequestBody AuthenticationReq authenticationReq) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationReq.getUserName(),
					authenticationReq.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationReq.getUserName());
		final String jwt = jwtUtil.generateToken(userDetails);
		return new CommonResponse(200, Constants.SUCCESS, jwt);
	}
}
