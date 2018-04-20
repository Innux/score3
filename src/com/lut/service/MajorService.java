package com.lut.service;

import java.util.List;

import com.lut.dao.MajorDao;
import com.lut.vo.Major;

public class MajorService {
    private MajorDao majorDao;

    public void setMajorDao(MajorDao majorDao) {
	this.majorDao = majorDao;
    }

    public Major findByMajorId(Integer majorId) {
	return majorDao.findByMajorId(majorId);
    }
    
    public List<Major> findByAcademyId(Integer academyId) {
	return majorDao.findByAcademyId(academyId);
    }

    public List<Major> findAll() {
	// TODO Auto-generated method stub
	return majorDao.findAll();
    }
}
