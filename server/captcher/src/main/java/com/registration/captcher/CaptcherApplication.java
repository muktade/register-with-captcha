package com.registration.captcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.registration.captcher.utils.CaptchaGenerator;

@SpringBootApplication
public class CaptcherApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaptcherApplication.class, args);
	}

	@Bean
    public CaptchaGenerator getCaptchaGenerator(){
        return new CaptchaGenerator();
    }
}
