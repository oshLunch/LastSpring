package com.cos.myjpa.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CommonRespDto<T> {
	private int statusCode; //상태코드 = 1정상, -1실패
	private String msg; //오류 내용 Value too long for column "TITLE VARCHAR"
	private T data;
}
