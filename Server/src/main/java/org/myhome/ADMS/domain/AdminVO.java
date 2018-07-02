package org.myhome.ADMS.domain;

public class AdminVO {
	private String id;
	private String pwd;
	private String name;
	private String sex;
	private Integer age;
	private String email;
	private String phoneNum;
	private String originalFileName;
	private String storedFolderName;
	private String storedFileName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	@Override
	public String toString() {
		return "AdminVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", sex=" + sex + ", age=" + age + ", email="
				+ email + ", phoneNum=" + phoneNum + ", originalFileName=" + originalFileName + ", storedFolderName="
				+ storedFolderName + ", storedFileName=" + storedFileName + "]";
	}
}
