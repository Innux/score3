package com.lut.vo.dztNprize;

import com.lut.vo.Student;

public class Prize {
    private Integer id;
    private Student student;
    private Rule rule;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Student getStudent() {
	return student;
    }

    public void setStudent(Student student) {
	this.student = student;
    }

    public Rule getRule() {
	return rule;
    }

    public void setRule(Rule rule) {
	this.rule = rule;
    }

}
