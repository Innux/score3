package com.lut.vo;

import java.util.HashSet;
import java.util.Set;

public class Major {

    private Integer m_id;
    private String m_name;
    // 所属一级分类 学院
    private Academy academy;

    public Academy getAcademy() {
	return academy;
    }

    public void setAcademy(Academy academy) {
	this.academy = academy;
    }

    public Integer getM_id() {
	return m_id;
    }

    public void setM_id(Integer m_id) {
	this.m_id = m_id;
    }

    public String getM_name() {
	return m_name;
    }

    public void setM_name(String m_name) {
	this.m_name = m_name;
    }

}
