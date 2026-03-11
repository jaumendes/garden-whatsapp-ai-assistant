package com.gardenbot.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import okhttp3.*;

@Service
public class AIService {

    @Value("${OPENAI_API_KEY}")
    private String apiKey;

    private final OkHttpClient client = new OkHttpClient();

    public String generateReply(String message) {

        try {

            String json = """
                {
                  "model": "gpt-4o-mini",
                  "messages": [
                    {
                      "role": "system",
                      "content": "You are an assistant for a gardening company called Plantox (plantox.pt). The company provides lawn mowing, hedge trimming, garden cleaning and maintenance services. Help customers understand services and request quotes."
                    },
                    {
                      "role": "user",
                      "content": "%s"
                    }
                  ]
                }
                """.formatted(message);

            RequestBody body = RequestBody.create(
                    json,
                    MediaType.parse("application/json")
            );

            Request request = new Request.Builder()
                    .url("https://api.openai.com/v1/chat/completions")
                    .addHeader("Authorization", "Bearer " + apiKey)
                    .addHeader("Content-Type", "application/json")
                    .post(body)
                    .build();

            Response response = client.newCall(request).execute();

            return response.body().string();

        } catch (Exception e) {
            return "Error contacting AI: " + e.getMessage();
        }
    }
}
