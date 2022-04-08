package com.board.paging;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonPaging {
	/** ���� ������ ��ȣ */
	private int page;
	/** �������� ����� ������ ���� */
	private int recordPerPage;
	/** ȭ�� �ϴܿ� ����� ������ ������ */
	private int pageSize;
	/** �˻� Ű���� */
	private String keyword;
	/** �˻� ���� */
	private String searchType;
	/** pagination ���� */
	private Pagination pagination;

}
