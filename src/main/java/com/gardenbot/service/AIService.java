package com.gardenbot.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.Response;
import com.openai.models.ResponseCreateParams;

@Service
public class AIService {

    @Value("${OPENAI_API_KEY}")
    private String apiKey;

    public String generateReply(String message) {

        OpenAIClient client = OpenAIOkHttpClient.builder()
                .apiKey(apiKey)
                .build();

        Response response = client.responses().create(
                ResponseCreateParams.builder()
                        .model("gpt-4o-mini")
                        .input(message)
                        .build()
        );

        return response.outputText();
    }
}
