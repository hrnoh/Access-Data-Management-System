package org.myhome.ADMS.util;

public class UserSearchCriteria extends Criteria {
	private String type;
	private String keyword;
	
	public UserSearchCriteria() {
		super();
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "UserSearchCriteria [type=" + type + ", keyword=" + keyword + "]";
	}
	
	
}
