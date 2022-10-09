package com.myweb.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myweb.board.domain.BoardVO;
import com.myweb.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	private BoardService bsv;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("BoardCtrl > list > GET");
		model.addAttribute("list", bsv.getList());
	}
	
	@GetMapping("/detail")
	public void detail(@RequestParam("bno") int bno,  Model model) {
		log.info(">>> boardCtrl > detail > GET");
		model.addAttribute("bvo", bsv.getDetail(bno));
	}
	
	@GetMapping("/register")
	public void register() {
		log.info("BoardCtrl > register > GET");
	}
	
	@PostMapping("/register")
	public String register(BoardVO bvo) {
		log.info("BoardCtrl > register > POST");
		bsv.register(bvo);
		return "redirect:/board/list";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO bvo) {
		log.info("BoardCtrl > modify > POST");
		bsv.modify(bvo);
		return "redirect:/board/detail?bno=" + bvo.getBno();
	}
	
	@PostMapping("/remove")
	public String remove(int bno) {
		log.info("BoardCtrl > remove > POST");
		bsv.remove(bno);
		return "redirect:/board/list";
	}
}
