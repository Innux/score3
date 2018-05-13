package com.lut.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.lut.service.ClazzService;
import com.lut.service.MajorService;
import com.lut.service.ScoreService;
import com.lut.utils.PageBean;
import com.lut.vo.Major;
import com.lut.vo.Student;
import com.lut.vo.dztNprize.Dzt;
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
	score = scoreService.findByScoreId(score.getS_id());
	scoreService.delete(score);
	return "deleteSuccess";
    }

    public String findBySearchModel() {
	Score searchModel = new Score();
	Student stu = null;
	Major maj = null;

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

	PageBean<Score> pageBean = scoreService.findByPage(searchModel, page);
	ActionContext.getContext().getValueStack().set("pageBean", pageBean);
	ActionContext.getContext().getValueStack().set("searchModel", searchModel);

	List<Major> majorList = majorService.findAll();
	ActionContext.getContext().getValueStack().set("majorList", majorList);

	return "findBySearchModel";
    }

    public String stuFindBySearchModel() {
	Student user = (Student) ServletActionContext.getRequest().getSession().getAttribute("user");
	Score searchModel = new Score();

	String stuYear = request.getParameter("stuYear");
	if (stuYear != null && !"".equals(stuYear.trim())) {
	    searchModel.setS_year(stuYear);
	}
	
	String stuHalf = request.getParameter("stuHalf");
	if (stuHalf != null && !"".equals(stuHalf.trim())) {
	    searchModel.setS_half(stuHalf.equals("上学期")?1:2);
	}

	PageBean<Score> pageBean = scoreService.stuFindByPage(user.getId(),searchModel, page);
	ActionContext.getContext().getValueStack().set("pageBean", pageBean);
	ActionContext.getContext().getValueStack().set("searchModel", searchModel);

	return "stuFindBySearchModel";
    }

    public void exportExcel() {
	try {
	    // 1、查找列表
	    List<Score> scoreList = scoreService.findAll();
	    // 2、导出
	    HttpServletRequest request = ServletActionContext.getRequest();
	    HttpServletResponse response = ServletActionContext.getResponse();
	    Date d = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("MMdd_HHmm");

	    response.setContentType("application/octet-stream");
	    response.setHeader("Content-Disposition",
		    "attachment;filename=" + new String(("score_" + sdf.format(d) + ".xls").getBytes(), "utf-8"));
	    ServletOutputStream outputStream = response.getOutputStream();
	    scoreService.exportExcel(scoreList, outputStream);
	    if (outputStream != null) {
		outputStream.close();
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    private File scoreExcel;
    private String scoreExcelContentType;
    private String scoreExcelFileName;

    public File getScoreExcel() {
	return scoreExcel;
    }

    public void setScoreExcel(File scoreExcel) {
	this.scoreExcel = scoreExcel;
    }

    public String getScoreExcelContentType() {
	return scoreExcelContentType;
    }

    public void setScoreExcelContentType(String scoreExcelContentType) {
	this.scoreExcelContentType = scoreExcelContentType;
    }

    public String getScoreExcelFileName() {
	return scoreExcelFileName;
    }

    public void setScoreExcelFileName(String scoreExcelFileName) {
	this.scoreExcelFileName = scoreExcelFileName;
    }

    // 导入用户列表
    public String importExcel() {
	// 1、获取文件，并判断是否为excel文件
	if (scoreExcel != null && scoreExcelFileName.matches("^.+\\.(?i)((xls)|(xlsx))$")) {
	    // 2、导入
	    System.out.println("==================导入");
	    scoreService.importExcel(scoreExcel, scoreExcelFileName);
	} else {
	    System.out.println(":::null::::");
	}
	return "importExcel";
    }

}
