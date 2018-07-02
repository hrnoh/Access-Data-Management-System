package org.myhome.ADMS.util;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	private Criteria cri;
	private int displayPageNum = 10;
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	
	// 페이징 처리 변수들 계산	
	public void calcPage() {
		int totalPage = (int)Math.ceil(((double)totalCount/cri.getPerPageNum()));
		
		startPage = (int)(cri.getCurrentPage()/displayPageNum) * displayPageNum + 1;
		endPage = startPage + displayPageNum - 1;
		
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		prev = (startPage==1)? false:true;
		next = (endPage==totalPage)? false:true;
	}
	
	// 기본 쿼리스트링 생성
	public String makeQuery(int page) {
		if(cri!=null) {
			UriComponents uriComponents = UriComponentsBuilder.newInstance()
					.queryParam("currentPage", page)
					.queryParam("perPageNum", cri.getPerPageNum())
					.build();
			
			return uriComponents.toString();
		}
		return null;
	}
	
	// 출입자 검색용 쿼리스트링 생성
	public String makeQueryForUser(int page) {
		if(cri!=null && cri instanceof UserSearchCriteria) {
			UriComponents uriComponents = UriComponentsBuilder.newInstance()
					.queryParam("currentPage", page)
					.queryParam("perPageNum", cri.getPerPageNum())
					.queryParam("type", ((UserSearchCriteria)cri).getType())
					.queryParam("keyword", ((UserSearchCriteria)cri).getKeyword())
					.build();
			
			return uriComponents.toString();
		}
		return makeQuery(page);
	}
	
	// 도어락 검색용 쿼리스트링 생성
	public String makeQueryForDoorlock(int page) {
		if(cri!=null && cri instanceof DoorlockSearchCriteria) {
			UriComponents uricomponents = UriComponentsBuilder.newInstance()
					.queryParam("currentPage", page)
					.queryParam("perPageNum", cri.getPerPageNum())
					.queryParam("location", ((DoorlockSearchCriteria)cri).getLocation())
					.build();
			
			return uricomponents.toString();
		}
		
		return makeQuery(page);
	}
	
	// 로그 검색용 쿼리스트링 생성
	public String makeQueryForLog(int page) {
		if(cri!=null && cri instanceof LogSearchCriteria) {
			UriComponents uricomponents = UriComponentsBuilder.newInstance()
					.queryParam("currentPage", page)
					.queryParam("perPageNum", cri.getPerPageNum())
					.queryParam("name", ((LogSearchCriteria)cri).getName())
					.queryParam("location", ((LogSearchCriteria)cri).getLocation())
					.queryParam("startDate", ((LogSearchCriteria)cri).getStartDate())
					.queryParam("endDate", ((LogSearchCriteria)cri).getEndDate())
					.build();
			
			return uricomponents.toString();
		}
		
		return makeQuery(page);
	}
}
