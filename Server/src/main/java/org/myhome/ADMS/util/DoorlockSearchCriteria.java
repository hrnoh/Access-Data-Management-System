package org.myhome.ADMS.util;

public class DoorlockSearchCriteria extends Criteria {
	private String location;

	public DoorlockSearchCriteria() {
		super();
	}
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "DoorlockSearchCriteria [location=" + location + "]";
	}
	
}
