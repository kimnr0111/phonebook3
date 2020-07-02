package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping("/phone")
public class PhoneController {
	
	@RequestMapping(value = "/writeForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		
		return "/WEB-INF/views/writeForm.jsp";
	}
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		
		PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> pList = phoneDao.getPersonList();
		System.out.println(pList.toString());
		
		model.addAttribute("pList", pList);
		
		return "/WEB-INF/views/list.jsp";
		
	}
	
	
	@RequestMapping(value = "/write", method = {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("/phone/write");
		System.out.println(personVo.toString());
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);
		return "redirect:/phone/list";
		
	}
	
	@RequestMapping(value = "/updateForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String updateForm() {
		
		return "/WEB-INF/views/update.jsp";
	}
	
	/*
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(@RequestParam("name") String name, 
						@RequestParam("hp") String hp, 
						@RequestParam(value = "company", required = false, defaultValue = "0000") String company) {
		System.out.println("/phone/write");
		System.out.println(name + " , " + hp + " , " + company);
		
		PersonVo personVo = new PersonVo(name, hp, company);
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);
		
		return "redirect:/phone/list";
	}
	*/
	
	
}

