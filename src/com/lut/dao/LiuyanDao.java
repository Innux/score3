package com.lut.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lut.utils.PageHibernateCallback;
import com.lut.vo.liuyan.Liuyan;

public class LiuyanDao extends HibernateDaoSupport {

    public int findCount() {
	String hql = "select count(*) from Liuyan";
	List<Long> list = this.getHibernateTemplate().find(hql);
	if (list != null && list.size() > 0) {
	    return list.get(0).intValue();
	}
	return 0;
    }

    public List<Liuyan> findByPage(int begin, int limit) {
	String hql = "from Liuyan order by id desc";
	List<Liuyan> list = this.getHibernateTemplate()
		.execute(new PageHibernateCallback<Liuyan>(hql, null, begin, limit));
	if (list != null && list.size() > 0) {
	    return list;
	}
	return null;
    }

    public List<Liuyan> findAll() {
	String hql = "from Liuyan";
	List<Liuyan> list = this.getHibernateTemplate().find(hql);
	if (list != null && list.size() > 0) {
	    return list;
	}
	return null;
    }
    
    public void save(Liuyan liuyan) {
	this.getHibernateTemplate().save(liuyan);
    }

    public void delete(Liuyan liuyan) {
	this.getHibernateTemplate().delete(liuyan);
    }

    public Liuyan findById(Integer id) {
	return this.getHibernateTemplate().get(Liuyan.class, id);
    }

}
