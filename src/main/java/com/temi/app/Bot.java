package com.temi.app;

import com.temi.utils.AppConstants;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramLongPollingBot {


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
        String text = update.getMessage().getFrom().getFirstName() +
                " " + update.getMessage().getFrom().getLastName() +
                ": " + update.getMessage().getText();
        System.out.println(text);
    }
}
