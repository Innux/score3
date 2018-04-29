package com.lut.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.lut.service.ClazzService;
import com.lut.service.MajorService;
import com.lut.service.ScoreService;
import com.lut.utils.PageBean;
import com.lut.vo.Clazz;
import com.lut.vo.Major;
import com.lut.vo.Student;
import com.lut.vo.scoreNcourse.Score;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ScoreAction extends ActionSupport implements ModelDriven<Score> {
    HttpServletResponse response = ServletActionContext.getResponse();
    HttpServletRequest request = ServletActionContext.getRequest();

    // 模型驱动
    private Score score = new Score();

    @Override
    public Score getModel() {
	return score;
    }

    // 注入scoreservice
    private ScoreService scoreService;

    public void setScoreService(ScoreService scoreService) {
	this.scoreService = scoreService;
    }

    // Major Service
    private MajorService majorService;

    public void setMajorService(MajorService majorService) {
	this.majorService = majorService;
    }

    // Clazz Service
    private ClazzService clazzService;

    public void setClazzService(ClazzService clazzService) {
	this.clazzService = clazzService;
    }

    // page参数
    private Integer page;

    public Integer getPage() {
	return page;
    }

    public void setPage(Integer page) {
	this.page = page;
    }

    public String findAll() {
	PageBean<Score> pageBean = scoreService.findByPage(page);
	// 将PageBean数据存入到值栈中.
	ActionContext.getContext().getValueStack().set("pageBean", pageBean);
	List<Major> majorList = majorService.findAll();
	ActionContext.getContext().getValueStack().set("majorList", majorList);
	// 页面跳转
	return "findAll";
    }

    public String delete() {
	// 根据id查询商品信息
	score = scoreService.findByScoreId(score.getS_id());
	scoreService.delete(score);
	return "deleteSuccess";
    }

    public String findBySearchModel() {
	Score searchModel = new Score();
	Student stu = null;
	Major maj = null;
//	Clazz cla = new Clazz();

	String sYear = request.getParameter("sYear");
	if (sYear != null && !"".equals(sYear.trim())) {
	    searchModel.setS_year(sYear);
	}
	
	Integer sHalf = null;
	String sHalfStr = request.getParameter("sHalf");
	if (sHalfStr != null && !"".equals(sHalfStr.trim())) {
	    sHalf = Integer.parseInt(sHalfStr);
	    searchModel.setS_half(sHalf);
	}

	Integer sMajor = null;
	String sMajorStr = request.getParameter("sMajor");
	if (sMajorStr != null && !"".equals(sMajorStr.trim())) {
	    sMajor = Integer.parseInt(sMajorStr);
	    stu = new Student();
	    maj = new Major();
	    maj.setM_id(sMajor);
	    stu.setMajor(maj);
	    searchModel.setStudent(stu);
	}

	// Integer sClazz = null;
	// String sClazzStr = request.getParameter("sClazz");
	// if (sClazzStr != null && !"".equals(sClazzStr.trim())) {
	// sClazz = Integer.parseInt(sClazzStr);
	// cla.setClass_id(sClazz);
	// stu.setClazz(cla);
	// searchModel.setStudent(stu);
	// }

	PageBean<Score> pageBean = scoreService.findByPage(searchModel, page);
	ActionContext.getContext().getValueStack().set("pageBean", pageBean);
	ActionContext.getContext().getValueStack().set("searchModel", searchModel);

	List<Major> majorList = majorService.findAll();
	ActionContext.getContext().getValueStack().set("majorList", majorList);
	// List<Clazz> clazzList = clazzService.findAll();
	// ActionContext.getContext().getValueStack().set("clazzList",
	// clazzList);

	return "findBySearchModel";
    }

}
