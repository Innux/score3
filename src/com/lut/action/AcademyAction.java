package com.lut.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.lut.service.AcademyService;
import com.lut.vo.Academy;
import com.lut.vo.Major;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AcademyAction extends ActionSupport implements ModelDriven<Academy> {

    private Academy academy = new Academy();

    @Override
    public Academy getModel() {
	return academy;
    }

    private AcademyService academyService;

    public void setAcademyService(AcademyService academyService) {
	this.academyService = academyService;
    }

    private List<Academy> academys;

    // 查询所有学院
    public String findAllAcademy() {
	academys = academyService.findAllAcademy();
	return "findAllAcademy";
    }

    // ajax专业查询
    private List<Major> majors;
    private Map<String, Object> messageAjax;
    HttpServletResponse response = ServletActionContext.getResponse();
    HttpServletRequest request = ServletActionContext.getRequest();

    // 根据学院id查询专业
    public String findMajorByAcademyId() throws IOException {
	majors = academyService.findMajorByAcademyId(academy.getA_id());
	messageAjax = new HashMap<String,Object>();
	messageAjax.put("majors", majors);
	if (majors != null) {
	    System.out.println("=============有数据");
	} else {
	    System.out.println("=============没数据");
	}
	return SUCCESS;
    }

    public List<Academy> getAcademys() {
	return academys;
    }

    public void setAcademys(List<Academy> academys) {
	this.academys = academys;
    }

    public Academy getAcademy() {
	return academy;
    }

    public void setAcademy(Academy academy) {
	this.academy = academy;
    }

    public List<Major> getMajors() {
	return majors;
    }

    public void setMajors(List<Major> majors) {
	this.majors = majors;
    }

    public Map<String, Object> getMessageAjax() {
        return messageAjax;
    }

    public void setMessageAjax(Map<String, Object> messageAjax) {
        this.messageAjax = messageAjax;
    }

    
}
