package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dao.CarDao;
import com.example.dao.MemberDao;
import com.example.model.CarBean;
import com.example.model.MemberBean;




@Controller
public class MemberController {

	@Autowired
	 MemberDao memberDao;
	@Autowired
	CarDao carDao;
	

	@RequestMapping("/")
	public String login(Model model) {
		model.addAttribute("messessError","");
		return "login";
	}
	@RequestMapping("/addcar2")
	public String gotoInsert(Model model) {	
		model.addAttribute("messes", "");
		return "addcar";
	}
	@RequestMapping("/login")
	public String outhenlogin( String username ,String password, Model model ,HttpServletRequest request ,String status) {
		
		String outhen ="";
		
		MemberBean bean = new MemberBean();
		List<MemberBean> findAll = new ArrayList<MemberBean>();
		try {
			bean = memberDao.meber(username, password);
			findAll = memberDao.findAll();
			if(bean.getMemUsername()!=null){
				request.getSession().setAttribute("LoginMember", bean);
				request.getSession().setAttribute("listMember", findAll);
				 model.addAttribute("messessError","L");
				
					 outhen ="welcomeMember";
				 }
			else {
				model.addAttribute("messessError", "F");
			       outhen ="login";
			}
			}
		
		 catch (Exception e) {
			// TODO: handle exception
			 model.addAttribute("messessError", "F");
		       outhen ="login";
		}		
		return outhen;
	}
	@RequestMapping("/welcomeMember")
	public String test() {
		return "welcomeMember";
	}

@RequestMapping("/carmap2")
public String carmap2(HttpServletRequest request, HttpServletResponse response,String useremail) {
	List<CarBean> findAll = new ArrayList<CarBean>();
		findAll = carDao.findAll( useremail); 
	request.setAttribute("listcar", findAll);
	return "carmap";
}
// logout
	@RequestMapping("/logout")
	public String Loout(HttpServletRequest request , Model model) {
		request.getSession().removeAttribute("LoginMember");
		request.getSession().removeAttribute("listMember");
		 model.addAttribute("messessError","L");
		 return  "login";
	}
	
// End Class
}
