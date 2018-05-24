package com.lut.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.lut.service.TeacherScoreService;
import com.lut.vo.Student;
import com.lut.vo.Teacher;
import com.lut.vo.TeacherScore;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TeacherAction extends ActionSupport implements ModelDriven<TeacherScore> {

    HttpServletResponse response = ServletActionContext.getResponse();
    HttpServletRequest request = ServletActionContext.getRequest();

    TeacherScore teacherScore = new TeacherScore();

    @Override
    public TeacherScore getModel() {
	return teacherScore;
    }

    private TeacherScoreService teacherScoreService;

    public void setTeacherScoreService(TeacherScoreService teacherScoreService) {
	this.teacherScoreService = teacherScoreService;
    }

    List<TeacherScore> tsList;

    public List<TeacherScore> getTsList() {
	return tsList;
    }

    public void setTsList(List<TeacherScore> tsList) {
	this.tsList = tsList;
    }

    public String findAllByStuId() {
	Student user = (Student) ServletActionContext.getRequest().getSession().getAttribute("user");
	int id = user.getId();
	List<TeacherScore> tsListStu = teacherScoreService.findByStuId(id);
	if (tsListStu.size() > 0) {
	    ActionContext.getContext().getValueStack().set("tsListStu", tsListStu);
	}
	return "findAllByStuId";
    }

    public String showAvg() {
	List<Object[]> avgList = teacherScoreService.showAvgScore();
	ActionContext.getContext().getValueStack().set("avgList", avgList);
	return "showAvg";
    }

    public String tchIndex() {
	Student user = (Student) ServletActionContext.getRequest().getSession().getAttribute("user");
	int id = user.getId();
	List<TeacherScore> tsListStu = teacherScoreService.findByStuId(id);
	if (tsListStu != null && tsListStu.size() > 0) {
	    ActionContext.getContext().getValueStack().set("tsListStu", tsListStu);
	    return "findAllByStuId";
	} else {
	    List<Teacher> tList = teacherScoreService.findAllTeacher();
	    ActionContext.getContext().getValueStack().set("tList", tList);
	    List<TeacherScore> tsList = teacherScoreService.findAll();
	    ActionContext.getContext().getValueStack().set("tsList", tsList);
	    return "findAll";
	}
    }

    public String save() {
	if (tsList.size() > 0) {
	    for (TeacherScore ts : tsList) {
		teacherScoreService.save(ts);
	    }
	}
	return "saveSuccess";
    }

}
