package com.lut.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.lut.service.PrizeService;
import com.lut.service.RuleService;
import com.lut.utils.PageBean;
import com.lut.vo.dztNprize.Rule;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RuleAction extends ActionSupport implements ModelDriven<Rule> {
    HttpServletResponse response = ServletActionContext.getResponse();
    HttpServletRequest request = ServletActionContext.getRequest();

    Rule rule = new Rule();

    @Override
    public Rule getModel() {
	return rule;
    }

    private RuleService ruleService;

    public void setRuleService(RuleService ruleService) {
	this.ruleService = ruleService;
    }
    
    private PrizeService prizeService;
    
    public void setPrizeService(PrizeService prizeService) {
        this.prizeService = prizeService;
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
	PageBean<Rule> pageBean = ruleService.findByPage(page);
	// 将PageBean数据存入到值栈中.
	ActionContext.getContext().getValueStack().set("pageBean", pageBean);
	// 页面跳转
	return "findAll";
    }

    public String addRule() {
	return "addSuccess";
    }

    public String delete() {
	prizeService.clearTable();
	rule = ruleService.findById(rule.getId());
	ruleService.delete(rule);
	// 页面跳转
	return "deleteSuccess";
    }

    public String edit() {
	rule = ruleService.findById(rule.getId());
	return "editSuccess";
    }

    public String update() {
	ruleService.update(rule);
	// 页面跳转:
	return "updateSuccess";
    }

    public String save() {
	ruleService.save(rule);
	return "saveSuccess";
    }

}
