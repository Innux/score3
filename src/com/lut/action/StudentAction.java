package com.lut.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.lut.service.AcademyService;
import com.lut.service.ClazzService;
import com.lut.service.MajorService;
import com.lut.service.StudentService;
import com.lut.utils.JsonUtils;
import com.lut.utils.PageBean;
import com.lut.vo.Academy;
import com.lut.vo.Clazz;
import com.lut.vo.Major;
import com.lut.vo.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StudentAction extends ActionSupport implements ModelDriven<Student> {
    HttpServletResponse response = ServletActionContext.getResponse();
    HttpServletRequest request = ServletActionContext.getRequest();

    private Student student = new Student();

    @Override
    public Student getModel() {
	return student;
    }

    // 注入student的service
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
	this.studentService = studentService;
    }

    // 注入academy的service
    private AcademyService academyService;

    public void setAcademyService(AcademyService academyService) {
	this.academyService = academyService;
    }

    // 注入major的service
    private MajorService majorService;

    public void setMajorService(MajorService majorService) {
	this.majorService = majorService;
    }

    // 注入clazz的service
    private ClazzService clazzService;

    public void setClazzService(ClazzService clazzService) {
	this.clazzService = clazzService;
    }

    // 接收专业id
    private Integer majorId;

    public Integer getMajorId() {
	return majorId;
    }

    public void setMajorId(Integer majorId) {
	this.majorId = majorId;
    }

    // page参数
    private Integer page;

    public Integer getPage() {
	return page;
    }

    public void setPage(Integer page) {
	this.page = page;
    }

    // 登录
    public String login() {
	Student user = studentService.login(student);
	if (user != null) {
	    int type = user.getType();
	    if (type == 1) {
		return "loginSuccess_stu";
	    } else if(type == 2){
		return "loginSuccess_admin";
	    }
	}
	return "loginFailed";
    }

    // 跳转到添加学生的页面
    public String addPage() {
	List<Academy> academyList = academyService.findAll();
	ActionContext.getContext().getValueStack().set("academyList", academyList);
	return "addPageSuccess";
    }

    // ajax 根据选择的学院id查询专业
    public String findMajorByAcademyId() throws IOException {
	String aid = request.getParameter("aid").trim();
	System.out.println("============" + aid);
	List<Major> majorList = majorService.findByAcademyId(Integer.parseInt(aid));
	response.setContentType("text/html;charset=UTF-8");
	String result = JsonUtils.toJson(majorList);
	// 打印转化出来的json
	System.out.println(result);
	ActionContext.getContext().put("majorList", majorList);
	PrintWriter out = response.getWriter();
	out.print(result);
	out.flush();
	out.close();

	return NONE;
    }

    // ajax 根据选择的专业id查询班级
    public String findClazzByMajorId() throws IOException {
	String mid = request.getParameter("mid").trim();
	List<Clazz> clazzList = clazzService.findByMajorId(Integer.parseInt(mid));
	response.setContentType("text/html;charset=UTF-8");
	String result = JsonUtils.toJson(clazzList);
	// 打印转化出来的json
	System.out.println(result);
	ActionContext.getContext().put("clazzList", clazzList);
	PrintWriter out = response.getWriter();
	out.print(result);
	out.flush();
	out.close();

	return NONE;
    }

    // 添加学生
    public String save() {
	studentService.save(student);
	return "saveSuccess";
    }

    // 查询所有学生信息+筛选器专业信息初始化
    public String findAll() {
	PageBean<Student> pageBean = studentService.findByPage(page);
	// 将PageBean数据存入到值栈中.
	ActionContext.getContext().getValueStack().set("pageBean", pageBean);

	// List<Major> majorList = majorService.findAll();
	// ActionContext.getContext().getValueStack().set("majorList",
	// majorList);
	// 页面跳转
	return "findAll";
    }

    // 根据专业id查询学生
    public String findByMajorId() {
	// 根据二级分类查询商品
	PageBean<Student> pageBean = studentService.findByPageMajorId(majorId, page);
	// 将PageBean存入到值栈中:
	ActionContext.getContext().getValueStack().set("pageBean", pageBean);
	return "findByMajorId";
    }

    // ajax 根据专业id查询学生
    public String findByMajorIdAjax() throws IOException {
	String mid = request.getParameter("mid").trim();
	PageBean<Student> pageBean = studentService.findByPageMajorId(Integer.parseInt(mid), page);
	ActionContext.getContext().getValueStack().set("pageBean", pageBean);
	return "findSuccess";
    }

    // 删除学生
    public String delete() {
	// 根据id查询商品信息
	student = studentService.findByStuId(student.getId());
	studentService.delete(student);
	// 页面跳转
	return "deleteSuccess";
    }

    // Ajax检测用户名是否存在
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

    public String findByStuName() {
	String stuName = request.getParameter("name").trim();
	PageBean<Student> pageBean = studentService.findByStuName(stuName, page);
	ActionContext.getContext().getValueStack().set("pageBean", pageBean);
	System.out.println(pageBean.getList().get(0).getLoginName());
	return "findByStuName";
    }

}
