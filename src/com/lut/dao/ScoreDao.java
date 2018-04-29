package com.lut.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lut.utils.PageHibernateCallback;
import com.lut.vo.Clazz;
import com.lut.vo.Major;
import com.lut.vo.Student;
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
	StringBuffer hql = new StringBuffer("from Score s where 1=1 ");
	StringBuffer countHql = new StringBuffer("select count(*) from Score s where 1=1");

	String sYear = searchModel.getS_year();
	if (sYear != null && !sYear.equals("")) {
	    hql.append(" and s_year=" + sYear);
	    countHql.append(" and s_year=" + sYear);
	}

	Integer sHalf = searchModel.getS_half();
	if (sHalf != null && !sHalf.equals("")) {
	    hql.append("  and s_half=" + sHalf);
	    countHql.append(" and s_half=" + sHalf);
	}

	
	if (searchModel.getStudent() != null) {
	    Integer sMajor = searchModel.getStudent().getMajor().getM_id();
	    if (sMajor != null && !sMajor.equals("")) {
		hql.append(" and s.student.major.m_id=" + sMajor);
		countHql.append(" and s.student.major.m_id=" + sMajor);
	    }
	}

//	Clazz cla = searchModel.getStudent().getClazz();
//	if (cla != null) {
//	    Integer sClass = searchModel.getStudent().getClazz().getClass_id();
//	    if (sClass != null && !sClass.equals("")) {
//		hql.append(" and s.student.clazz.class_id=" + sClass);
//		countHql.append(" and s.student.clazz.class_id=" + sClass);
//	    }
//	}

	List<Long> countList = null;

	countList = this.getHibernateTemplate().find(countHql.toString());
	// list.get(0).intValue();

	List<Score> scoreList = null;
	scoreList = this.getHibernateTemplate()
		.execute(new PageHibernateCallback<Score>(hql.toString(), new Object[] {}, begin, limit));

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
