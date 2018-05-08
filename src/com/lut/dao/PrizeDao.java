package com.lut.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lut.utils.PageHibernateCallback;
import com.lut.vo.Student;
import com.lut.vo.dztNprize.Dzt;
import com.lut.vo.dztNprize.Prize;
import com.lut.vo.dztNprize.Rule;

public class PrizeDao extends HibernateDaoSupport {

    // 清空表数据
    public void clearTable() {
	Session session = this.getHibernateTemplate().getSessionFactory().openSession();
	String hql = "delete Prize where 1=1";
	Transaction t = null;
	try {
	    t = session.beginTransaction();
	    Query q = session.createQuery(hql);
	    q.executeUpdate();
	    t.commit();
	} catch (Exception ex) {
	    if (t != null) {
		t.rollback();
	    }
	} finally {
	    session.close();
	}
    }

    public void save(Prize prize) {
	this.getHibernateTemplate().save(prize);
    }

    public Map<String, List<?>> findBySearchModel(Prize searchModel, int begin, int limit) {
	StringBuffer hql = new StringBuffer("from Prize p where 1=1 ");
	StringBuffer countHql = new StringBuffer("select count(*) from Prize p where 1=1");

	if (searchModel.getRule() != null) {
	    String year =searchModel.getRule().getYear();
	    if (year != null && !year.equals("")) {
		hql.append(" and p.rule.year=" + year);
		countHql.append(" and p.rule.year=" + year);
	    }
	}
	hql.append(" order by p.rule.year desc,p.rule.level");

	List<Long> countList = null;

	countList = this.getHibernateTemplate().find(countHql.toString());

	List<Prize> prizeList = null;
	prizeList = this.getHibernateTemplate()
		.execute(new PageHibernateCallback<Prize>(hql.toString(), new Object[] {}, begin, limit));

	Map<String, List<?>> map = new HashMap<>();
	map.put("countList", countList);
	map.put("prizeList", prizeList);
	return map;
    }

    public List<Prize> findByStuId(int id) {
	String hql = "from Prize where stu_id=?";
	List<Prize> list = this.getHibernateTemplate().find(hql,id);
	if (list != null && list.size() > 0) {
	    return list;
	}
	return null;
    }

}
