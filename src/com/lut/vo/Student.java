package com.lut.vo;

public class Student {
    private Integer id;
    private String loginName;
    private String loginPwd;
    private String name;
    private String number;
    private Integer age;
    private Integer sex;
    private Academy academy;
    private Major major;
    private Clazz clazz;

    private Integer type;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getLoginName() {
	return loginName;
    }

    public void setLoginName(String loginName) {
	this.loginName = loginName;
    }

    public String getLoginPwd() {
	return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
	this.loginPwd = loginPwd;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getNumber() {
	return number;
    }

    public void setNumber(String number) {
	this.number = number;
    }

    public Integer getAge() {
	return age;
    }

    public void setAge(Integer age) {
	this.age = age;
    }

    public Integer getSex() {
	return sex;
    }

    public void setSex(Integer sex) {
	this.sex = sex;
    }

    public Academy getAcademy() {
	return academy;
    }

    public void setAcademy(Academy academy) {
	this.academy = academy;
    }

    public Major getMajor() {
	return major;
    }

    public void setMajor(Major major) {
	this.major = major;
    }

    public Clazz getClazz() {
	return clazz;
    }

    public void setClazz(Clazz clazz) {
	this.clazz = clazz;
    }

    public Integer getType() {
	return type;
    }

    public void setType(Integer type) {
	this.type = type;
    }

}
