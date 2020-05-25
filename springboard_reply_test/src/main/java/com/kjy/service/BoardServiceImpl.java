package com.kjy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kjy.domain.BoardCompanyVO;
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
		log.info("register....."+board);
		mapper.insertCB(board);
	}
	@Override
	public void tip_register(BoardTipVO board) {
		log.info("register....."+board);
		mapper.insertTip(board);
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
		log.info("getList_Company");
		return mapper.getList_Tip();
	}



}
