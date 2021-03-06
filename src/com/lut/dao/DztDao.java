package com.lut.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lut.utils.PageHibernateCallback;
import com.lut.vo.dztNprize.Dzt;

public class DztDao extends HibernateDaoSupport {

    public Map<String, List<?>> findByPage(Dzt searchModel, int begin, int limit) {
	StringBuffer hql = new StringBuffer("from Dzt d where 1=1 ");
	StringBuffer countHql = new StringBuffer("select count(*) from Dzt d where 1=1");

	String dYear = searchModel.getYear();
	if (dYear != null && !dYear.equals("")) {
	    hql.append(" and year=" + dYear);
	    countHql.append(" and year=" + dYear);
	}

	if (searchModel.getStudent() != null) {
	    Integer dMajor = searchModel.getStudent().getMajor().getM_id();
	    if (dMajor != null && !dMajor.equals("")) {
		hql.append(" and d.student.major.m_id=" + dMajor);
		countHql.append(" and d.student.major.m_id=" + dMajor);
	    }
	}

	List<Long> countList = null;

	countList = this.getHibernateTemplate().find(countHql.toString());
	// list.get(0).intValue();

	List<Dzt> dztList = null;
	dztList = this.getHibernateTemplate()
		.execute(new PageHibernateCallback<Dzt>(hql.toString(), new Object[] {}, begin, limit));

	Map<String, List<?>> map = new HashMap<>();
	map.put("countList", countList);
	map.put("dztList", dztList);
	return map;
    }

    public Map<String, List<?>> findByPageOrder(Dzt searchModel, int begin, int limit) {
	StringBuffer hql = new StringBuffer("from Dzt d where 1=1 ");
	StringBuffer countHql = new StringBuffer("select count(*) from Dzt d where 1=1");

	String dYear = searchModel.getYear();
	if (dYear != null && !dYear.equals("")) {
	    hql.append(" and year=" + dYear);
	    countHql.append(" and year=" + dYear);
	}

	if (searchModel.getStudent() != null) {
	    Integer dMajor = searchModel.getStudent().getMajor().getM_id();
	    if (dMajor != null && !dMajor.equals("")) {
		hql.append(" and d.student.major.m_id=" + dMajor);
		countHql.append(" and d.student.major.m_id=" + dMajor);
	    }
	}
	hql.append(" order by d.avg desc");

	List<Long> countList = null;

	countList = this.getHibernateTemplate().find(countHql.toString());

	List<Dzt> dztList = null;
	dztList = this.getHibernateTemplate()
		.execute(new PageHibernateCallback<Dzt>(hql.toString(), new Object[] {}, begin, limit));

	Map<String, List<?>> map = new HashMap<>();
	map.put("countList", countList);
	map.put("dztList", dztList);
	return map;
    }

    // 限制查询
    public List<Dzt> findByLimit(int start, int end, String year) {

	Session session = this.getHibernateTemplate().getSessionFactory().openSession();
	String hql = "from Dzt d where 1=1 and d.year=? order by d.avg desc";
	Query query = session.createQuery(hql);
	List<Dzt> list = query.setParameter(0, year).setFirstResult(start).setMaxResults(end).list();
	if (list != null) {
	    return list;
	}
	return null;
    }

}
