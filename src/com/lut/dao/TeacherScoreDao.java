package com.lut.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lut.vo.TeacherScore;
import com.lut.vo.liuyan.Liuyan;

public class TeacherScoreDao extends HibernateDaoSupport {

    public List<TeacherScore> findAll() {
	String hql = "from TeacherScore";
	List<TeacherScore> list = this.getHibernateTemplate().find(hql);
	if (list != null && list.size() > 0) {
	    return list;
	}
	return null;
    }

    public List<TeacherScore> findByStuId(Integer id) {
	String hql = "from TeacherScore ts where ts.student.id=?";
	List<TeacherScore> list = this.getHibernateTemplate().find(hql, id);
	if (list != null && list.size() > 0) {
	    return list;
	}
	return null;
    }
    
    public List<Object[]> showAvgScore() {
	String hql = "select ts.teacher.name,AVG(ts.score) from TeacherScore ts GROUP BY ts.teacher.name";
	List<Object[]> list = this.getHibernateTemplate().find(hql);
	if (list != null && list.size() > 0) {
	    return list;
	}
	return null;
    }

    public void save(TeacherScore ts) {
	this.getHibernateTemplate().save(ts);
    }
}
