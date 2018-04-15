package com.lut.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lut.dao.StudentDao;
import com.lut.utils.PageBean;
import com.lut.vo.Student;

@Transactional
public class StudentService {

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
	this.studentDao = studentDao;
    }

    public PageBean<Student> findByPage(Integer page) {
	PageBean<Student> pageBean = new PageBean<Student>();
	// 设置当前页数:
	pageBean.setPage(page);
	// 设置每页显示记录数:
	int limit = 5;
	pageBean.setLimit(limit);
	// 设置总记录数:
	int totalCount = 0;
	totalCount = studentDao.findCount();
	pageBean.setTotalCount(totalCount);
	// 设置总页数:
	int totalPage = 0;
	if (totalCount % limit == 0) {
	    totalPage = totalCount / limit;
	} else {
	    totalPage = totalCount / limit + 1;
	}
	pageBean.setTotalPage(totalPage);
	// 每页显示的数据集合:
	// 从哪开始:
	int begin = (page - 1) * limit;
	List<Student> list = studentDao.findByPage(begin, limit);
	pageBean.setList(list);
	return pageBean;
    }

    public List<Student> list() {
	List<Student> students = studentDao.list();
	return students;
    }

    //Ajax
    public Student findByStuLoginName(String loginName) {
	return studentDao.findByStuLoginName(loginName);
    }

}
