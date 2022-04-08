package com.board.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;

/**
 * ErrorCode를 통한 객체 생성만 허용
 * 예외 응답을 처리하는 클래스 
 * @author SJ
 *
 */

@Getter
public class ErrorResponse {
//	private LocalDateTime timestamp = LocalDateTime.now();
	private String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss"));
    private int status;
    private String error;
    private String code;
    private String message;

    public ErrorResponse(ErrorCode errorCode) {
        this.status = errorCode.getStatus().value();
        this.error = errorCode.getStatus().name();
        this.code = errorCode.name();
        this.message = errorCode.getMessage();
    }
}
