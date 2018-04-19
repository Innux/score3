package com.lut.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lut.vo.Academy;
import com.lut.vo.Clazz;
import com.lut.vo.Major;

public class AcademyDao extends HibernateDaoSupport {

    public List<Academy> findAllAcademy() {
	String hql = "from Academy";
	List<Academy> academys = this.getHibernateTemplate().find(hql);
	return academys;
    }

    public List<Major> findMajorByAcademyId(Integer mid) {
	String hql = "from Major where a_id=?";
	List<Major> majors = this.getHibernateTemplate().find(hql, mid);
	if (majors.size() != 0) {
	    return majors;
	} else {
	    return null;
	}
    }

    public List<Clazz> findClassByMajorId(Integer classId) {
	String hql = "from Clazz where m_id=?";
	List<Clazz> clazzs = this.getHibernateTemplate().find(hql,classId);
	if (clazzs.size() != 0) {
	    return clazzs;
	} else {
	    return null;
	}
    }
}
