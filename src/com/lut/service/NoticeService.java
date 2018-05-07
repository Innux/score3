package com.lut.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lut.dao.NoticeDao;
import com.lut.utils.PageBean;
import com.lut.vo.Notice;
import com.lut.vo.Student;
import com.lut.vo.Notice;

@Transactional
public class NoticeService {
    private NoticeDao noticeDao;

    public void setNoticeDao(NoticeDao noticeDao) {
	this.noticeDao = noticeDao;
    }

    public PageBean<Notice> findByPage(Integer page) {
	PageBean<Notice> pageBean = new PageBean<Notice>();
	pageBean.setPage(page);
	int limit = 5;
	pageBean.setLimit(limit);
	int totalCount = 0;
	totalCount = noticeDao.findCount();
	pageBean.setTotalCount(totalCount);
	int totalPage = 0;
	if (totalCount % limit == 0) {
	    totalPage = totalCount / limit;
	} else {
	    totalPage = totalCount / limit + 1;
	}
	pageBean.setTotalPage(totalPage);
	int begin = (page - 1) * limit;
	List<Notice> list = noticeDao.findByPage(begin, limit);
	pageBean.setList(list);
	return pageBean;
    }

    public void save(Notice notice) {
	noticeDao.save(notice);
    }

    public void delete(Notice notice) {
	noticeDao.delete(notice);
    }

    public void update(Notice notice) {
	noticeDao.update(notice);
    }

    public Notice findById(Integer id) {
	return noticeDao.findById(id);
    }

}
