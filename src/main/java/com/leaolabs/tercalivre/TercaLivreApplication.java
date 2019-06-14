package com.leaolabs.tercalivre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class TercaLivreApplication {

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Bem vindo! (Welcome!)";
	}

	@RequestMapping("/health")
	@ResponseBody
	String health() {
		return "API IS OK!";
	}

	public static void main(String[] args) {
		SpringApplication.run(TercaLivreApplication.class, args);
	}

}
