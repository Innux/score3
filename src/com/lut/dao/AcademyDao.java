package com.lut.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lut.vo.Academy;
import com.lut.vo.Clazz;
import com.lut.vo.Major;

public class AcademyDao extends HibernateDaoSupport {

    public List<Academy> findAll() {
	String hql = "from Academy";
	return this.getHibernateTemplate().find(hql);
    }
}
