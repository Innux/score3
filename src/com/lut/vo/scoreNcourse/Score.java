package com.lut.vo.scoreNcourse;

import com.lut.vo.Student;

public class Score {
    private Integer s_id;
    private Integer s_score;
    private String s_year;
    private Integer s_half;
    private Student stu;
    private Course cou;

    public Integer getS_id() {
	return s_id;
    }

    public void setS_id(Integer s_id) {
	this.s_id = s_id;
    }

    public Integer getS_score() {
	return s_score;
    }

    public void setS_score(Integer s_score) {
	this.s_score = s_score;
    }

    public String getS_year() {
	return s_year;
    }

    public void setS_year(String s_year) {
	this.s_year = s_year;
    }

    public Integer getS_half() {
	return s_half;
    }

    public void setS_half(Integer s_half) {
	this.s_half = s_half;
    }

    public Student getStu() {
	return stu;
    }

    public void setStu(Student stu) {
	this.stu = stu;
    }

    public Course getCou() {
	return cou;
    }

    public void setCou(Course cou) {
	this.cou = cou;
    }

}
