package com.lut.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.lut.dao.DztDao;
import com.lut.utils.PageBean;
import com.lut.vo.dztNprize.Dzt;
import com.lut.vo.scoreNcourse.Score;

@Transactional
public class DztService {

    private DztDao dztDao;

    public void setDztDao(DztDao dztDao) {
	this.dztDao = dztDao;
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
	Map<String,List<?>> map = dztDao.findByPage(searchModel, begin, limit);
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

}
