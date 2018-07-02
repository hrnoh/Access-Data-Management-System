package org.myhome.ADMS.util;

public class Criteria {
	private int currentPage;
	private int perPageNum;
	
	public Criteria() {
		currentPage = 1;
		perPageNum = 10;
	}
	
	public int getStartNum() {
		return (currentPage-1) * perPageNum;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		if(currentPage < 1) {
			this.currentPage = 1;
			return;
		}
		
		this.currentPage = currentPage;
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		if(perPageNum < 1) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	@Override
	public String toString() {
		return "Criteria [currentPage=" + currentPage + ", perPageNum=" + perPageNum + "]";
	}
}
