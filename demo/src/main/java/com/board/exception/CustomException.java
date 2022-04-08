package com.board.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *  ErrorCode�� ���� ������ Custom ���ܸ� ó���� Exception Ŭ����
 *  ErrorResponse�� ���������� ErrorCode�� ���� ��ü ������ ���
 *  Unchecked Exception�� RuntimeException�� ��ӹ޴� ��
 * @author SJ
 *
 */
@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{
	private ErrorCode errorCode;
}
