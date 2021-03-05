package com.cos.myjpa.web.post.dto;

import java.time.LocalDateTime;

import com.cos.myjpa.domain.post.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PostRespDto {

	private Long id;
	private String title;
	private String content;
	private LocalDateTime createDate;
	
	public PostRespDto(Post post) {
		this.id = post.getId();
		this.title = post.getTitle();
		this.content = post.getContent();
		this.createDate = post.getCreateDate();
	}
}
