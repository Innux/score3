package com.lut.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.lut.dao.ScoreDao;
import com.lut.utils.PageBean;
import com.lut.vo.scoreNcourse.Score;

@Transactional
public class ScoreService {

    private ScoreDao scoreDao;

    public void setScoreDao(ScoreDao scoreDao) {
	this.scoreDao = scoreDao;
    }

    public PageBean<Score> findByPage(Integer page) {
	PageBean<Score> pageBean = new PageBean<Score>();
	// 设置当前页数:
	pageBean.setPage(page);
	// 设置每页显示记录数:
	int limit = 5;
	pageBean.setLimit(limit);
	// 设置总记录数:
	int totalCount = 0;
	totalCount = scoreDao.findCount();
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
	List<Score> list = scoreDao.findByPage(begin, limit);
	pageBean.setList(list);
	return pageBean;
    }

    public Score findByScoreId(Integer s_id) {
	return scoreDao.findByScoreId(s_id);
    }

    public void delete(Score score) {
	scoreDao.delete(score);
    }

    public PageBean<Score> findByPage(Score searchModel, Integer page) {
	PageBean<Score> pageBean = new PageBean<Score>();

	// 设置当前页数:
	pageBean.setPage(page);
	// 设置每页显示记录数:
	int limit = 5;
	pageBean.setLimit(limit);
	int begin = (page - 1) * limit;
	int totalCount = 0;
	Map<String,List<?>> map = scoreDao.findByPage(searchModel, begin, limit);
	List<Long> countList = (List<Long>) map.get("countList");
	totalCount = countList.get(0).intValue();
//	totalCount = scoreDao.findCount();
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
	List<Score> scoreList = (List<Score>) map.get("scoreList");
	pageBean.setList(scoreList);
	return pageBean;
    }

}
