package com.kjy.mapper;

import java.util.List;

import com.kjy.domain.ReplyCompanyVO;
import com.kjy.domain.ReplyTipVO;

//import org.apache.ibatis.annotations.Select;

import com.kjy.domain.ReplyVO;

public interface ReplyMapper {

//		@Select("select * from tbl_board where bno > 0")
		public List<ReplyVO> getList();
		public List<ReplyCompanyVO> getList_company();
		public List<ReplyTipVO> getList_Tip();
		
		public void insert(ReplyVO reply);
		
		public void insertSelectKey(ReplyVO reply);
		public void company_insertSelectKey(ReplyCompanyVO reply);
		
		public ReplyVO read(Long rno);
		public ReplyCompanyVO company_read(Long rno);
		
		public int delete(Long rno);
		public int company_delete(Long rno);
		//error가 날 시에는 int bno
		
		public int update(ReplyVO reply);
		public int company_update(ReplyCompanyVO reply);

}
