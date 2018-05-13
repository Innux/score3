package com.lut.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lut.utils.PageHibernateCallback;
import com.lut.vo.Clazz;
import com.lut.vo.Major;
import com.lut.vo.Student;
import com.lut.vo.scoreNcourse.Score;

public class ScoreDao extends HibernateDaoSupport {

    /*
     * Session session =
     * this.getHibernateTemplate().getSessionFactory().openSession(); String hql
     * = "from Dzt d where 1=1 and d.year=? order by d.avg desc"; Query query =
     * session.createQuery(hql);
     * 
     * List user = query.list();
     */

    public List<Object[]> findByStuId(int id) {
	String hql = "select s.s_year,s.s_half,AVG(s.s_score) from Score s where s.student.id=? GROUP BY s.s_year,s.s_half order by s.s_year desc,s.s_half";
	List<Object[]> list = this.getHibernateTemplate().find(hql, id);
	if (list != null && list.size() > 0) {
	    return list;
	}
	return null;
    }

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
    
    public Map<String, List<?>> stuFindByPage(Integer stuId, Score searchModel, int begin, int limit) {
	StringBuffer hql = new StringBuffer("from Score s where s.student.id="+stuId);
	StringBuffer countHql = new StringBuffer("select count(*) from Score s where s.student.id="+stuId);

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

	List<Long> countList = null;

	countList = this.getHibernateTemplate().find(countHql.toString());

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

    public List<Score> findAll() {
	String hql = "from Score";
	List<Score> list = this.getHibernateTemplate().find(hql);
	if (list != null && list.size() > 0) {
	    return list;
	}
	return null;
    }

    public void save(Score score) {
	this.getHibernateTemplate().save(score);
    }

  

}
