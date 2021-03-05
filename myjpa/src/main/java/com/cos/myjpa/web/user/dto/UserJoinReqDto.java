package com.cos.myjpa.web.user.dto;

import com.cos.myjpa.domain.user.User;

import lombok.Data;

@Data
public class UserJoinReqDto {
	private String username;
	private String password;
	private String email;
	
	public User toEntity() {
		return User.builder()
				.username(username)
				.password(password)
				.email(email)
				.build();
	}
}

