package com.lut.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.lut.dao.LiuyanDao;
import com.lut.dao.ReplyDao;
import com.lut.utils.PageBean;
import com.lut.vo.liuyan.Liuyan;

@Transactional
public class LiuyanService {

    private LiuyanDao liuyanDao;

    public void setLiuyanDao(LiuyanDao liuyanDao) {
	this.liuyanDao = liuyanDao;
    }

    private ReplyDao replyDao;

    public void setReplyDao(ReplyDao replyDao) {
	this.replyDao = replyDao;
    }

    public PageBean<Liuyan> findByPage(Integer page) {
	PageBean<Liuyan> pageBean = new PageBean<Liuyan>();
	pageBean.setPage(page);
	int limit = 10;
	pageBean.setLimit(limit);
	int totalCount = 0;
	totalCount = liuyanDao.findCount();
	pageBean.setTotalCount(totalCount);
	int totalPage = 0;
	if (totalCount % limit == 0) {
	    totalPage = totalCount / limit;
	} else {
	    totalPage = totalCount / limit + 1;
	}
	pageBean.setTotalPage(totalPage);
	int begin = (page - 1) * limit;
	List<Liuyan> list = liuyanDao.findByPage(begin, limit);
	pageBean.setList(list);
	return pageBean;
    }

    public void save(Liuyan liuyan) {
	liuyanDao.save(liuyan);
     }

     public void delete(Liuyan liuyan) {
	 liuyanDao.delete(liuyan);
     }

     public Liuyan findById(Integer id) {
 	return liuyanDao.findById(id);
     }

}
