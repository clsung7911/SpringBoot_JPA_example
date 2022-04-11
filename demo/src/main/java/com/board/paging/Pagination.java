package com.board.paging;

import lombok.Getter;

@Getter
public class Pagination {
	private int totalRecordCount;   // ��ü ������ ��
    private int totalPageCount;     // ��ü ������ ��
    private int startPage;          // ù ������ ��ȣ
    private int endPage;            // �� ������ ��ȣ
    private int limitStart;         // LIMIT ���� ��ġ
    private boolean existPrevPage;  // ���� ������ ���� ����
    private boolean existNextPage;  // ���� ������ ���� ����

    public Pagination(int totalRecordCount, CommonPaging params) {
        if (totalRecordCount > 0) {
            this.totalRecordCount = totalRecordCount;
            this.calculation(params);
        }
    }

    private void calculation(CommonPaging params) {

        // ��ü ������ �� ���
        totalPageCount = ((totalRecordCount - 1) / params.getRecordPerPage()) + 1;

        // ���� ������ ��ȣ�� ��ü ������ ������ ū ���, ���� ������ ��ȣ�� ��ü ������ �� ����
        if (params.getPage() > totalPageCount) {
            params.setPage(totalPageCount);
        }

        // ù ������ ��ȣ ���
        startPage = ((params.getPage() - 1) / params.getPageSize()) * params.getPageSize() + 1;

        // �� ������ ��ȣ ���
        endPage = startPage + params.getPageSize() - 1;

        // �� �������� ��ü ������ ������ ū ���, �� ������ ��ü ������ �� ����
        if (endPage > totalPageCount) {
            endPage = totalPageCount;
        }

        // LIMIT ���� ��ġ ���
        limitStart = (params.getPage() - 1) * params.getRecordPerPage();

        // ���� ������ ���� ���� Ȯ��
        existPrevPage = startPage != 1;

        // ���� ������ ���� ���� Ȯ��
        existNextPage = (endPage * params.getRecordPerPage()) < totalRecordCount;
    }
}