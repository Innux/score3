package com.lut.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lut.utils.PageHibernateCallback;
import com.lut.vo.Student;

public class StudentDao extends HibernateDaoSupport {

    public int findCount() {
	String hql = "select count(*) from Student";
	List<Long> list = this.getHibernateTemplate().find(hql);
	if (list != null && list.size() > 0) {
	    return list.get(0).intValue();
	}
	return 0;
    }

    public List<Student> findByPage(int begin, int limit) {
	String hql = "from Student";
	List<Student> list = this.getHibernateTemplate()
		.execute(new PageHibernateCallback<Student>(hql, null, begin, limit));
	if (list != null && list.size() > 0) {
	    return list;
	}
	return null;
    }

    public List<Student> list() {
	String hql = "from Student";
	List<Student> list = this.getHibernateTemplate().find(hql);
	return list;
    }

    // ajax
    public Student findByStuLoginName(String loginName) {
	String hql = "from Student where loginName=?";
	List<Student> list = this.getHibernateTemplate().find(hql, loginName);
	if (list != null && list.size() > 0) {
	    return list.get(0);
	}
	return null;

    }

}
