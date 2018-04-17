package com.lut.vo.scoreNcourse;

import com.lut.vo.Student;

public class Score {
    private Integer s_id;
    private Integer s_score;
    private String s_year;
    private Integer s_half;
    private Student student;
    private Course course;

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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

 

}
