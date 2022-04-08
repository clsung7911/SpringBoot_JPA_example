package com.board.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

//일반적으로 @ExceptionHandler는 @ControllerAdvice가 선언된 클래스에 포함된 메서드에 선언
@RestControllerAdvice
//해당 어노테이션이 선언된 클래스에 자동으로 로그 객체를 생성, Logger 생성 안해도 자동 생성
@Slf4j
public class GlobalExceptionHandler {
	//@ControllerAdvice는 컨트롤러 전역에서 발생할 수 있는 예외를 잡아 Throw
	//@ExceptionHandler는 특정 클래스에서 발생할 수 있는 예외를 잡아 Throw
	
	/*
	 * 개발자 Custom Exception
	 */
	@ExceptionHandler(CustomException.class)
    protected ResponseEntity<ErrorResponse> handleCustomException(final CustomException e) {
        log.error("handleCustomException: {}", e.getErrorCode());
        return ResponseEntity.status(e.getErrorCode().getStatus().value()).body(new ErrorResponse(e.getErrorCode()));
    }
	
	/*
	 * HTTP 405 Exception
	 */
	//ResponseEntity<T>는 HTTP Request에 대한 응답 데이터를 포함하는 클래스
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	protected ResponseEntity<ErrorResponse> handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
		log.error("handleHttpRequestMethodNotSupportedException: {}", e.getMessage());
		return ResponseEntity.status(ErrorCode.METHOD_NOT_ALLOWED.getStatus().value()).body(new ErrorResponse(ErrorCode.METHOD_NOT_ALLOWED));
	}
	
	/*
     * HTTP 500 Exception
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(final Exception e) {
        log.error("handleException: {}", e.getMessage());
        return ResponseEntity.status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus().value()).body(new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR));
    }
}
