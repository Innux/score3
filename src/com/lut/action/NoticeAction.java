package com.lut.action;

import com.lut.service.NoticeService;
import com.lut.utils.PageBean;
import com.lut.vo.Notice;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class NoticeAction extends ActionSupport implements ModelDriven<Notice> {

    Notice notice = new Notice();

    @Override
    public Notice getModel() {
	return notice;
    }

    private NoticeService noticeService;

    public void setNoticeService(NoticeService noticeService) {
	this.noticeService = noticeService;
    }

    private Integer page;

    public Integer getPage() {
	return page;
    }

    public void setPage(Integer page) {
	this.page = page;
    }

    public String findByPage() {
	PageBean<Notice> pageBean = noticeService.findByPage(page);
	ActionContext.getContext().getValueStack().set("pageBean", pageBean);
	return "findSuccess";
    }
    //学生
    public String findByPage2() {
 	PageBean<Notice> pageBean = noticeService.findByPage(page);
 	ActionContext.getContext().getValueStack().set("pageBean", pageBean);
 	return "findSuccess2";
     }
    
    public String addPage() {
	return "addPage";
    }

    public String save() {
	noticeService.save(notice);
	return "saveSuccess";
    }

    public String delete() {
	notice = noticeService.findById(notice.getId());
	noticeService.delete(notice);
	return "deleteSuccess";
    }

    public String edit() {
	notice = noticeService.findById(notice.getId());
	// 完成页面转向:将数据显示到页面上.
	return "editSuccess";
    }

    // 展示详细内容
    public String showContent() {
	notice = noticeService.findById(notice.getId());
	// 完成页面转向:将数据显示到页面上.
	return "showSuccess";
    }

    public String update() {
	noticeService.update(notice);
	return "updateSuccess";
    }

}
