package com.lut.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lut.vo.Student;
import com.lut.vo.liuyan.Reply;

public class ReplyDao extends HibernateDaoSupport{

    public List<Reply> findByLiuyanId(Integer lyid) {
	String hql = "from Reply r where r.liuyan.id=?";
	List<Reply> list = this.getHibernateTemplate().find(hql, lyid);
	if (list != null && list.size() > 0) {
	    return list;
	}
	return null;
    }
    
    public void save(Reply reply) {
	this.getHibernateTemplate().save(reply);
    }

    public void delete(Reply reply) {
	this.getHibernateTemplate().delete(reply);
    }

    public Reply findById(Integer id) {
	return this.getHibernateTemplate().get(Reply.class, id);
    }
    
    

}
