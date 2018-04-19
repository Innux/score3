package com.lut.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.lut.service.ScoreService;
import com.lut.utils.JsonUtils;
import com.lut.utils.PageBean;
import com.lut.vo.scoreNcourse.Score;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ScoreAction extends ActionSupport implements ModelDriven<Score> {

    private Score score = new Score();
    HttpServletResponse response = ServletActionContext.getResponse();
    HttpServletRequest request = ServletActionContext.getRequest();

    @Override
    public Score getModel() {
	return score;
    }

    private ScoreService scoreService;

    // page参数
    private Integer page;
    private List<Score> scores;

    public String findAll() {
	PageBean<Score> pageBean = scoreService.findByPage(page);
	// 将PageBean数据存入到值栈中.
	ActionContext.getContext().getValueStack().set("pageBean", pageBean);
	// 页面跳转
	return "findAll";
    }

    public String findAllJson() throws IOException {
	String sYear = request.getParameter("sYear");
	String sHalf = request.getParameter("sHalf");
	// 设置搜索模型
	Score searchModel = new Score();
	searchModel.setS_year(sYear);
	searchModel.setS_half(Integer.parseInt(sHalf));

	PageBean<Score> pageBean = scoreService.findByPage(searchModel, page);
	// 将PageBean数据存入到值栈中.
	ActionContext.getContext().getValueStack().set("pageBean", pageBean);
	response.setContentType("text/html;charset=UTF-8");
	String result = JsonUtils.toJson(pageBean);
	System.out.println(result);
	ActionContext.getContext().put("pageBean", pageBean);
	PrintWriter out = response.getWriter();
	out.print(result);
	out.flush();
	out.close();
	return NONE;
    }

    public String delete() {
	// 根据id查询商品信息
	score = scoreService.findByScoreId(score.getS_id());
	// 删除数据库中商品记录:
	scoreService.delete(score);
	// 页面跳转
	return "deleteSuccess";
    }

    public Score getScore() {
	return score;
    }

    public void setScore(Score score) {
	this.score = score;
    }

    public Integer getPage() {
	return page;
    }

    public void setPage(Integer page) {
	this.page = page;
    }

    public List<Score> getScores() {
	return scores;
    }

    public void setScores(List<Score> scores) {
	this.scores = scores;
    }

    public ScoreService getScoreService() {
	return scoreService;
    }

    public void setScoreService(ScoreService scoreService) {
	this.scoreService = scoreService;
    }

}
