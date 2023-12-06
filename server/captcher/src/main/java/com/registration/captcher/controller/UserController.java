package com.registration.captcher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.registration.captcher.entiry.User;
import com.registration.captcher.service.UserService;
import com.registration.captcher.utils.CaptchaUtil;

import cn.apiclub.captcha.Captcha;

@Controller
@RequestMapping("/user")
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")
@ResponseBody
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/register")
	public User registerUser() {
		User user = new User();
		getCaptcha(user);
//		model.addAttribute("user", user);
//		return "registerUser";
		System.out.println(user.getCaptcha());
		return user;
	}

	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return service.createUser(user);
		
				//		if (user.getCaptcha().equals(user.getHiddenCaptcha())) {
//			service.createUser(user);
//			
//			return user;
//		} else {
////			getCaptcha(user);
////			model.addAttribute("user", user);
//			return user;
//		}
//		return "registerUser";
	}

	@PostMapping("/allUsers")
	public List<User> getAllUsers(@RequestBody User user) {
		List<User> userList = service.getAllUsers();
//		model.addAttribute("userList", userList);
		return userList;
	}

	private void getCaptcha(User user) {
		Captcha captcha = CaptchaUtil.createCaptcha(240, 70);
		user.setHiddenCaptcha(captcha.getAnswer());
		user.setCaptcha(""); // value entered by the User
		user.setRealCaptcha(CaptchaUtil.encodeCaptcha(captcha));

	}

}
