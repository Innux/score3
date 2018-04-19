package com.lut.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.lut.service.AcademyService;
import com.lut.utils.JsonUtils;
import com.lut.vo.Academy;
import com.lut.vo.Clazz;
import com.lut.vo.Major;
import com.opensymphony.xwork2.ActionContext;
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
    private List<Major> majorList;
    private List<Clazz> clazzList;
    HttpServletResponse response = ServletActionContext.getResponse();
    HttpServletRequest request = ServletActionContext.getRequest();

    // 根据学院id查询专业
    public String findMajorByAcademyId() throws IOException {
	String aid = request.getParameter("aid").trim();
	majorList = academyService.findMajorByAcademyId(Integer.parseInt(aid));
	response.setContentType("text/html;charset=UTF-8");
	String result = JsonUtils.toJson(majorList);
	// 打印转化出来的json
	System.out.println(result);
	ActionContext.getContext().put("majors", majorList);
	PrintWriter out = response.getWriter();
	out.print(result);
	out.flush();
	out.close();
	return NONE;
    }
    
    // 根据专业id查询班级
    public String findClassByMajorId() throws IOException {
	String mid = request.getParameter("mid").trim();
	clazzList = academyService.findClassByMajorId(Integer.parseInt(mid));
	response.setContentType("text/html;charset=UTF-8");
	String result = JsonUtils.toJson(clazzList);
	// 打印转化出来的json
	System.out.println(result);
	ActionContext.getContext().put("clazzs", clazzList);
	PrintWriter out = response.getWriter();
	out.print(result);
	out.flush();
	out.close();
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

    public List<Major> getMajorList() {
	return majorList;
    }

    public void setMajorList(List<Major> majorList) {
	this.majorList = majorList;
    }

    public List<Clazz> getClazzList() {
        return clazzList;
    }

    public void setClazzList(List<Clazz> clazzList) {
        this.clazzList = clazzList;
    }
    
    

}
