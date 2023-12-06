package com.registration.captcher.utils;

import java.util.Random;

import cn.apiclub.captcha.text.producer.TextProducer;

public class MyTextProducer implements TextProducer {
	private int answer;

	@Override
	public String getText() {
		
		Random r = new Random();
		int r1= r.nextInt(10);
		int r2 = r.nextInt(10);
		int sum = r1+r2;
		this.setAnswer(sum);
		StringBuffer cap = new StringBuffer();
		cap.append(r1 + " + " +r2 +" = ?");
		System.out.println(cap.toString());
		return cap.toString();
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}
	
	

}
