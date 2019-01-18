package com.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.Country;
import com.service.ServiceCountry;

@Controller
@RequestMapping("/country")
public class CountryController {
	@Autowired
	private ServiceCountry serviceCountry;

	public ServiceCountry getServiceCountry() {
		return serviceCountry;
	}

	public void setServiceCountry(ServiceCountry serviceCountry) {
		this.serviceCountry = serviceCountry;
	}
	@RequestMapping("/list.do")
	public String list(HttpServletRequest request){
		ArrayList<Country> countryList = (ArrayList<Country>) serviceCountry.findAll();
		request.setAttribute("countryList", countryList);
		return "countryList";
	}
	
	@RequestMapping("/preAdd.do")
	public String preAdd(){
		return "addCountry";
	}
	@RequestMapping("/addCountry.do")
	public String addCountry(Country country){
		serviceCountry.addCountry(country);
		return "redirect:/country/list.do";	
	}
	@RequestMapping("/delete.do")
	public String delete(Country country){
		serviceCountry.deleteCountry(country.getId());
		return "redirect:/country/list.do";
	}
	
	@RequestMapping("/preUpdate.do")
	public String preUpdate(Integer id, Model model){
		Country country = serviceCountry.findById(id);
		model.addAttribute("counrty",country);
		return "updateCountry";
	}
	@RequestMapping("/update.do")
	public String preUpdate(Country country){
		serviceCountry.updateCountry(country);
		return "redirect:/country/list.do";
	}
	@RequestMapping(value="/select.do")
	public String query(Country country,Model model){
		ArrayList<Country> clist=(ArrayList<Country>) serviceCountry.findByName(country);
		model.addAttribute("countryList", clist);
		return "countryList";
	}
}
