package com.antoniomarroffino.utils;

import com.antoniomarroffino.exceptions.AiExtractionException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private JsonUtil() {
    }

    /**
     * Extracts the JSON string produced by Groq/OpenAI chat completions.
     *
     * @param groqRawResponse full HTTP response body
     * @return pure JSON string (no markdown, no text)
     */
    public static String extractJsonFromGroqResponse(String groqRawResponse) {

        try {
            JsonNode root = MAPPER.readTree(groqRawResponse);

            JsonNode contentNode = root
                    .path("choices")
                    .get(0)
                    .path("message")
                    .path("content");

            if (contentNode.isMissingNode() || contentNode.isNull()) {
                throw new AiExtractionException(
                        "AI response does not contain message content"
                );
            }

            String content = contentNode.asText().trim();

            return cleanJson(content);

        } catch (Exception e) {
            throw new AiExtractionException(
                    "Failed to extract JSON from AI response", e
            );
        }
    }

    /**
     * Removes markdown fences and extra text around JSON.
     */
    private static String cleanJson(String content) {

        // Remove ```json ``` or ```
        content = content
                .replaceAll("(?s)^```json", "")
                .replaceAll("(?s)^```", "")
                .replaceAll("```$", "")
                .trim();

        // Try to isolate JSON object
        int firstBrace = content.indexOf('{');
        int lastBrace = content.lastIndexOf('}');

        if (firstBrace == -1 || lastBrace == -1 || lastBrace <= firstBrace) {
            throw new AiExtractionException(
                    "AI response does not contain a valid JSON object"
            );
        }

        return content.substring(firstBrace, lastBrace + 1).trim();
    }

    /**
     * Escapes a string to be safely embedded in JSON payloads.
     */
    public static String quote(String value) {
        try {
            return MAPPER.writeValueAsString(value);
        } catch (Exception e) {
            throw new RuntimeException("Failed to JSON-escape string", e);
        }
    }
}
