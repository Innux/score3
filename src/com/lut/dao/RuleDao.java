package com.lut.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lut.utils.PageHibernateCallback;
import com.lut.vo.Student;
import com.lut.vo.dztNprize.Rule;
import com.lut.vo.scoreNcourse.Score;

public class RuleDao extends HibernateDaoSupport {

    // 获得xx学年xx奖学金人数
    public Rule findLimit(String year, String level) {
	String hql = "from Rule rul where rul.year=? and rul.level=?";
	List<Rule> list = this.getHibernateTemplate().find(hql, year, level);

	if (list != null && list.size() > 0) {
	    return list.get(0);
	}
	return null;
    }

    public List<Rule> findAll() {
	String hql = "from Rule";
	List<Rule> list = this.getHibernateTemplate().find(hql);
	if (list != null && list.size() > 0) {
	    return list;
	}
	return null;
    }

    public int findCount() {
	String hql = "select count(*) from Rule";
	List<Long> list = this.getHibernateTemplate().find(hql);
	if (list != null && list.size() > 0) {
	    return list.get(0).intValue();
	}
	return 0;
    }

    public List<Rule> findByPage(int begin, int limit) {
	String hql = "from Rule r where 1=1 order by r.year desc";
	List<Rule> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Rule>(hql, null, begin, limit));
	if (list != null && list.size() > 0) {
	    return list;
	}
	return null;
    }

    public Rule findById(Integer id) {
	return this.getHibernateTemplate().get(Rule.class, id);
    }

    public void delete(Rule rule) {
	this.getHibernateTemplate().delete(rule);
    }

    public void update(Rule rule) {
	this.getHibernateTemplate().update(rule);
    }

    public void save(Rule rule) {
	this.getHibernateTemplate().save(rule);
    }
}
