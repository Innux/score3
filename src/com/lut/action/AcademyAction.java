package com.lut.action;

import com.lut.service.AcademyService;
import com.lut.vo.Academy;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AcademyAction extends ActionSupport implements ModelDriven<Academy> {

    private Academy academy = new Academy();
    @Override
    public Academy getModel() {
	return academy;
    }

    private AcademyService academyService;
    public void setAcademyService(AcademyService academyService) {
	this.academyService = academyService;
    }

}
