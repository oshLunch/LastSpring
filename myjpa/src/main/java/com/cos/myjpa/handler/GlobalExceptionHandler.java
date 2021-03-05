package com.cos.myjpa.handler;

import org.hibernate.exception.DataException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.myjpa.web.dto.CommonRespDto;

@RestController //컨트롤러가 있어야 데이터를 리턴할 수 있다.
@ControllerAdvice //모든 익셉션을 낚아챔.
public class GlobalExceptionHandler {
	
	//그중 IllegalArgumentException이 발생하면 해당 함수 실행된다.
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public CommonRespDto<?> dataIntegrityViolation(Exception e){
		return new CommonRespDto<>(-1,e.getMessage(),null);
	}
	
	@ExceptionHandler(value = IllegalArgumentException.class)
	public CommonRespDto<?> illegalArgument(Exception e){
		return new CommonRespDto<>(-1,e.getMessage(),null);
	}
	
	@ExceptionHandler(value = EmptyResultDataAccessException.class)
	public CommonRespDto<?> emptyResultDataAccess(Exception e){
		return new CommonRespDto<>(-1,e.getMessage(),null);
	}
}
