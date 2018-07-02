package org.myhome.ADMS.util;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class LogSearchCriteria extends Criteria {
	private String name;
	private String location;
	
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	private String startDate;
	
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	private String endDate;
	
	public LogSearchCriteria() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "LogSearchCriteria [name=" + name + ", location=" + location + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}
	
	
}
