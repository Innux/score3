package com.lut.vo.liuyan;

import com.lut.vo.Student;

public class Reply {
    private Integer id;
    private String content;
    private String time;
    private Student student;
    private Liuyan liuyan;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getContent() {
	return content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public String getTime() {
	return time;
    }

    public void setTime(String time) {
	this.time = time;
    }

    public Student getStudent() {
	return student;
    }

    public void setStudent(Student student) {
	this.student = student;
    }

    public Liuyan getLiuyan() {
	return liuyan;
    }

    public void setLiuyan(Liuyan liuyan) {
	this.liuyan = liuyan;
    }

}
