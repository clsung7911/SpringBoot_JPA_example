package com.board.paging;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonPaging {
	/** 현재 페이지 번호 */
	private int page;
	/** 페이지당 출력할 데이터 개수 */
	private int recordPerPage;
	/** 화면 하단에 출력할 페이지 사이즈 */
	private int pageSize;
	/** 검색 키워드 */
	private String keyword;
	/** 검색 유형 */
	private String searchType;
	/** pagination 정보 */
	private Pagination pagination;

}
