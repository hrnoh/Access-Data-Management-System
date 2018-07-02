package org.myhome.ADMS.domain;

import java.util.Date;

public class DoorlockVO {
	private String mac;
	private String location;
	private Date lastConTime;
	private boolean isConnected;
	
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
	public Date getLastConTime() {
		return lastConTime;
	}
	public void setLastConTime(Date lastConTime) {
		this.lastConTime = lastConTime;
	}
	public boolean isConnected() {
		return isConnected;
	}
	public void setConnected(boolean isConnected) {
		this.isConnected = isConnected;
	}
	@Override
	public String toString() {
		return "DoorlockVO [mac=" + mac + ", location=" + location + ", lastConTime=" + lastConTime + ", isConnected="
				+ isConnected + "]";
	}
	
	
}
