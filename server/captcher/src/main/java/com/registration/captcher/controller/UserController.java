package com.registration.captcher.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.registration.captcher.utils.CaptchaDetails;
import com.registration.captcher.utils.CaptchaGenerator;
import com.registration.captcher.utils.CaptchaUtil;
import com.registration.captcher.utils.MyTextProducer;

import cn.apiclub.captcha.Captcha;

@Controller
@RequestMapping("/user")
@CrossOrigin(origins = { "http://localhost:4200" }, allowCredentials = "true")
@ResponseBody
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/register")
	public User registerUser(@RequestBody User use, HttpServletRequest http) {
		User user = new User();
		getCaptcha(user, http);
		return user;
	}

	@PostMapping("/save")
	public User saveUser(@RequestBody User user, HttpServletRequest http) {
		if (user.getCaptcha().equals(user.getHiddenCaptcha())) {
			service.createUser(user);
			user.setMsg("user create successfull");
			return user;
		} else {
			getCaptcha(user, http);
			user.setErrMsg("capture not matched!");
			return user;
		}
	}

	@PostMapping("/allUsers")
	public List<User> getAllUsers(@RequestBody User user) {
		List<User> userList = service.getAllUsers();
//		model.addAttribute("userList", userList);
		return userList;
	}

	private void getCaptcha(User user, HttpServletRequest http) {
//		Captcha captcha = CaptchaUtil.createCaptcha(240, 70);
		CaptchaGenerator cg = new CaptchaGenerator();
//		CaptchaDetails cg = new CaptchaDetails(http);
		Captcha captcha = cg.createCaptcha(240, 70);
//		Captcha captcha = cg.getCaptcha();
		
		user.setHiddenCaptcha(String.valueOf(cg.getR()));

//		user.setHiddenCaptcha(captcha.getAnswer());
		user.setCaptcha(""); // value entered by the User
		user.setRealCaptcha(CaptchaUtil.encodeCaptcha(captcha));

	}

}
