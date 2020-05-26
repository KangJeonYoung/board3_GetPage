package com.kjy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kjy.domain.BoardCompanyVO;
import com.kjy.domain.BoardQuestionsVO;
import com.kjy.domain.BoardTipVO;
import com.kjy.domain.BoardVO;
import com.kjy.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import org.junit.Test;


@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {


	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		log.info("register....."+board);
		mapper.insertSelectKey(board);
	}
	@Override
	public void cb_register(BoardCompanyVO board) {
		log.info("company_register....."+board);
		mapper.insertCB(board);
	}
	@Override
	public void tip_register(BoardTipVO board) {
		log.info("tip_register....."+board);
		mapper.insertTip(board);
	}
	@Override
	public void questions_register(BoardQuestionsVO board) {
		log.info("questions_register....."+board);
		mapper.insertQuestions(board);
	}
	

	@Override
	public BoardVO get(Long bno) {
		log.info("get....." + bno);
		return mapper.read(bno);
	}
	@Override
	public BoardCompanyVO get_comapny(Long bno) {
		log.info("get_comapny: " + bno);
		return mapper.read_company(bno);
	}
	@Override
	public BoardTipVO get_tip(Long bno) {
		log.info("get_comapny: " + bno);
		return mapper.read_tip(bno);
	}
	@Override
	public BoardQuestionsVO get_questions(Long bno) {
		log.info("get_comapny: " + bno);
		return mapper.read_questions(bno);
	}
	

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify....." + board);
		return mapper.update(board) == 1;
	}
	@Override
	public boolean company_modify(BoardCompanyVO board) {
		log.info("comapny_modify" + board);
		return mapper.company_update(board) == 1;
	}
	@Override
	public boolean tip_modify(BoardTipVO board) {
		log.info("tip_modify" + board);
		return mapper.tip_update(board) == 1;
	}
	@Override
	public boolean questions_modify(BoardQuestionsVO board) {
		log.info("questions_modify" + board);
		return mapper.questions_update(board) == 1;
	}

	
	@Override
	public boolean remove(Long bno) {
		log.info("remove....."+ bno);
		return mapper.delete(bno) == 1;
	}
	@Override
	public boolean company_remove(Long bno) {
		log.info("company_remove: "+ bno);
		return mapper.company_delete(bno) == 1;
	}
	@Override
	public boolean tip_remove(Long bno) {
		log.info("tip_remove: "+ bno);
		return mapper.tip_delete(bno) == 1;
	}
	@Override
	public boolean questions_remove(Long bno) {
		log.info("questions_remove: "+ bno);
		return mapper.questions_delete(bno) == 1;
	}
	
	
	@Override
	public List<BoardVO> getList() {
		log.info("getList.....");
		return mapper.getList();
	}
	@Override
	public List<BoardCompanyVO> getList_Company() {
		log.info("getList_Company");
		return mapper.getList_Company();
	}
	@Override
	public List<BoardTipVO> getTipList() {
		log.info("getList_Tip");
		return mapper.getList_Tip();
	}
	@Override
	public List<BoardQuestionsVO> getQuestionsList() {
		log.info("getList_Questions");
		return mapper.getList_Questions();
	}



}
