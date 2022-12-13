package com.example.boot1.RestrauntController;

import java.util.List;

import javax.validation.Valid;

import com.example.boot1.RestrauntEntity.RestrauntEntity;
import com.example.boot1.RestrauntEntity.UserLogin;
import com.example.boot1.RestrauntService.RestrauntSVC;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RestrauntControllerCls {

	// Autowire is done automatically
	RestrauntSVC restroSvc;

	public RestrauntControllerCls(RestrauntSVC restroSvc) {
		this.restroSvc = restroSvc;
	}
	
	@GetMapping("/Contactus")
	public String mainPage(Model model) {
		return "formActivity2";
	}

	@GetMapping("/KhaanaKhazanaHome")
	public String homePage(Model model) {
		return "KhaanaKhazana";
	}


	@GetMapping("/valiadateUser")
	public String validateUser(@Valid @ModelAttribute("userObj") UserLogin usrLognObj ) {
		if (usrLognObj.getUserName().equals("Admininstrator") && usrLognObj.getPassword().equals("Admin@1999")) {
			return "redirect:/KhaanaKhazanaHome";
		} else {
			return "redirect:/login";			
		}
	}

	@GetMapping("/login")
	public String login(Model model) {
		UserLogin usrLognObj = new UserLogin();
		model.addAttribute("userObj", usrLognObj);
		return "loginPage";
	}

	@GetMapping("/ViewAllRestraunt")
	public String viewAllRestraunts(Model model) {
		model.addAttribute("restroList", restroSvc.getAllRestraunt());
		return "ViewRestro";
	}

	@GetMapping("/addRestaurant")
	public String addRestro(Model model) {
		RestrauntEntity rEntityObj = new RestrauntEntity();
		model.addAttribute("restroDtls", rEntityObj);
		return "addRestro";
	}

	@PostMapping("/insertRestroToDB")
	public String createRestro(@ModelAttribute(("restroDtls")) RestrauntEntity addNewRestro) {
		restroSvc.insertRestro(addNewRestro);
		return "redirect:/ViewAllRestraunt";
	}

	@GetMapping("/restaurant/edit/{id}")
	public String editRestro(@PathVariable int id, Model model) {
		model.addAttribute("getRestrauntDtls", restroSvc.getRestroById(id));
		return "viewSelectRestro";
	}

	@PostMapping("/update/{id}")
	public String updRestro(@PathVariable int id, @ModelAttribute("getRestrauntDtls") RestrauntEntity updRestroViewObj,
			Model model) {
		RestrauntEntity updRestroObj = restroSvc.getRestroById(id);
		updRestroObj.setName(updRestroViewObj.getName());
		updRestroObj.setAvgPrice(updRestroViewObj.getAvgPrice());
		updRestroObj.setRatings(updRestroViewObj.getRatings());
		updRestroObj.setTypeOfFood(updRestroViewObj.getTypeOfFood());
		updRestroObj.setOwnerName(updRestroViewObj.getOwnerName());
		restroSvc.updNewRestroRecord(updRestroObj);
		return "redirect:/ViewAllRestraunt";
	}

	@GetMapping("/deleteRestaurant/{id}")
	public String delRestro(@PathVariable int id) {
		// TODO Auto-generated method stub
		restroSvc.delRestro(id);
		return "redirect:/ViewAllRestraunt";
	}

	@GetMapping("/logout")
	public String logoutFun() {
		return "redirect:/login";
	}

}
