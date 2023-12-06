package com.registration.captcher.utils;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.util.WebUtils;

import cn.apiclub.captcha.Captcha;

public class CaptchaDetails implements Serializable{
	private static final long serialVersionUID = -4326389569050611057L;
    private final Captcha captcha;
    
    public CaptchaDetails(HttpServletRequest request) {
		this.captcha = (Captcha) WebUtils.getSessionAttribute(request, "captcha");
	}
    
    public Captcha getCaptcha() {
    	return captcha;
    }

}
