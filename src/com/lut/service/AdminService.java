package com.lut.service;

import org.springframework.transaction.annotation.Transactional;

import com.lut.dao.AdminDao;
import com.lut.vo.Admin;

@Transactional
public class AdminService {

    
    private AdminDao adminDao;
    
    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public Admin login(Admin admin) {
	return adminDao.login(admin);
    }

}
