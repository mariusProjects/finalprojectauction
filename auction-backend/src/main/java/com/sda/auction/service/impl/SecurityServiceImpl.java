package com.sda.auction.service.impl;

import com.sda.auction.dto.LoginDto;
import com.sda.auction.model.User;
import com.sda.auction.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public boolean passwordMatch(LoginDto userDto, User user) {
		String plaintextPassword = userDto.getPassword();
		String hashedPassword = user.getPassword();

		return passwordEncoder.matches(plaintextPassword, hashedPassword);
	}

	@Override
	public LoginDto createDtoWithJwt(LoginDto loginDto) {
		return null;
	}
}
