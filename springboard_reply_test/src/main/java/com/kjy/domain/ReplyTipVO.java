package com.kjy.domain;

import java.util.Date;

import lombok.Data;


//import java.sql.Date;
import lombok.Data;

@Data
public class ReplyTipVO {
	
	private Long rno;
	private Long bno;
	
	private String reply;
	private String replyer;
	private Date replyDate;
}