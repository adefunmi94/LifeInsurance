package com.oldmutualnigeria.lifeinsurance.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.oldmutualnigeria.lifeinsurance.model.LifeInsuranceCustomer;
import com.oldmutualnigeria.lifeinsurance.repository.LifeInsuranceRepository;

@Controller
public class LifeInsuranceCustomerController {
	
	@Autowired
	private LifeInsuranceRepository lifeInsuranceRepository;
	
	 @GetMapping("/signup")
	    public String showSignUpForm(LifeInsuranceCustomer lifeassured) {
		 
	        return "life-form";
	    }
	
	@GetMapping("/addLifeCustomer")
	 public String addLifeCustomer(@Valid LifeInsuranceCustomer lifeassured, BindingResult result, Model model) {
      
		if (result.hasErrors()) {
           
			return "life-form";
        }
		
		lifeInsuranceRepository.save(lifeassured);
	        model.addAttribute("lifeCustomers", lifeInsuranceRepository.findAll());
	      
	        return "index";
	}
         
}
