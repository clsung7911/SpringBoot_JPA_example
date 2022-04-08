package com.board.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *  ErrorCode에 직접 정의한 Custom 예외를 처리할 Exception 클래스
 *  ErrorResponse와 마찬가지로 ErrorCode를 통한 객체 생성만 허용
 *  Unchecked Exception인 RuntimeException을 상속받는 것
 * @author SJ
 *
 */
@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{
	private ErrorCode errorCode;
}
