package com.cos.myjpa.web.post.dto;

import com.cos.myjpa.domain.post.Post;

import lombok.Data;

@Data

public class PostUpdateReqDto {
	private String title;
	private String content;
	
	public Post toEntity() {
		return Post.builder()
				.title(title)
				.content(content)
				.build();
	}
}
