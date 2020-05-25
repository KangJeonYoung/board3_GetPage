package com.kjy.service;

import java.util.List;

import com.kjy.domain.ReplyVO;
import com.kjy.domain.Criteria;
import com.kjy.domain.ReplyCompanyVO;
import com.kjy.domain.ReplyTipVO;

public interface ReplyService {
	
	public void register(ReplyVO reply);
	public void company_register(ReplyCompanyVO reply);
	
	public ReplyVO get(Long bno);
	public ReplyCompanyVO company_get(Long rno);
	
	public boolean modify(ReplyVO reply);
	public boolean company_modify(ReplyCompanyVO reply);
	// 기존의 글을 수정할 때
	// update 메서드와 mapping
	
	public boolean remove(Long bno);
	public boolean company_remove(Long rno);
	// 내가 지정한 글 번호를 이용해서 해당글을 삭제할 때.
	// delete 메서드와 mapping
	
	public List<ReplyVO> getList();
	public List<ReplyCompanyVO> getList_company();
	// 전체 데이터를 조회할 때.
	// getList와 mapping
	public List<ReplyTipVO> getList_tip();


}
