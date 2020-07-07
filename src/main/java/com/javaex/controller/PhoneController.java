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

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping("/phone")
public class PhoneController {
	
	@Autowired
	PhoneDao phoneDao;

	
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("/phone/list");
		
		List<PersonVo> personList = phoneDao.getPersonList();
		System.out.println(personList.toString());
		
		model.addAttribute("pList", personList);
		
		return "list";
		
	}
	
	
	@RequestMapping(value = "/write", method = {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("/phone/write");
		System.out.println(personVo.toString());
		
		phoneDao.personInsert(personVo);
		
		return "redirect:/phone/list";
		
	}
	
	@RequestMapping(value = "/write2", method = {RequestMethod.GET, RequestMethod.POST})
	public String write2(@RequestParam("name") String name, 
						 @RequestParam("hp") String hp,  
						 @RequestParam("company") String company) {
		System.out.println("/phone/write2");
		
		phoneDao.personInsert2(name, hp, company);
		
		return "redirect:/phone/list";
		
	}
	
	
	@RequestMapping(value = "/writeForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		
		return "writeForm";
	}

	/*
	@RequestMapping(value = "/updateForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String updateForm(Model model, @RequestParam("pid") int personId) {
		System.out.println("/phone/updateForm");
		System.out.println(personId);
		
		PersonVo person = phoneDao.getPerson(personId);
		System.out.println(person.toString());
		
		model.addAttribute("person", person);
		
		return "updateForm";
	}
	
	//PathVariable
	
	@RequestMapping(value = "/updateForm/{personId}", method = {RequestMethod.GET, RequestMethod.POST})
	public String updateForm(Model model, @PathVariable("personId") int personId) {
		System.out.println("/phone/updateForm");
		System.out.println(personId);
		
		PersonVo person = phoneDao.getPerson(personId);
		System.out.println(person.toString());
		
		model.addAttribute("person", person);
		
		return "/WEB-INF/views/updateForm.jsp";
	}
	
	
	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	public String update(@ModelAttribute PersonVo personVo) {
		System.out.println("/phone/update");
		System.out.println(personVo.toString());
		phoneDao.personUpdate(personVo);
		
		return "redirect:/phone/list";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("pid") int personId) {
		System.out.println("/phone/delete");
		System.out.println(personId);
		
		phoneDao.personDelete(personId);
		
		return "redirect:/phone/list";
	}
	
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