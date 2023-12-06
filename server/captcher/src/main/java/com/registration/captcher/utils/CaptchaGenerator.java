package com.registration.captcher.utils;

import java.awt.Color;

import org.springframework.beans.factory.InitializingBean;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.BackgroundProducer;
import cn.apiclub.captcha.backgrounds.GradiatedBackgroundProducer;
import cn.apiclub.captcha.backgrounds.TransparentBackgroundProducer;
import cn.apiclub.captcha.noise.CurvedLineNoiseProducer;
import cn.apiclub.captcha.noise.NoiseProducer;
import cn.apiclub.captcha.text.producer.DefaultTextProducer;
import cn.apiclub.captcha.text.producer.TextProducer;
import cn.apiclub.captcha.text.renderer.DefaultWordRenderer;
import cn.apiclub.captcha.text.renderer.WordRenderer;

public class CaptchaGenerator implements InitializingBean {

	private BackgroundProducer backgroundProducer =new GradiatedBackgroundProducer(Color.RED, Color.GREEN);
	private TextProducer textProducer = new MyTextProducer();
	private WordRenderer wordRenderer =new DefaultWordRenderer();
	private NoiseProducer noiseProducer =new CurvedLineNoiseProducer();
	
	private Integer r ;

	public CaptchaGenerator() {
//		this.backgroundProducer = new GradiatedBackgroundProducer(Color.RED, Color.GREEN);
//		this.textProducer = new MyTextProducer();
//		this.wordRenderer = new DefaultWordRenderer();
//		this.noiseProducer = new CurvedLineNoiseProducer();
//		if(textProducer!=null) {
//			this.captureAnswer = ((MyTextProducer) textProducer).getAnswer();
//		}
	}

	public Captcha createCaptcha(int width, int height) {
		Captcha cp = new Captcha.Builder(width, height)
				.addBackground(backgroundProducer)
				.addText(textProducer, wordRenderer)
				.addNoise(noiseProducer).build();

		r = ((MyTextProducer) textProducer).getAnswer();
		return cp;
	}

	

	public Integer getR() {
		return r;
	}

	public void setR(Integer r) {
		this.r = r;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		if (this.backgroundProducer == null) {
			this.backgroundProducer = new GradiatedBackgroundProducer();
		}
		if (this.textProducer == null) {
			this.textProducer = new DefaultTextProducer();
		}
		if (this.wordRenderer == null) {
			this.wordRenderer = new DefaultWordRenderer();
		}
		if (this.noiseProducer == null) {
			this.noiseProducer = new CurvedLineNoiseProducer();
		}
	}

}
