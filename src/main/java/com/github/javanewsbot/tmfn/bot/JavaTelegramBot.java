package com.github.javanewsbot.tmfn.bot;

import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.validation.Valid;

@Component
public class JavaTelegramBot extends TelegramLongPollingBot {

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    //point of entry
    @Override
    public void onUpdateReceived(Update update){

        if(update.hasMessage() && update.getMessage().hasText()){
            String message = update.getMessage().getText().trim();
            String chatID = update.getMessage().getMessageId().toString();

            SendMessage sm = new SendMessage();
            sm.setChatId(chatID);
            sm.setText(message);

            try {
                execute(sm);
            }catch (TelegramApiException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken(){
        return token;
    }
}
