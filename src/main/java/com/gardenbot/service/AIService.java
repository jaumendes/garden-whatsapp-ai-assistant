package com.gardenbot.service;

import org.springframework.stereotype.Service;


@Service
public class AIService {

    @Value("${OPENAI_API_KEY}")
    private String apiKey;

}

@Service
public class AIService {

    @Value("${OPENAI_API_KEY}")
    private String apiKey;

    public String generateReply(String message){

        OpenAI client = new OpenAI(apiKey);

        ChatCompletion completion = client.chat().completions().create(
            ChatCompletionCreateParams.builder()
                .model("gpt-4o-mini")
                .addUserMessage(message)
                .build()
        );

        return completion.choices().get(0).message().content().get();
    }
}

