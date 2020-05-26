package com.kjy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kjy.domain.ReplyCompanyVO;
import com.kjy.domain.ReplyQuestionsVO;
import com.kjy.domain.ReplyTipVO;
import com.kjy.domain.ReplyVO;
import com.kjy.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import org.junit.Test;


@Log4j
@Service
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {


	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Override
	public void register(ReplyVO reply) {
		log.info("register....."+reply);
		mapper.insertSelectKey(reply);
	}
	@Override
	public void company_register(ReplyCompanyVO reply) {
		log.info("comapny_register....."+reply);
		mapper.company_insertSelectKey(reply);
	}
	@Override
	public void tip_register(ReplyTipVO reply) {
		log.info("tip_register....."+reply);
		mapper.tip_insertSelectKey(reply);
	}
	@Override
	public void questions_register(ReplyQuestionsVO reply) {
		log.info("questions_register....."+reply);
		mapper.questions_insertSelectKey(reply);
	}
	
	
	@Override
	public ReplyVO get(Long rno) {
		log.info("get....." + rno);
		return mapper.read(rno);
	}
	@Override
	public ReplyCompanyVO company_get(Long rno) {
		log.info("company_get....." + rno);
		return mapper.company_read(rno);
	}
	@Override
	public ReplyTipVO tip_get(Long rno) {
		log.info("tip_get....." + rno);
		return mapper.tip_read(rno);
	}
	@Override
	public ReplyQuestionsVO questions_get(Long rno) {
		log.info("questions_get....." + rno);
		return mapper.questions_read(rno);
	}
	
	
	@Override
	public boolean modify(ReplyVO reply) {
		log.info("modify....." + reply);
		return mapper.update(reply) == 1;
	}
	@Override
	public boolean company_modify(ReplyCompanyVO reply) {
		log.info("company_modify: " + reply);
		return mapper.company_update(reply) == 1;
	}
	@Override
	public boolean tip_modify(ReplyTipVO reply) {
		log.info("company_modify: " + reply);
		return mapper.tip_update(reply) == 1;
	}
	@Override
	public boolean questions_modify(ReplyQuestionsVO reply) {
		log.info("questions_modify: " + reply);
		return mapper.questions_update(reply) == 1;
	}
	
	
	@Override
	public boolean remove(Long rno) {
		log.info("remove....."+ rno);
		return mapper.delete(rno) == 1;
	}
	@Override
	public boolean company_remove(Long rno) {
		log.info("company_remove: "+ rno);
		return mapper.company_delete(rno) == 1;
	}
	@Override
	public boolean tip_remove(Long rno) {
		log.info("tip_remove: "+ rno);
		return mapper.tip_delete(rno) == 1;
	}
	@Override
	public boolean questions_remove(Long rno) {
		log.info("questions_remove: "+ rno);
		return mapper.questions_delete(rno) == 1;
	}
	

	
	@Override
	public List<ReplyVO> getList() {
		log.info("getList.....");
		return mapper.getList();
	}
	@Override
	public List<ReplyCompanyVO> getList_company() {
		log.info("getList_company");
		return mapper.getList_company();
	}
	@Override
	public List<ReplyTipVO> getList_tip() {
		log.info("getList_Tip");
		return mapper.getList_Tip();
	}
	@Override
	public List<ReplyQuestionsVO> getList_questions() {
		log.info("getList_Questions");
		return mapper.getList_Questions();
	}


}
