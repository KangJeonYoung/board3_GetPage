package com.kjy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kjy.domain.ReplyCompanyVO;
import com.kjy.domain.ReplyQuestionsVO;
import com.kjy.domain.ReplyTipVO;
import com.kjy.domain.ReplyVO;
import com.kjy.service.BoardService;
import com.kjy.service.MemberService;
import com.kjy.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/replies/*")
@AllArgsConstructor
public class ReplyController {

	private MemberService servicee;
	private ReplyService service;
	
	@GetMapping("/list")
	public void list(Model model) {
	
		log.info("list");
		model.addAttribute("list",service.getList());
	}
	
	@PostMapping("/register")
	public String register(ReplyVO reply, RedirectAttributes rttr) {
		
		log.info("register : " + reply);
		
		service.register(reply);
		
		rttr.addFlashAttribute("result", reply.getBno());
		
		return "redirect:/board/get?bno="+reply.getBno();
	}
	@PostMapping("/company_register")
	public String company_register(ReplyCompanyVO reply, RedirectAttributes rttr) {
		
		log.info("company_register: " + reply);
		
		service.company_register(reply);
		
		rttr.addFlashAttribute("result", reply.getBno());
		
		return "redirect:/board/company_get?bno="+reply.getBno();
	}
	@PostMapping("/tip_register")
	public String tip_register(ReplyTipVO reply, RedirectAttributes rttr) {
		
		log.info("tip_register: " + reply);
		
		service.tip_register(reply);
		
		rttr.addFlashAttribute("result", reply.getBno());
		
		return "redirect:/board/tip_get?bno="+reply.getBno();
	}
	@PostMapping("/questions_register")
	public String questions_register(ReplyQuestionsVO reply, RedirectAttributes rttr) {
		
		log.info("questions_register: " + reply);
		
		service.questions_register(reply);
		
		rttr.addFlashAttribute("result", reply.getBno());
		
		return "redirect:/board/questions_get?bno="+reply.getBno();
	}
	
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("rno") Long rno,HttpServletRequest request, Model model) {
		
		log.info("/get or modify");
		model.addAttribute("reply", service.get(rno));
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		if(id == null) {
			id =".";
			model.addAttribute("model",servicee.getModel(id));
		}
		model.addAttribute("model",servicee.getModel(id));
		
	}
	@GetMapping({"/company_get", "/company_modify"})
	public void company_get(@RequestParam("rno") Long rno,HttpServletRequest request, Model model) {
		
		log.info("/company_get or company_modify");
		model.addAttribute("reply", service.company_get(rno));
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		if(id == null) {
			id =".";
			model.addAttribute("model",servicee.getModel(id));
		}
		model.addAttribute("model",servicee.getModel(id));
		
	}
	@GetMapping({"/tip_get", "/tip_modify"})
	public void tip_get(@RequestParam("rno") Long rno,HttpServletRequest request, Model model) {
		
		log.info("/tip_get or tip_modify");
		model.addAttribute("reply", service.tip_get(rno));
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		if(id == null) {
			id =".";
			model.addAttribute("model",servicee.getModel(id));
		}
		model.addAttribute("model",servicee.getModel(id));
		
	}
	@GetMapping({"/questions_get", "/questions_modify"})
	public void questions_get(@RequestParam("rno") Long rno,HttpServletRequest request, Model model) {
		
		log.info("/questions_get or questions_modify");
		model.addAttribute("reply", service.questions_get(rno));
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		if(id == null) {
			id =".";
			model.addAttribute("model",servicee.getModel(id));
		}
		model.addAttribute("model",servicee.getModel(id));
		
	}
	
	
	@PostMapping("/modify")
	public String modify(ReplyVO reply, RedirectAttributes rttr) {
		log.info("modify:"+reply);
		
		if(service.modify(reply)) {
			rttr.addFlashAttribute("result","SUCCESS");
		}
		return "redirect:/board/get?bno="+reply.getBno();
	}
	@PostMapping("/company_modify")
	public String company_modify(ReplyCompanyVO reply, RedirectAttributes rttr) {
		log.info("company_modify:"+reply);
		
		if(service.company_modify(reply)) {
			rttr.addFlashAttribute("result","SUCCESS");
		}
		return "redirect:/board/company_get?bno="+reply.getBno();
	}
	@PostMapping("/tip_modify")
	public String tip_modify(ReplyTipVO reply, RedirectAttributes rttr) {
		log.info("tip_modify:"+reply);
		
		if(service.tip_modify(reply)) {
			rttr.addFlashAttribute("result","SUCCESS");
		}
		
		return "redirect:/board/tip_get?bno="+reply.getBno();
	}
	@PostMapping("/questions_modify")
	public String questions_modify(ReplyQuestionsVO reply, RedirectAttributes rttr) {
		log.info("questions_modify:"+reply);
		
		if(service.questions_modify(reply)) {
			rttr.addFlashAttribute("result","SUCCESS");
		}
		
		return "redirect:/board/questions_get?bno="+reply.getBno();
	}
	
	
	
	@GetMapping("/remove")
	public String remove(@RequestParam("rno") Long rno, @RequestParam("bno") Long bno  ,RedirectAttributes rttr) {
		
		log.info("remove..."+rno);
		
		if(service.remove(rno)) {
			rttr.addFlashAttribute("result", "SUCCESS");
		}
		return "redirect:/board/get?bno="+bno;
	}
	@GetMapping("/company_remove")
	public String company_remove(@RequestParam("rno") Long rno, @RequestParam("bno") Long bno  ,RedirectAttributes rttr) {
		
		log.info("company_remove: "+rno);
		
		if(service.company_remove(rno)) {
			rttr.addFlashAttribute("result", "SUCCESS");
		}
		return "redirect:/board/company_get?bno="+bno;
	}
	@GetMapping("/tip_remove")
	public String tip_remove(@RequestParam("rno") Long rno, @RequestParam("bno") Long bno  ,RedirectAttributes rttr) {
		
		log.info("tip_remove: "+rno);
		
		if(service.tip_remove(rno)) {
			rttr.addFlashAttribute("result", "SUCCESS");
		}
		return "redirect:/board/tip_get?bno="+bno;
	}
	@GetMapping("/questions_remove")
	public String questions_remove(@RequestParam("rno") Long rno, @RequestParam("bno") Long bno ,RedirectAttributes rttr) {
		
		log.info("questions_remove: "+rno);
		
		if(service.questions_remove(rno)) {
			rttr.addFlashAttribute("result", "SUCCESS");
		}
		return "redirect:/board/questions_get?bno="+bno;
	}
	
	
	@GetMapping("/register")
	public void register() {
	}


	
}
