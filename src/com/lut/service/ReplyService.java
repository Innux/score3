package com.lut.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lut.dao.ReplyDao;
import com.lut.vo.liuyan.Reply;

@Transactional
public class ReplyService {

    private ReplyDao replyDao;

    public void setReplyDao(ReplyDao replyDao) {
	this.replyDao = replyDao;
    }

    public List<Reply> findByLiuyanId(Integer lyid) {
	return replyDao.findByLiuyanId(lyid);
    }

    public void save(Reply reply) {
	replyDao.save(reply);
    }

    public void delete(Reply reply) {
	replyDao.delete(reply);
    }

    public Reply findById(Integer id) {
	return replyDao.findById(id);
    }

    public void deleteByLyId(int lyid) {
	List<Reply> list = replyDao.findByLiuyanId(lyid);
	if (list != null && list.size() > 0) {
	    for (int i = 0; i < list.size(); i++) {
		replyDao.delete(list.get(i));
	    }
	}

    }

}
