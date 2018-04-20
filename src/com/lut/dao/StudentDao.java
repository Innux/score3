package com.lut.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lut.utils.PageHibernateCallback;
import com.lut.vo.Student;

public class StudentDao extends HibernateDaoSupport {

    public int findCount() {
	String hql = "select count(*) from Student";
	List<Long> list = this.getHibernateTemplate().find(hql);
	if (list != null && list.size() > 0) {
	    return list.get(0).intValue();
	}
	return 0;
    }

    // 分页查询
    public List<Student> findByPage(int begin, int limit) {
	String hql = "from Student order by id desc";
	List<Student> list = this.getHibernateTemplate()
		.execute(new PageHibernateCallback<Student>(hql, null, begin, limit));
	if (list != null && list.size() > 0) {
	    return list;
	}
	return null;
    }
    
    public int findCountMajorId(Integer majorId) {
	String hql = "select count(*) from Student stu where stu.major.m_id = ?";
	List<Long> list = this.getHibernateTemplate().find(hql, majorId);
	if(list != null && list.size() > 0){
		return list.get(0).intValue();
	}
	return 0;
     }

    // 根据专业id查询学生信息
    public List<Student> findByPageMajorId(Integer mid, int begin, int limit) {
	String hql = "select stu from Student stu join stu.major maj where maj.m_id = ?";
	List<Student> list = this.getHibernateTemplate()
		.execute(new PageHibernateCallback<Student>(hql, new Object[] { mid }, begin, limit));
	if (list != null && list.size() > 0) {
	    return list;
	}
	return null;
    }

    // ajax
    public Student findByStuLoginName(String loginName) {
	String hql = "from Student where loginName=?";
	List<Student> list = this.getHibernateTemplate().find(hql, loginName);
	if (list != null && list.size() > 0) {
	    return list.get(0);
	}
	return null;

    }

    // 添加学生
    public void save(Student student) {
	this.getHibernateTemplate().save(student);
    }

    // 删除学生
    public void delete(Student student) {
	this.getHibernateTemplate().delete(student);
    }

    // 编辑学生信息
    public void update(Student student) {
	this.getHibernateTemplate().update(student);
    }

    // 根据学生id查询学生
    public Student findByStuId(Integer id) {
	return this.getHibernateTemplate().get(Student.class, id);
    }
    
 

}
