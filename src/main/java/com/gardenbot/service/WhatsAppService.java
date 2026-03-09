package com.gardenbot.service;

import org.springframework.stereotype.Service;

@Service
public class WhatsAppService {

    public void sendMessage(String phone, String message){

        System.out.println("Sending message to " + phone);
        System.out.println("Message: " + message);

    }

}