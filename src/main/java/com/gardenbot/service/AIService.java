package com.gardenbot.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;

import com.openai.models.ChatCompletion;
import com.openai.models.ChatCompletionCreateParams;
import com.openai.models.ChatCompletionUserMessageParam;
import com.openai.models.ChatCompletionUserMessageParam.Content;

@Service
public class AIService {

    @Value("${OPENAI_API_KEY}")
    private String apiKey;

    public String generateReply(String message) {

        OpenAIClient client = OpenAIOkHttpClient.builder()
                .apiKey(apiKey)
                .build();

        ChatCompletion completion = client.chat().completions().create(
                ChatCompletionCreateParams.builder()
                        .model("gpt-4o-mini")
                        .addMessage(
                                ChatCompletionUserMessageParam.builder()
                                        .content(Content.ofText(message))
                                        .build()
                        )
                        .build()
        );

        return completion.choices().get(0).message().content().get();

    }
}
