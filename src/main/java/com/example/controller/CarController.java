package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dao.CarDao;

import com.example.model.CarBean;

@Controller
public class CarController {

	@Autowired
	CarDao carDao;

	
	@RequestMapping("/carmap")
	public String outhenlogin( String useremail , Model model ,HttpServletRequest request ,String status) {
		String outhen ="";
		
		CarBean bean = new CarBean();
		List<CarBean> findAll = new ArrayList<CarBean>();
		try {
			
			findAll = carDao.findAll(useremail);
			if(bean.getUseremail()!=null){
				request.getSession().setAttribute("car", bean);
				request.getSession().setAttribute("listcar", findAll);
				 model.addAttribute("messessError","L");
					 outhen ="carmap";
				 }
			else {
				model.addAttribute("messessError", "F");
			       outhen ="welcomeMember";
			}
			}
		
		 catch (Exception e) {
			// TODO: handle exception
			 model.addAttribute("messessError", "F");
		       outhen ="welcomeMember";
		}		
		return outhen;
	}

	@RequestMapping("/addcar")
	public String insert(Model model,@ModelAttribute("SpringWeb") CarBean bean,String email,String lat,String log,String address,Integer mid,HttpServletRequest request) {
	
	List<CarBean> findAll = new ArrayList<CarBean>();
	try {
	
		findAll = carDao.findAll();
			request.getSession().setAttribute("cardao", bean);
			request.getSession().setAttribute("listMember", findAll);
	//CarBean bean = new CarBean();
	bean.setUseremail(email);
	bean.setCarLat(lat);
	bean.setCarLog(log);
	bean.setCarAddress(address);
	bean.setCarMid(mid);
	
	try {
		carDao.insert(bean);
		model.addAttribute("messes", "S");
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		model.addAttribute("messes", "F");
	}
}

	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		model.addAttribute("messes", "F");
	}
	return "addcar";
}

	
	
	
	// end class
}
