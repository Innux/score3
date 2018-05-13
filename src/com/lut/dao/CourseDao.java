package com.lut.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lut.vo.scoreNcourse.Course;

public class CourseDao extends HibernateDaoSupport{
    
    public Course findByName(String name) {
	String hql = "from Course c where c.c_name=?";
	List<Course> list = this.getHibernateTemplate().find(hql,name);
	if (list != null && list.size() > 0) {
	    return list.get(0);
	}
	return null;
    }
}
