package com.cos.myjpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.myjpa.domain.user.User;
import com.cos.myjpa.domain.user.UserRepository;
import com.cos.myjpa.web.user.dto.UserJoinReqDto;
import com.cos.myjpa.web.user.dto.UserLoginReqDto;
import com.cos.myjpa.web.user.dto.UserRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	
	@Transactional
	public List<UserRespDto> 전체찾기() {
		List<User> usersEntity = userRepository.findAll();
		
		List<UserRespDto> userRespDtos = new ArrayList<>();
		for (User user : usersEntity) {
			userRespDtos.add(new UserRespDto(user));
		}
		
//		List<UserRespDto> userRespDtos = new ArrayList<>();
//		usersEntity.stream().forEach((u)->{
//			userRespDtos.add(new UserRespDto(u));
//		});
		
//		List<UserRespDto> userRespDtos = usersEntity.stream().map((u)->{
//			return new UserRespDto(u);
//		}).collect(Collectors.toList());
		
		return userRespDtos;	
	}
	
	@Transactional
	public UserRespDto 한건찾기(Long id) {
		User userEntity = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("id를 찾을 수 없습니다");
		});
		
		// 요청시에는 전부 DTO를 만들어야 한다
		// 응답시에는 필요할 때만 DTO를 만들면 된다
		// 지금은 User만 리턴하고 Post를 리턴하고 싶지 않기 때문에 DTO를 만듦
		UserRespDto userRespDto = new UserRespDto(userEntity);
		return userRespDto;
	}
	
	@Transactional
	public User 프로파일(Long id) {
		User userEntity = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("id를 찾을 수 없습니다");
		});
		
		return userEntity;
	}
	
	@Transactional
	// 기능 1 : 다른쪽에서 동시접근 하지 못하게 한다
	// 기능 2 : 만약 2개가 영향을 미친다면 둘 중에 하나라도 실패하면 롤백된다
	public User 회원가입(UserJoinReqDto userJoinReqDto) {
		User userEntity = userRepository.save(userJoinReqDto.toEntity());
//		User userEntity = userRepository.save(userJoinReqDto.toEntity());
		//DB로부터 받은건 전부 영속화된다
		return userEntity;
	}
	
	@Transactional(readOnly = true)
	public User 로그인(UserLoginReqDto userLoginReqDto) {
		User userEntity = userRepository.findByUsernameAndPassword(userLoginReqDto.getUsername(), userLoginReqDto.getPassword());
		return userEntity;
	}
}
