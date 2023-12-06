package com.registration.captcher.utils;

import java.io.ByteArrayOutputStream;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.GradiatedBackgroundProducer;
import cn.apiclub.captcha.noise.CurvedLineNoiseProducer;
import cn.apiclub.captcha.text.producer.DefaultTextProducer;

public class CaptchaUtil {

	public static Captcha createCaptcha(int width, int height) {
		return new Captcha.Builder(width, height)
				.addBackground(new GradiatedBackgroundProducer())
				.addText(new DefaultTextProducer())
				.addNoise(new CurvedLineNoiseProducer())
				.build();
		
	}
	
	public static String encodeCaptcha(Captcha captcha) {
		String img = null;
		try {
//			ByteArrayOutputStream bos = new ByteArrayOutputStream();
//			ImageIO.write(captcha.getImage(), "jpg", bos);
//			byte[] byteArray = Base64.getEncoder().encode(bos.toByteArray());
//			img = new String(byteArray);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(captcha.getImage(), "png", outputStream);
            return DatatypeConverter.printBase64Binary(outputStream.toByteArray());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return img;
		
	}
	
}
