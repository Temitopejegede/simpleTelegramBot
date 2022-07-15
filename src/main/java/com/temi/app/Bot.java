package com.temi.app;

import com.temi.utils.AppConstants;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;

public class Bot extends TelegramLongPollingBot {

    String text;
    @Override
    public String getBotUsername() {
        return AppConstants.USERNAME;
    }

    @Override
    public String getBotToken() {
        return AppConstants.TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        text = update.getMessage().getFrom().getFirstName() +
                " " + update.getMessage().getFrom().getLastName() +
                ": " + update.getMessage().getText();
        System.out.println(text);

        String alternate = update.getMessage().getText();

        SendMessage response = new SendMessage();
        response.setChatId(update.getMessage().getChatId().toString());
        response.setText(answer(alternate));

        try{
            execute(response);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    public String answer(String question){
        Answers answers = new Answers();
        HashMap<String, String> commonResponses = answers.populate();
        return commonResponses.get(question);
    }


}
