package com.lut.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lut.vo.Clazz;

public class ClazzDao extends HibernateDaoSupport{

    public List<Clazz> findByMajorId(Integer majorId) {
  	String hql = "from Clazz where m_id=?";
  	List<Clazz> list = this.getHibernateTemplate().find(hql, majorId);
  	if (list != null && list.size() > 0) {
  	    return list;
  	}
  	return null;
      }

    public List<Clazz> findAll() {
	String hql = "from Clazz";
  	List<Clazz> list = this.getHibernateTemplate().find(hql);
  	if (list != null && list.size() > 0) {
  	    return list;
  	}
  	return null;
    }
}
