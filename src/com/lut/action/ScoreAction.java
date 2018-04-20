package com.lut.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.lut.service.ScoreService;
import com.lut.utils.PageBean;
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
	// 页面跳转
	return "findAll";
    }

    public String delete() {
	// 根据id查询商品信息
	score = scoreService.findByScoreId(score.getS_id());
	// 删除数据库中商品记录:
	scoreService.delete(score);
	// 页面跳转
	return "deleteSuccess";
    }

}
