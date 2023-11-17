package com.valtech.training.firstspringboot.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.training.firstspringboot.models.ChangePasswordModel;
import com.valtech.training.firstspringboot.models.RegisterUserModel;
import com.valtech.training.firstspringboot.services.AuthService;

@Controller
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/changePassword")
	public String handleChangePassword(@AuthenticationPrincipal UserDetails userDetails,@ModelAttribute ChangePasswordModel pwdModel,Model model) {
		pwdModel.setUsername(userDetails.getUsername());
		if(Objects.equals(pwdModel.getNewPassword(), pwdModel.getOldPassword())) {
			if(authService.changePassword(pwdModel)) {
				model.addAttribute("message","Password Changed Successfully");
			}
			else {
				model.addAttribute("message","Old password does not match");
				return "changePassword";
			}
		}else {
			model.addAttribute("message","Password and Confirm password does not match");
			return "redirect:logout";
		}
		
		return "redirect:logout";
	}
	
	@GetMapping("/changePassword")
	public String changePasswordForm() {
		return "changePassword";
	}
	
	@PostMapping("/register")
	public String handleRegistration(@ModelAttribute RegisterUserModel regUserModel,Model model) {
		// regUserModel.getPassword().equals(regUserModel.getConfirmPassword()) [can be done like this also]
		if(Objects.equals(regUserModel.getPassword(), regUserModel.getConfirmPassword())) {
			authService.createUser(regUserModel);
			model.addAttribute("message","User registration Succesfull . . . (Login to proceed)");
		}else {
			model.addAttribute("message","Password and Confirm Password does not match");
			return "register";
		}
		return "/login";
	}
	
	@GetMapping("/register")
	public String registerForm() {
		return "register";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/anon")
	@ResponseBody
	public String anonPage() {
		return "Anonymous page";
	}
	
	@GetMapping("/user")
	@ResponseBody
	public String userPage() {
		return "User page";
	}
	
	@GetMapping("/admin")
	@ResponseBody
	public String adminPage() {
		return "Admin page";
	}
}
