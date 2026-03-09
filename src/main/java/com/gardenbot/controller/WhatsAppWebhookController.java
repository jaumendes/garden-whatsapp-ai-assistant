package com.gardenbot.controller;

import com.gardenbot.model.MessageRequest;
import com.gardenbot.service.AIService;
import com.gardenbot.service.WhatsAppService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class WhatsAppWebhookController {

    private final AIService aiService;
    private final WhatsAppService whatsappService;

    public WhatsAppWebhookController(AIService aiService, WhatsAppService whatsappService) {
        this.aiService = aiService;
        this.whatsappService = whatsappService;
    }

    @PostMapping("/whatsapp")
    public String receive(@RequestBody MessageRequest request){

        String reply = aiService.generateReply(request.getMessage());
        whatsappService.sendMessage(request.getFrom(), reply);

        return reply;
    }
}