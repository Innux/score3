package com.lut.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.lut.service.PrizeService;
import com.lut.utils.PageBean;
import com.lut.vo.Major;
import com.lut.vo.Student;
import com.lut.vo.dztNprize.Dzt;
import com.lut.vo.dztNprize.Prize;
import com.lut.vo.dztNprize.Rule;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PrizeAction extends ActionSupport implements ModelDriven<Prize> {

    HttpServletResponse response = ServletActionContext.getResponse();
    HttpServletRequest request = ServletActionContext.getRequest();

    Prize prize = new Prize();

    @Override
    public Prize getModel() {
	return prize;
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

    // 只展现数据 不刷新
    public String findBySearchModel() {

	Prize searchModel = new Prize();
	Rule rule = null;

	String pYear = request.getParameter("pYear");
	if (pYear != null && !"".equals(pYear.trim())) {
	    rule = new Rule();
	    rule.setYear(pYear);
	    searchModel.setRule(rule);
	}

	PageBean<Prize> pageBean = prizeService.findBySearchModel(searchModel, page);
	ActionContext.getContext().getValueStack().set("pageBean", pageBean);
	ActionContext.getContext().getValueStack().set("searchModel", searchModel);

	return "findSuccess";
    }

    // 刷新按钮 1.清空原表数据 2.根据新规则插入数据 3.展现数据
    public String refresh() {

	// 1.清空原表数据
	prizeService.clearTable();
	// 2.根据新规则插入数据
	prizeService.refreshTable();
	// 3.展现数据
	Prize searchModel = new Prize();
	PageBean<Prize> pageBean = prizeService.findBySearchModel(searchModel, page);
	ActionContext.getContext().getValueStack().set("pageBean", pageBean);

	return "refreshSuccess";
    }
}
