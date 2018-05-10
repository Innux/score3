package com.lut.action;

import com.lut.service.LiuyanService;
import com.lut.service.ReplyService;
import com.lut.service.StudentService;
import com.lut.utils.PageBean;
import com.lut.vo.liuyan.Liuyan;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LiuyanAction extends ActionSupport implements ModelDriven<Liuyan> {

    private Liuyan liuyan = new Liuyan();

    @Override
    public Liuyan getModel() {
	return liuyan;
    }

    private LiuyanService liuyanService;

    public void setLiuyanService(LiuyanService liuyanService) {
	this.liuyanService = liuyanService;
    }

    private ReplyService replyService;

    public void setReplyService(ReplyService replyService) {
	this.replyService = replyService;
    }


    // page参数
    private Integer page;

    public Integer getPage() {
	return page;
    }

    public void setPage(Integer page) {
	this.page = page;
    }

    public String findByPage() {
	PageBean<Liuyan> pageBean = liuyanService.findByPage(page);
	ActionContext.getContext().getValueStack().set("pageBean", pageBean);
	return "findAll";
    }

    public String save() {
	liuyanService.save(liuyan);
	return "saveSuccess";
    }

    public String delete() {
	liuyan = liuyanService.findById(liuyan.getId());
	liuyanService.delete(liuyan);
	return "deleteSuccess";
    }
}
