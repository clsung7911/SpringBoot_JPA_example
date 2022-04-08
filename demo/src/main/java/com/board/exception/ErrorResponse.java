package com.board.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;

/**
 * ErrorCode�� ���� ��ü ������ ���
 * ���� ������ ó���ϴ� Ŭ���� 
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
