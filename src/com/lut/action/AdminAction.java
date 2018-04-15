package com.lut.action;

import org.apache.struts2.ServletActionContext;

import com.lut.service.AdminService;
import com.lut.vo.Admin;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminAction extends ActionSupport implements ModelDriven<Admin> {

    private Admin admin = new Admin();

    @Override
    public Admin getModel() {
	return admin;
    }

    // 注入AdminService
    private AdminService adminService;

    public void setAdminService(AdminService adminService) {
	this.adminService = adminService;
    }

    public String login() {
	Admin existAdmin = adminService.login(admin);

	if (existAdmin == null) {
	    // 登陆失败
	    this.addActionError("登陆失败：用户名或密码错误用户未激活！");
	    return "loginFailed";
	} else {
	    // 登陆成功
	    // 将用户的信息存入session中
	    ServletActionContext.getRequest().getSession().setAttribute("existAdmin", existAdmin);
	    // 页面跳转
	    return "loginSuccess";
	}
    }
    
    
}
