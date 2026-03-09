package com.gardenbot.service;

import org.springframework.stereotype.Service;

@Service
public class AIService {

    public String generateReply(String userMessage){

        return "Thanks for contacting our garden service 🌿. "
                + "You asked: " + userMessage
                + ". We offer lawn mowing, garden cleaning and hedge trimming.";
    }

}