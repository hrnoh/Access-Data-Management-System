package org.myhome.ADMS.domain;

import java.util.Date;

public class LogVO {
	private Integer lno;
	private String name;
	private String location;
	private Date accessTime;
	private boolean isSuccess;
	private String storedFolderName;
	private String storedFileName;
	private Integer uno;
	private String mac;
	
	public Integer getUno() {
		return uno;
	}
	public void setUno(Integer uno) {
		this.uno = uno;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	private Double distance;
	public Integer getLno() {
		return lno;
	}
	public void setLno(Integer lno) {
		this.lno = lno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getAccessTime() {
		return accessTime;
	}
	public void setAccessTime(Date accessTime) {
		this.accessTime = accessTime;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getStoredFolderName() {
		return storedFolderName;
	}
	public void setStoredFolderName(String storedFolderName) {
		this.storedFolderName = storedFolderName;
	}
	public String getStoredFileName() {
		return storedFileName;
	}
	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	@Override
	public String toString() {
		return "LogVO [lno=" + lno + ", name=" + name + ", location=" + location + ", accessTime=" + accessTime
				+ ", isSuccess=" + isSuccess + ", storedFolderName=" + storedFolderName + ", storedFileName="
				+ storedFileName + ", uno=" + uno + ", mac=" + mac + ", distance=" + distance + "]";
	}
	
	
}
