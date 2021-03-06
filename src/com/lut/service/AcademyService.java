package com.lut.service;

import java.util.List;

import com.lut.dao.AcademyDao;
import com.lut.vo.Academy;

public class AcademyService {

    private AcademyDao academyDao;

    public void setAcademyDao(AcademyDao academyDao) {
	this.academyDao = academyDao;
    }
    
    public List<Academy> findAll() {
	return academyDao.findAll();
    }

}
