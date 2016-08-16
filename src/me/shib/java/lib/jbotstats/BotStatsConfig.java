package me.shib.java.lib.jbotstats;

import java.util.HashMap;
import java.util.Map;

public final class BotStatsConfig {

    private Class<JBotStats> botStatsClass;
    private String token;
    private Map<String, String> botStatsConstants;

    public BotStatsConfig(Class<JBotStats> botStatsClass, String token) {
        this.botStatsClass = botStatsClass;
        this.token = token;
        this.botStatsConstants = new HashMap<>();
    }

    public String getToken() {
        return token;
    }

    public Class<JBotStats> getBotStatsClass() {
        return botStatsClass;
    }

    public void setConfig(String key, String value) {
        botStatsConstants.put(key, value);
    }

    public String getConfig(String key) {
        if (botStatsConstants == null) {
            return null;
        }
        return botStatsConstants.get(key);
    }

}