package com.lut.vo;

public class Clazz {
    private int class_id;
    private String class_name;
    // 二级分类的外键:使用二级分类的对象.
    private Major major;

    public Major getMajor() {
	return major;
    }

    public void setMajor(Major major) {
	this.major = major;
    }

    public int getClass_id() {
	return class_id;
    }

    public void setClass_id(int class_id) {
	this.class_id = class_id;
    }

    public String getClass_name() {
	return class_name;
    }

    public void setClass_name(String class_name) {
	this.class_name = class_name;
    }

}
