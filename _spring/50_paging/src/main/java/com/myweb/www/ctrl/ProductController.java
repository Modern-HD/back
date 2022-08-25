package com.myweb.www.ctrl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.www.domain.PagingVO;
import com.myweb.www.domain.ProductVO;
import com.myweb.www.handler.PagingHandler;
import com.myweb.www.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Inject
	private ProductService psv;
	
	@GetMapping("/register")
	public void register() {
		log.info(">>> ProductCtrl > register - GET");
	}
	
	@PostMapping("/register")
	public String register(ProductVO pvo) {
		log.info(">>> ProductCtrl > register - POST");
		int isUp = psv.register(pvo);
		if (isUp > 0) {
			return "redirect:/product/list";
		} else {
			return "/product/register";
		}
	}
 	
	@GetMapping("/list")
	public void list(Model model, PagingVO pgvo) {
		log.info(">>> ProductCtrl > list - GET");
		model.addAttribute("list", psv.getList(pgvo));
		int totalCount = psv.getTotalCount(pgvo);
		model.addAttribute("pgn", new PagingHandler(pgvo, totalCount));
		
	}
	
	@GetMapping({"/detail", "/modify"})
	public void detail(Model model, @RequestParam("pno") long pno,
			@ModelAttribute("pgvo") PagingVO pgvo) {
		log.info(">>> ProductCtrl > detail - GET");
		model.addAttribute("pvo", psv.detail(pno));
	}
	
//	@GetMapping("/modify")
//	public void modify(Model model, @RequestParam("pno") long pno) {
//		log.info(">>> ProductCtrl > modify - GET");
//		model.addAttribute("pvo", psv.detail(pno));
//	}
	
	@PostMapping("/modify")
	public String modify(ProductVO pvo, RedirectAttributes rttr, PagingVO pgvo) {
		log.info(">>> ProductCtrl > modify - POST");
		int isUp = psv.modify(pvo);
		log.info(">>> ProductCtrl modify > {}", isUp > 0 ? "OK" : "POST");
		rttr.addAttribute("pageNo", pgvo.getPageNo());
		rttr.addAttribute("qty", pgvo.getQty());
		return "redirect:/product/detail?pno=" + pvo.getPno();
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("pno") long pno, RedirectAttributes rttr, PagingVO pgvo) {
		log.info(">>> ProductCtrl > delete - POST");
		int isUp = psv.remove(pno);
		rttr.addAttribute("pageNo", pgvo.getPageNo());
		rttr.addAttribute("qty", pgvo.getQty());
		log.info(">>> productCtrl > delete > {}", isUp > 0 ? "OK" : "FAIL");
		if (isUp > 0) {
			return "redirect:/product/list";
		} else {
			return "redirect:/product/detail?pno=" + pno;
		}
	}
	
}
