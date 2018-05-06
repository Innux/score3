package com.lut.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.lut.dao.DztDao;
import com.lut.dao.PrizeDao;
import com.lut.dao.RuleDao;
import com.lut.utils.PageBean;
import com.lut.vo.Student;
import com.lut.vo.dztNprize.Dzt;
import com.lut.vo.dztNprize.Prize;
import com.lut.vo.dztNprize.Rule;

@Transactional
public class PrizeService {

    private PrizeDao prizeDao;

    public void setPrizeDao(PrizeDao prizeDao) {
	this.prizeDao = prizeDao;
    }

    private RuleDao ruleDao;

    public void setRuleDao(RuleDao ruleDao) {
	this.ruleDao = ruleDao;
    }

    private DztDao dztDao;

    public void setDztDao(DztDao dztDao) {
	this.dztDao = dztDao;
    }

    // 刷新表数据
    public void refreshTable() {
	List<Rule> ruleList = ruleDao.findAll();
	String year = null;
	String level = null;
	int start = 0;
	int end = 0;

	for (int i = 0; i < ruleList.size(); i++) {
	    year = ruleList.get(i).getYear();
	    level = ruleList.get(i).getLevel();

	    if ("三等奖".equals(level)) {
		start = ruleDao.findLimit(year, "一等奖").getStunum() + ruleDao.findLimit(year, "二等奖").getStunum();
		end = ruleDao.findLimit(year, "三等奖").getStunum();
	    } else if ("二等奖".equals(level)) {
		start = ruleDao.findLimit(year, "一等奖").getStunum();
		end = ruleDao.findLimit(year, level).getStunum();
	    } else {
		start = 0;
		end = ruleDao.findLimit(year, level).getStunum();
	    }

	    Rule rule = ruleDao.findLimit(year, level);
	    List<Dzt> dztList = dztDao.findByLimit(start, end, year);
	    for (int j = 0; j < dztList.size(); j++) {
		System.out.println(dztList.get(j).getStudent().getName()+"=================================="+rule.getLevel());
		Prize prize = new Prize();
		prize.setStudent(dztList.get(j).getStudent());
		prize.setRule(rule);
		prizeDao.save(prize);
	    }

	}

    }

    public PageBean<Prize> findBySearchModel(Prize searchModel, Integer page) {
	PageBean<Prize> pageBean = new PageBean<Prize>();
	pageBean.setPage(page);
	int limit = 10;
	pageBean.setLimit(limit);
	int begin = (page - 1) * limit;
	int totalCount = 0;
	Map<String, List<?>> map = prizeDao.findBySearchModel(searchModel, begin, limit);
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

	List<Prize> prizeList = (List<Prize>) map.get("prizeList");
	pageBean.setList(prizeList);
	return pageBean;
    }

    // 清空表内容
    public void clearTable() {
	prizeDao.clearTable();
    }

}
