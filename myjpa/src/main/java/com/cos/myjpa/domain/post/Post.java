package com.cos.myjpa.domain.post;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.cos.myjpa.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
//테이블 자동생성
public class Post {
	@Id //pk설정
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Table,auto_increment,Sequence
	private Long id;
	@Column(length = 60,nullable = false)
	private String title;
	@Lob    //대용량 데이터
	private String content;
	
	// 순방향 매핑
	 @ManyToOne(fetch = FetchType.LAZY)  //Post만 보고싶을 때 
//	 @ManyToOne(fetch = FetchType.EAGER) //User도 보고싶을 때
	 //  many는 post one은 user 관계를 맺었다
	 // 연관관계 맺는방법 (FK의 주인인곳에서 적어야한다.)
	@JoinColumn(name = "userId")
	private User user;
	
	@CreationTimestamp //자동으로 현재 시간이 들어감.
	private LocalDateTime createDate;
}
