package com.kjy.service;

import java.util.List;

import com.kjy.domain.BoardCompanyVO;
import com.kjy.domain.BoardQuestionsVO;
import com.kjy.domain.BoardTipVO;
import com.kjy.domain.BoardVO;

public interface BoardService {
	
	public void register(BoardVO board);
	public void cb_register(BoardCompanyVO board);
	public void tip_register(BoardTipVO board);
	public void questions_register(BoardQuestionsVO board);
	
	
	public BoardVO get(Long bno);
	public BoardCompanyVO get_comapny(Long bno);
	public BoardTipVO get_tip(Long bno);
	public BoardQuestionsVO get_questions(Long bno);
	
	
	public boolean modify(BoardVO board);
	public boolean company_modify(BoardCompanyVO board);
	public boolean tip_modify(BoardTipVO board);
	public boolean questions_modify(BoardQuestionsVO board);
	// 기존의 글을 수정할 때
	// update 메서드와 mapping
	
	
	public boolean remove(Long bno);
	public boolean company_remove(Long bno);
	public boolean tip_remove(Long bno);
	public boolean questions_remove(Long bno);
	// 내가 지정한 글 번호를 이용해서 해당글을 삭제할 때.
	// delete 메서드와 mapping
	
	
	public List<BoardVO> getList();
	// 전체 데이터를 조회할 때.
	// getList와 mapping
	public List<BoardCompanyVO> getList_Company();
	public List<BoardTipVO> getTipList();
	public List<BoardQuestionsVO> getQuestionsList();



}
