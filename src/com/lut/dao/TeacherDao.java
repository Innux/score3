package com.lut.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lut.vo.Teacher;

public class TeacherDao extends HibernateDaoSupport {

    public List<Teacher> findAll() {
	String hql = "from Teacher";
	return this.getHibernateTemplate().find(hql);
    }
}
