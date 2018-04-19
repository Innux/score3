package com.lut.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lut.utils.PageHibernateCallback;
import com.lut.vo.scoreNcourse.Score;

public class ScoreDao extends HibernateDaoSupport {

    public int findCount() {
	String hql = "select count(*) from Score";
	List<Long> list = this.getHibernateTemplate().find(hql);
	if (list != null && list.size() > 0) {
	    return list.get(0).intValue();
	}
	return 0;
    }

    public List<Score> findByPage(int begin, int limit) {
	String hql = "from Score where 1=1";
	List<Score> list = this.getHibernateTemplate()
		.execute(new PageHibernateCallback<Score>(hql, null, begin, limit));
	if (list != null && list.size() > 0) {
	    return list;
	}
	return null;
    }
    
    public List<Score> findByPage(Score searchModel, int begin, int limit) {
	StringBuilder hql = new StringBuilder("from Score");
	String sYear = searchModel.getS_year();
	Integer sHalf = searchModel.getS_half();
	if(sYear != null && !sYear.equals("")) {
	    hql.append("and where s_year="+sYear);
	}
	if(sHalf != null && !sHalf.equals("")) {
	    hql.append(" and where s_half="+sHalf);
	}
	
	List<Score> list = this.getHibernateTemplate()
		.execute(new PageHibernateCallback<Score>(hql.toString(), null, begin, limit));
	if (list != null && list.size() > 0) {
	    return list;
	}
	return null;
    }

    public Score findByScoreId(Integer s_id) {
	return this.getHibernateTemplate().get(Score.class, s_id);
    }

    public void delete(Score score) {
	this.getHibernateTemplate().delete(score);
    }


}
