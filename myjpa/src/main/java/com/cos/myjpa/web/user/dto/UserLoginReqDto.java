package com.cos.myjpa.web.user.dto;

import com.cos.myjpa.domain.post.Post;
import com.cos.myjpa.domain.user.User;

import lombok.Data;

@Data
public class UserLoginReqDto {
	private String username;
	private String password;

	public User toEntity() {
		return User.builder()
				.username(username)
				.password(password)
				.build();
	}
}
