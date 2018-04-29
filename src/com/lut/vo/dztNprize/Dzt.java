package com.lut.vo.dztNprize;

import com.lut.vo.Student;

public class Dzt {
    private Integer id;
    private String year;
    private Float de;
    private Float zhi;
    private Float ti;
    private Student student;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getYear() {
	return year;
    }

    public void setYear(String year) {
	this.year = year;
    }

    public Float getDe() {
	return de;
    }

    public void setDe(Float de) {
	this.de = de;
    }

    public Float getZhi() {
	return zhi;
    }

    public void setZhi(Float zhi) {
	this.zhi = zhi;
    }

    public Float getTi() {
	return ti;
    }

    public void setTi(Float ti) {
	this.ti = ti;
    }

    public Student getStudent() {
	return student;
    }

    public void setStudent(Student student) {
	this.student = student;
    }

}
