package com.lut.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.lut.service.ReplyService;
import com.lut.utils.JsonUtils;
import com.lut.vo.Major;
import com.lut.vo.liuyan.Reply;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReplyAction extends ActionSupport implements ModelDriven<Reply> {

    HttpServletResponse response = ServletActionContext.getResponse();
    HttpServletRequest request = ServletActionContext.getRequest();

    private Reply reply = new Reply();

    @Override
    public Reply getModel() {
	return reply;
    }

    private ReplyService replyService;

    public void setReplyService(ReplyService replyService) {
	this.replyService = replyService;
    }

    // ajax 根据留言id查询所有回复
    public String findByLiuyanId() throws IOException {
	String lyid = request.getParameter("lyid").trim();
	List<Reply> replyList = replyService.findByLiuyanId(Integer.parseInt(lyid));
	response.setContentType("text/html;charset=UTF-8");
	String result = JsonUtils.toJson(replyList);
	// 打印转化出来的json
	System.out.println(result);
	ActionContext.getContext().put("replyList", replyList);
	PrintWriter out = response.getWriter();
	out.print(result);
	out.flush();
	out.close();
	return NONE;
    }

    public String save() {
	replyService.save(reply);
	return "saveSuccess";
    }

    public String delete() {
	reply = replyService.findById(reply.getId());
	replyService.delete(reply);
	return "deleteSuccess";
    }
}
