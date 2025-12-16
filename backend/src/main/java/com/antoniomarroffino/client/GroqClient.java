package com.antoniomarroffino.client;

import com.antoniomarroffino.config.AiConfig;
import com.antoniomarroffino.exceptions.AiExtractionException;
import com.antoniomarroffino.utils.JsonUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@ApplicationScoped
public class GroqClient {

    private static final String GROQ_ENDPOINT =
            "https://api.groq.com/openai/v1/chat/completions";

    @Inject
    AiConfig aiConfig;

    private final HttpClient httpClient = HttpClient.newHttpClient();

    public String chat(String prompt) {

        try {
            String payload = """
            {
              "model": "%s",
              "messages": [
                {
                  "role": "system",
                  "content": "You are an AI system specialized in invoice data extraction."
                },
                {
                  "role": "user",
                  "content": %s
                }
              ],
              "temperature": 0
            }
            """.formatted(
                    aiConfig.model(),
                    JsonUtil.quote(prompt)
            );

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(GROQ_ENDPOINT))
                    .header("Authorization", "Bearer " + aiConfig.apiKey())
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(payload))
                    .build();

            HttpResponse<String> response =
                    httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new AiExtractionException(
                        "Groq API error (" + response.statusCode() + "): " + response.body()
                );
            }

            return response.body();

        } catch (Exception e) {
            throw new AiExtractionException("Failed to call Groq API", e);
        }
    }
}
