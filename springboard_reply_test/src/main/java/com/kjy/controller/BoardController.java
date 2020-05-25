package com.kjy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.pattern.IntegerPatternConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kjy.domain.BoardCompanyVO;
import com.kjy.domain.BoardTipVO;
import com.kjy.domain.BoardVO;
import com.kjy.service.BoardService;
import com.kjy.service.MemberService;
import com.kjy.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	private BoardService service;
	private ReplyService service_re;
	private MemberService servicee;
	
	@GetMapping("/list")
	public void list(HttpSession session,Model model) {
	
		log.info("list");
		model.addAttribute("list",service.getList());
		String id = (String)session.getAttribute("id");
		if(id == null) {
			id =".";
			model.addAttribute("model",servicee.getModel(id));
		}
		model.addAttribute("model",servicee.getModel(id));
	}
	@GetMapping("/list_company")
	public void getListCompany(HttpSession session,Model model) {
	
		log.info("list_company");
		model.addAttribute("company",service.getList_Company());
		String id = (String)session.getAttribute("id");
		if(id == null) {
			id =".";
			model.addAttribute("model",servicee.getModel(id));
		}
		model.addAttribute("model",servicee.getModel(id));
	}
	@GetMapping("/tip_list")
	public void getTipList(HttpSession session,Model model) {
	
		log.info("list_company");
		model.addAttribute("company",service.getTipList());
		String id = (String)session.getAttribute("id");
		if(id == null) {
			id =".";
			model.addAttribute("model",servicee.getModel(id));
		}
		model.addAttribute("model",servicee.getModel(id));
	}
	
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		log.info("register : " + board);
		
		service.register(board);
		
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list";
	}
	@PostMapping("/cb_register")
	public String cb_register(BoardCompanyVO board, RedirectAttributes rttr) {
		
		log.info("register : " + board);
		
		service.cb_register(board);
		
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list_company";
	}
	@PostMapping("/tip_register")
	public String tip_register(BoardTipVO board, RedirectAttributes rttr) {
		
		log.info("register : " + board);
		
		service.tip_register(board);
		
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/tip_list";
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, Model model,HttpServletRequest request) {
		
		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));
		
		log.info("list"); 
		model.addAttribute("list",service_re.getList());
		
		HttpSession session = request.getSession();
		model.addAttribute("userid",session.getAttribute("id"));
		
		String id = (String)session.getAttribute("id");
		if(id == null) {
			id =".";
			model.addAttribute("model",servicee.getModel(id));
		}
		model.addAttribute("model",servicee.getModel(id));
		 
	}
	@GetMapping({"/company_get", "/company_modify"})
	public void company_get(@RequestParam("bno") Long bno, Model model,HttpServletRequest request) {
		
		log.info("/get or modify");
		model.addAttribute("board", service.get_comapny(bno));
		
		log.info("list"); 
		model.addAttribute("list",service_re.getList_company());
		
		HttpSession session = request.getSession();
		model.addAttribute("userid",session.getAttribute("id"));
		
		String id = (String)session.getAttribute("id");
		if(id == null) {
			id =".";
			model.addAttribute("model",servicee.getModel(id));
		}
		model.addAttribute("model",servicee.getModel(id));
		 
	}
	@GetMapping({"/tip_get", "/tip_modify"})
	public void tip_get(@RequestParam("bno") Long bno, Model model,HttpServletRequest request) {
		
		log.info("/tip_get or tip_modify");
		model.addAttribute("board", service.get_tip(bno));
		
		log.info("list"); 
		model.addAttribute("list",service_re.getList_tip());
		
		HttpSession session = request.getSession();
		model.addAttribute("userid",session.getAttribute("id"));
		
		String id = (String)session.getAttribute("id");
		if(id == null) {
			id =".";
			model.addAttribute("model",servicee.getModel(id));
		}
		model.addAttribute("model",servicee.getModel(id));
		 
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("modify:"+board);
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result","SUCCESS");
		}
		return "redirect:/board/list";
	}
	@PostMapping("/company_modify")
	public String company_modify(BoardCompanyVO board, RedirectAttributes rttr) {
		log.info("modify:"+board);
		
		if(service.company_modify(board)) {
			rttr.addFlashAttribute("result","SUCCESS");
		}
		return "redirect:/board/list_company";
	}
	
	@GetMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		
		log.info("remove..."+bno);
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "SUCCESS");
		}
		return "redirect:/board/list";
	}
	@GetMapping("/company_remove")
	public String comapny_remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		
		log.info("remove..."+bno);
		if(service.company_remove(bno)) {
			rttr.addFlashAttribute("result", "SUCCESS");
		}
		return "redirect:/board/list_company";
	}
	
	
	@GetMapping("/register")
	public void register(HttpServletRequest request, Model model) {
	
		HttpSession session = request.getSession();
		model.addAttribute("userid",session.getAttribute("id"));
	}
	@GetMapping("/cb_register")
	public void cb_register(HttpServletRequest request, Model model) {
	
		HttpSession session = request.getSession();
		model.addAttribute("userid",session.getAttribute("id"));
	}
	@GetMapping("/tip_register")
	public void tip_register(HttpServletRequest request, Model model) {
	
		HttpSession session = request.getSession();
		model.addAttribute("userid",session.getAttribute("id"));
	}

	
}
