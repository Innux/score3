package com.lut.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public int findCountLimit() {
	String hql = "select count(*) from Score where 1=1 ";
	List<Long> list = this.getHibernateTemplate().find(hql);
	if (list != null && list.size() > 0) {
	    return list.get(0).intValue();
	}
	return 0;
    }

    public Map<String, List<?>> findByPage(Score searchModel, int begin, int limit) {
	String hql = "from Score where 1=1 ";
	String countHql = "select count(*) from Score where 1=1";

	Integer sHalf = searchModel.getS_half();
	String sHalfStr = sHalf.toString();
	if (sHalfStr != null && !sHalfStr.equals("")) {
	    hql = hql + " and s_half=" + sHalfStr;
	    countHql = countHql + " and s_half=" + sHalfStr;
	}
	System.out.println("===="+hql+"++++++"+countHql);

	List<Long> countList = null;

	countList = this.getHibernateTemplate().find(countHql);
	// list.get(0).intValue();

	List<Score> scoreList = null;
	scoreList = this.getHibernateTemplate()
		.execute(new PageHibernateCallback<Score>(hql.toString(), new Object[]{}, begin, limit));

	Map<String, List<?>> map = new HashMap<>();
	map.put("countList", countList);
	map.put("scoreList", scoreList);
	return map;
    }

    public Score findByScoreId(Integer s_id) {
	return this.getHibernateTemplate().get(Score.class, s_id);
    }

    public void delete(Score score) {
	this.getHibernateTemplate().delete(score);
    }

}
