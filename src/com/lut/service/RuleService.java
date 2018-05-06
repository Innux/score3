package com.lut.service;

import java.util.List;

import com.lut.dao.RuleDao;
import com.lut.utils.PageBean;
import com.lut.vo.dztNprize.Rule;

public class RuleService {

    private RuleDao ruleDao;

    public void setRuleDao(RuleDao ruleDao) {
	this.ruleDao = ruleDao;
    }

    public PageBean<Rule> findByPage(Integer page) {
	PageBean<Rule> pageBean = new PageBean<Rule>();
	// 设置当前页数:
	pageBean.setPage(page);
	// 设置每页显示记录数:
	int limit = 10;
	pageBean.setLimit(limit);
	// 设置总记录数:
	int totalCount = 0;
	totalCount = ruleDao.findCount();
	pageBean.setTotalCount(totalCount);
	// 设置总页数:
	int totalPage = 0;
	if (totalCount % limit == 0) {
	    totalPage = totalCount / limit;
	} else {
	    totalPage = totalCount / limit + 1;
	}
	pageBean.setTotalPage(totalPage);
	// 每页显示的数据集合:
	// 从哪开始:
	int begin = (page - 1) * limit;
	List<Rule> list = ruleDao.findByPage(begin, limit);
	pageBean.setList(list);
	return pageBean;
    }

    public Rule findById(Integer id) {
	return ruleDao.findById(id);
    }

    public void delete(Rule rule) {
	ruleDao.delete(rule);
    }

    public void update(Rule rule) {
	ruleDao.update(rule);
    }

    public void save(Rule rule) {
	ruleDao.save(rule);	
    }

}
