package com.lut.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lut.utils.PageHibernateCallback;
import com.lut.vo.scoreNcourse.Score;

public class ScoreDao extends HibernateDaoSupport{

    public int findCount() {
	String hql = "select count(*) from Score";
	List<Long> list = this.getHibernateTemplate().find(hql);
	if (list != null && list.size() > 0) {
	    return list.get(0).intValue();
	}
	return 0;
    }
    
    public List<Score> findByPage(int begin, int limit) {
	String hql = "from Score";
	List<Score> list = this.getHibernateTemplate()
		.execute(new PageHibernateCallback<Score>(hql, null, begin, limit));
	if (list != null && list.size() > 0) {
	    return list;
	}
	return null;
    }

}
