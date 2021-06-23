package com.github.javanewsbot.tmfn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@SpringBootApplication
public class TelegramBotForNewsApplication {

	public static void main(String[] args) throws TelegramApiException {
		SpringApplication.run(TelegramBotForNewsApplication.class, args);
	}


}
