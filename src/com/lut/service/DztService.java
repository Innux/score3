package com.lut.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.lut.dao.DztDao;
import com.lut.dao.RuleDao;
import com.lut.utils.PageBean;
import com.lut.vo.dztNprize.Dzt;

@Transactional
public class DztService {

    private DztDao dztDao;

    public void setDztDao(DztDao dztDao) {
	this.dztDao = dztDao;
    }

    private RuleDao ruleDao;

    public void setRuleDao(RuleDao ruleDao) {
	this.ruleDao = ruleDao;
    }

    public PageBean<Dzt> findByPage(Dzt searchModel, Integer page) {
	PageBean<Dzt> pageBean = new PageBean<Dzt>();
	// 设置当前页数:
	pageBean.setPage(page);
	// 设置每页显示记录数:
	int limit = 5;
	pageBean.setLimit(limit);
	int begin = (page - 1) * limit;
	int totalCount = 0;
	Map<String, List<?>> map = dztDao.findByPage(searchModel, begin, limit);
	List<Long> countList = (List<Long>) map.get("countList");
	totalCount = countList.get(0).intValue();
	pageBean.setTotalCount(totalCount);
	// 设置总页数:
	int totalPage = 0;
	if (totalCount % limit == 0) {
	    totalPage = totalCount / limit;
	} else {
	    totalPage = totalCount / limit + 1;
	}
	pageBean.setTotalPage(totalPage);

	// List<Score> list = scoreDao.findByPage(begin, limit);
	List<Dzt> dztList = (List<Dzt>) map.get("dztList");
	pageBean.setList(dztList);
	return pageBean;
    }

    public PageBean<Dzt> findByPageOrder(Dzt searchModel, Integer page) {
	PageBean<Dzt> pageBean = new PageBean<Dzt>();
	pageBean.setPage(page);
	int limit = 5;
	pageBean.setLimit(limit);
	int begin = (page - 1) * limit;
	int totalCount = 0;
	Map<String, List<?>> map = dztDao.findByPageOrder(searchModel, begin, limit);
	List<Long> countList = (List<Long>) map.get("countList");
	totalCount = countList.get(0).intValue();
	pageBean.setTotalCount(totalCount);
	// 设置总页数:
	int totalPage = 0;
	if (totalCount % limit == 0) {
	    totalPage = totalCount / limit;
	} else {
	    totalPage = totalCount / limit + 1;
	}
	pageBean.setTotalPage(totalPage);

	// List<Score> list = scoreDao.findByPage(begin, limit);
	List<Dzt> dztList = (List<Dzt>) map.get("dztList");
	pageBean.setList(dztList);
	return pageBean;
    }

//    public List<Dzt> findLimit(String year, String level) {
//	int start = 0;
//	int end = 0;
//	if ("三等奖".equals(level)) {
//	    start = ruleDao.findStunum(year, "一等奖") + ruleDao.findStunum(year, "二等奖");
//	    end = ruleDao.findStunum(year, level) + start;
//	} else if ("二等奖".equals(level)) {
//	    start = ruleDao.findStunum(year, "一等奖");
//	    end = ruleDao.findStunum(year, level) + start;
//	} else {
//	    start = 0;
//	    end = ruleDao.findStunum(year, level);
//	}
//
//	List<Dzt> dztList = dztDao.findByLimit(start, end, year);
//	if (dztList != null) {
//	    return dztList;
//	}
//	return null;
//    }

}
