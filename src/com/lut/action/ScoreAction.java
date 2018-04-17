package com.lut.action;

import java.util.List;

import com.lut.service.ScoreService;
import com.lut.utils.PageBean;
import com.lut.vo.Student;
import com.lut.vo.scoreNcourse.Score;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ScoreAction extends ActionSupport implements ModelDriven<Score>{

    private Score score = new Score();
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
