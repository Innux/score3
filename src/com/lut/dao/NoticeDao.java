package com.lut.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lut.utils.PageHibernateCallback;
import com.lut.vo.Notice;
import com.lut.vo.Student;

public class NoticeDao extends HibernateDaoSupport {

    public int findCount() {
	String hql = "select count(*) from Notice";
	List<Long> list = this.getHibernateTemplate().find(hql);
	if (list != null && list.size() > 0) {
	    return list.get(0).intValue();
	}
	return 0;
    }

    public List<Notice> findByPage(int begin, int limit) {
	String hql = "from Notice order by time desc";
	List<Notice> list = this.getHibernateTemplate()
		.execute(new PageHibernateCallback<Notice>(hql, null, begin, limit));
	if (list != null && list.size() > 0) {
	    return list;
	}
	return null;
    }

    public void save(Notice notice) {
	this.getHibernateTemplate().save(notice);
    }

    public void delete(Notice notice) {
	this.getHibernateTemplate().delete(notice);
    }

    public void update(Notice student) {
	this.getHibernateTemplate().update(student);
    }

    public Notice findById(Integer id) {
	return this.getHibernateTemplate().get(Notice.class, id);
    }

}
