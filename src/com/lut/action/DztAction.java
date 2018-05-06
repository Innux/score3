package com.lut.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.lut.service.DztService;
import com.lut.service.MajorService;
import com.lut.utils.PageBean;
import com.lut.vo.Major;
import com.lut.vo.Student;
import com.lut.vo.dztNprize.Dzt;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DztAction extends ActionSupport implements ModelDriven<Dzt> {

    HttpServletResponse response = ServletActionContext.getResponse();
    HttpServletRequest request = ServletActionContext.getRequest();

    Dzt dzt = new Dzt();

    @Override
    public Dzt getModel() {
	return dzt;
    }

    private DztService dztService;

    public void setDztService(DztService dztService) {
	this.dztService = dztService;
    }

    private MajorService majorService;

    public void setMajorService(MajorService majorService) {
	this.majorService = majorService;
    }

    // page参数
    private Integer page;

    public Integer getPage() {
	return page;
    }

    public void setPage(Integer page) {
	this.page = page;
    }

    public String findBySearchModel() {
	Dzt searchModel = new Dzt();

	Student stu = null;
	Major maj = null;

	String dYear = request.getParameter("dYear");
	if (dYear != null && !"".equals(dYear.trim())) {
	    searchModel.setYear(dYear);
	}

	Integer dMajor = null;
	String dMajorStr = request.getParameter("dMajor");
	if (dMajorStr != null && !"".equals(dMajorStr.trim())) {
	    dMajor = Integer.parseInt(dMajorStr);
	    stu = new Student();
	    maj = new Major();

	    maj.setM_id(dMajor);
	    stu.setMajor(maj);
	    searchModel.setStudent(stu);
	}

	PageBean<Dzt> pageBean = dztService.findByPage(searchModel, page);
	ActionContext.getContext().getValueStack().set("pageBean", pageBean);
	ActionContext.getContext().getValueStack().set("searchModel", searchModel);

	List<Major> majorList = majorService.findAll();
	ActionContext.getContext().getValueStack().set("majorList", majorList);

	return "findBySearchModel";
    }
    
    public String findBySearchModelOrder() {
   	Dzt searchModel = new Dzt();
   	Student stu = null;
   	Major maj = null;

   	String dYear = request.getParameter("dYear");
   	if (dYear != null && !"".equals(dYear.trim())) {
   	    searchModel.setYear(dYear);
   	}

   	PageBean<Dzt> pageBean = dztService.findByPageOrder(searchModel, page);
   	ActionContext.getContext().getValueStack().set("pageBean", pageBean);
   	ActionContext.getContext().getValueStack().set("searchModel", searchModel);

   	return "findBySearchModelOrder";
       }
    
//    public String findLimit() {
//	List<Dzt> dztList = dztService.findLimit("2014", "二等奖");
//	ActionContext.getContext().getValueStack().set("dztList", dztList);
//	return "findLimit";
//    }

}
