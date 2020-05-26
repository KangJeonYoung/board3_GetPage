package com.kjy.mapper;

import java.util.List;

import com.kjy.domain.BoardCompanyVO;
import com.kjy.domain.BoardQuestionsVO;
import com.kjy.domain.BoardTipVO;

//import org.apache.ibatis.annotations.Select;

import com.kjy.domain.BoardVO;

public interface BoardMapper {

		public List<BoardCompanyVO> getList_Company();
		//		@Select("select * from tbl_board where bno > 0")
		public List<BoardVO> getList();
		public List<BoardTipVO> getList_Tip();
		public List<BoardQuestionsVO> getList_Questions();
		
		
		public void insert(BoardVO board);
		
		
		public void insertSelectKey(BoardVO board);
		public void insertCB(BoardCompanyVO board);
		public void insertTip(BoardTipVO board);
		public void insertQuestions(BoardQuestionsVO board);
		
		
		public BoardVO read(Long bno);
		public BoardCompanyVO read_company(Long bno);
		public BoardTipVO read_tip(Long bno);
		public BoardQuestionsVO read_questions(Long bno);
		
		
		public int delete(Long bno);
		public int company_delete(Long bno);
		public int tip_delete(Long bno);
		public int questions_delete(Long bno);
		//error가 날 시에는 int bno
		
		
		public int update(BoardVO board);
		public int company_update(BoardCompanyVO board);
		public int tip_update(BoardTipVO board);
		public int questions_update(BoardQuestionsVO board);
		


}
