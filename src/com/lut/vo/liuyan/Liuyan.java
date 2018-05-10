package com.lut.vo.liuyan;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.lut.vo.Student;

public class Liuyan {
    private Integer id;
    private String content;
    private String time;
    private Student student;

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

}
