package org.myhome.ADMS.domain;

public class UserVO {
	private Integer uno;
	private String name;
	private String sex;
	private Integer age;
	private String email;
	private String phoneNum;
	private String originalFileName;
	private String storedFolderName;
	private String storedFileName;
	private String pictureEncoding;
	private String accessKey;
	
	public Integer getUno() {
		return uno;
	}
	public void setUno(Integer uno) {
		this.uno = uno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
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
	public String getPictureEncoding() {
		return pictureEncoding;
	}
	public void setPictureEncoding(String pictureEncoding) {
		this.pictureEncoding = pictureEncoding;
	}
	public String getAccessKey() {
		return accessKey;
	}
	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}
	@Override
	public String toString() {
		return "UserVO [uno=" + uno + ", name=" + name + ", sex=" + sex + ", age=" + age + ", email=" + email
				+ ", phoneNum=" + phoneNum + ", originalFileName=" + originalFileName + ", storedFolderName="
				+ storedFolderName + ", storedFileName=" + storedFileName + ", pictureEncoding=" + pictureEncoding
				+ ", accessKey=" + accessKey + "]";
	}
	
	
}
