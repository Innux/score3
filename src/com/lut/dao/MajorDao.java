package com.lut.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lut.vo.Major;
import com.lut.vo.Student;

public class MajorDao extends HibernateDaoSupport{

    public Major findByMajorId(Integer majorId) {
	return this.getHibernateTemplate().get(Major.class, majorId);
    }

    public List<Major> findByAcademyId(Integer academyId) {
	String hql = "from Major where a_id=?";
	List<Major> list = this.getHibernateTemplate().find(hql, academyId);
	if (list != null && list.size() > 0) {
	    return list;
	}
	return null;
    }

    public List<Major> findAll() {
	String hql = "from Major";
	List<Major> list = this.getHibernateTemplate().find(hql);
	if (list != null && list.size() > 0) {
	    return list;
	}
	return null;
    }

}
