package com.controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.Country;
import com.bean.User;
import com.service.ServiceCountry;
import com.service.ServiceUser;

@Controller
public class LoginController {
	@Autowired
	private ServiceUser serviceUser;
	@Autowired
	private ServiceCountry serviceCountry;
	
	
	public ServiceCountry getServiceCountry() {
		return serviceCountry;
	}


	public void setServiceCountry(ServiceCountry serviceCountry) {
		this.serviceCountry = serviceCountry;
	}


	public ServiceUser getServiceUser() {
		return serviceUser;
	}


	public void setServiceUser(ServiceUser serviceUser) {
		this.serviceUser = serviceUser;
	}


	@RequestMapping(value="/login.do")
	public String list(User user,Model model,HttpServletResponse reponse){
		User u = serviceUser.findByName(user.getName());
		if (u!=null){
			if(u.getPassword().equals(user.getPassword())){
				ArrayList<Country> clist = (ArrayList<Country>) serviceCountry.findAll();
				model.addAttribute("countryList", clist);
				Cookie cookie = new Cookie("name",user.getName());
				cookie.setPath("/");
				reponse.addCookie(cookie);
				return "countryList";
			}
		}
		return "../../index";
	}
}
