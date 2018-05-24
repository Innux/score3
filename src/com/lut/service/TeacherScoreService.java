package com.lut.service;

import java.util.List;

import com.lut.dao.TeacherDao;
import com.lut.dao.TeacherScoreDao;
import com.lut.vo.Teacher;
import com.lut.vo.TeacherScore;

public class TeacherScoreService {

    private TeacherScoreDao teacherScoreDao;

    public void setTeacherScoreDao(TeacherScoreDao teacherScoreDao) {
	this.teacherScoreDao = teacherScoreDao;
    }

    private TeacherDao teacherDao;

    public void setTeacherDao(TeacherDao teacherDao) {
	this.teacherDao = teacherDao;
    }

    public void save(TeacherScore ts) {
	teacherScoreDao.save(ts);
    }

    public List<TeacherScore> findByStuId(Integer id) {
	return teacherScoreDao.findByStuId(id);
    }

    public List<Object[]> showAvgScore() {
	return teacherScoreDao.showAvgScore();
    }

    public List<TeacherScore> findAll() {
	return teacherScoreDao.findAll();
    }

    public List<Teacher> findAllTeacher() {
	return teacherDao.findAll();
    }
}
