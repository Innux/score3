package com.lut.action;

import java.io.IOException;
import java.util.List;

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
    //查询所有学院
    public String findAllAcademy() {
	academys = academyService.findAllAcademy();
	return "findAllAcademy";
    }
    private List<Major> majors;
    //根据学院id查询专业
    public String findMajorByAcademyId() throws IOException {
	majors = academyService.findMajorByAcademyId(academy.getA_id());
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=UTF-8");
	if (majors != null) {
//	    response.getWriter().println("<font color='red'>用户ID已存在</font>");
	    System.out.println("=============有数据");
	} else {
	    System.out.println("=============没查到");
//	    response.getWriter().println("<font color='green'>用户ID可以使用</font>");
	}
	return NONE;
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
    
    

}
