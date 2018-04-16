package com.lut.service;

import java.util.List;

import com.lut.dao.AcademyDao;
import com.lut.vo.Academy;
import com.lut.vo.Major;

public class AcademyService {
    
    private AcademyDao academyDao;

    public void setAcademyDao(AcademyDao academyDao) {
        this.academyDao = academyDao;
    }

    public List<Academy> findAllAcademy() {
	List<Academy> academys = academyDao.findAllAcademy();
	return academys;
    }
    
    public List<Major> findMajorByAcademyId(Integer mid) {
	List<Major> majors = academyDao.findMajorByAcademyId(mid);
	return majors;
    }

}
