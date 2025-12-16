package com.antoniomarroffino.config;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "ai")
public interface AiConfig {

    /**
     * Provider name (e.g. groq)
     */
    String provider();

    /**
     * Model name (e.g. mixtral-8x7b-32768)
     */
    String model();

    /**
     * API key (read from env: AI_API_KEY)
     */
    String apiKey();
}
