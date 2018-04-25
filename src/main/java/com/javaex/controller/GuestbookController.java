package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestVo;


@Controller
public class GuestbookController {

	@Autowired
	private GuestbookDao dao;	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		
		System.out.println("list진입");
		
		List<GuestVo> list = dao.getList();
		
		model.addAttribute("list", list);
		return "/WEB-INF/views/list.jsp";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute GuestVo guestVo) {
		System.out.println("데이터 넣었당!");
		System.out.println(guestVo.toString());
		
		dao.insert(guestVo);
		return "redirect:/list";
	}
	
	/*@RequestMapping(value="/deleteform", method=RequestMethod.GET)
	public String deleteform(@RequestParam("no") int no, Model model) {
		
		//String no1 = String.valueOf(no);
		model.addAttribute("no", no);
		System.out.println(no);
		System.out.println("deleteform 다녀옴");
		return "/WEB-INF/views/deleteform.jsp";
	}*/
	
	
	/*//Http 요청 파라미터로 보낼 때 사용
	@RequestMapping(value="/deleteform", method=RequestMethod.GET)
	public String deleteform() {
		System.out.println("deleteform 들렸다감~");
		return "/WEB-INF/views/deleteform.jsp";
	}*/
	
	//URL에 쿼리스트링 대신 URL패스로 보낼 때 사용
	@RequestMapping(value="/deleteform/{no}", method=RequestMethod.GET)
	public String deleteform(Model model, @PathVariable("no") int no) {
		
		System.out.println("deleteform_url 방식으로 들렸다감~");
		model.addAttribute("no",no);
		return "/WEB-INF/views/deleteform.jsp";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@RequestParam("no") int no, @RequestParam("password") String password) {
		
		System.out.println(no + "/" + password);
		int result = dao.delete(no, password);
		System.out.println(result+"건 삭제되었습니다.");
		
		return "redirect:/list";
	}
	
}
