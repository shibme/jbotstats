package me.shib.java.lib.jbotstats;

import java.util.HashMap;
import java.util.Map;

public class BotStatsConfig {

    private String botStatsClassName;
    private String token;
    private Map<String, String> botStatsConfig;

    public BotStatsConfig(Class<JBotStats> botStatsClass, String token) {
        this.botStatsClassName = botStatsClass.getName();
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getBotStatsClassName() {
        return botStatsClassName;
    }

    public void setConfig(String key, String value) {
        if (botStatsConfig == null) {
            botStatsConfig = new HashMap<>();
        }
        botStatsConfig.put(key, value);
    }

    public String getConfig(String key) {
        if (botStatsConfig == null) {
            return null;
        }
        return botStatsConfig.get(key);
    }

}