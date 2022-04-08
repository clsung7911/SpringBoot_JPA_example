package com.board.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

//�Ϲ������� @ExceptionHandler�� @ControllerAdvice�� ����� Ŭ������ ���Ե� �޼��忡 ����
@RestControllerAdvice
//�ش� ������̼��� ����� Ŭ������ �ڵ����� �α� ��ü�� ����, Logger ���� ���ص� �ڵ� ����
@Slf4j
public class GlobalExceptionHandler {
	//@ControllerAdvice�� ��Ʈ�ѷ� �������� �߻��� �� �ִ� ���ܸ� ��� Throw
	//@ExceptionHandler�� Ư�� Ŭ�������� �߻��� �� �ִ� ���ܸ� ��� Throw
	
	/*
	 * ������ Custom Exception
	 */
	@ExceptionHandler(CustomException.class)
    protected ResponseEntity<ErrorResponse> handleCustomException(final CustomException e) {
        log.error("handleCustomException: {}", e.getErrorCode());
        return ResponseEntity.status(e.getErrorCode().getStatus().value()).body(new ErrorResponse(e.getErrorCode()));
    }
	
	/*
	 * HTTP 405 Exception
	 */
	//ResponseEntity<T>�� HTTP Request�� ���� ���� �����͸� �����ϴ� Ŭ����
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
