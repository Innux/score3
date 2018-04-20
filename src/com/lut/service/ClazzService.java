package com.lut.service;

import java.util.List;

import com.lut.dao.ClazzDao;
import com.lut.vo.Clazz;

public class ClazzService {

    private ClazzDao clazzDao;

    public void setClazzDao(ClazzDao clazzDao) {
        this.clazzDao = clazzDao;
    }
    
    public List<Clazz> findByMajorId(Integer majorId) {
	return clazzDao.findByMajorId(majorId);
    }
}
