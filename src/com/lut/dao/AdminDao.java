package com.lut.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lut.vo.Admin;

public class AdminDao extends HibernateDaoSupport {

    public Admin login(Admin admin) {

	// TODO Auto-generated method stub
	String hql = "from Admin where name=? and pwd=?";
	List<Admin> list = this.getHibernateTemplate()
		.find(hql, admin.getName(), admin.getPwd());
	if (list != null && list.size() > 0) {
	    return list.get(0);
	}

	return null;

    }

}
