package com.lut.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.lut.service.StudentService;
import com.lut.utils.PageBean;
import com.lut.vo.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StudentAction extends ActionSupport implements ModelDriven<Student> {

    private Student student = new Student();

    @Override
    public Student getModel() {
	return student;
    }

    private StudentService studentService;
    // page参数
    private Integer page;
    private List<Student> students;
//    private PageBean<Student> pageBean;

    public String findAll() {
	PageBean<Student> pageBean = studentService.findByPage(page);
	// 将PageBean数据存入到值栈中.
	ActionContext.getContext().getValueStack().set("pageBean", pageBean);
	// 页面跳转
	return "findAll";
    }


    public String list() {
	students = studentService.list();
	return "list";
    }

    // Ajax使用
    public String findByStuLoginName() throws IOException {
	// 调用service进行查询
	Student existStu = studentService.findByStuLoginName(student.getLoginName());
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=UTF-8");
	if (existStu != null) {
	    response.getWriter().println("<font color='red'>用户ID已存在</font>");
	} else {
	    response.getWriter().println("<font color='green'>用户ID可以使用</font>");
	}
	return NONE;
    }

    public Student getStudent() {
	return student;
    }

    public void setStudent(Student student) {
	this.student = student;
    }

    public StudentService getStudentService() {
	return studentService;
    }

    public void setStudentService(StudentService studentService) {
	this.studentService = studentService;
    }

    public Integer getPage() {
	return page;
    }

    public void setPage(Integer page) {
	this.page = page;
    }

    public List<Student> getStudents() {
	return students;
    }

    public void setStudents(List<Student> students) {
	this.students = students;
    }

}
