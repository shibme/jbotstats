package me.shib.java.lib.jbotstats;

import java.util.HashMap;
import java.util.Map;

public class BotStatsConfig {

    private String botStatsClassName;
    private String token;
    private Map<String, String> otherConfig;

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
        if (otherConfig == null) {
            otherConfig = new HashMap<>();
        }
        otherConfig.put(key, value);
    }

    public String getConfig(String key) {
        if (otherConfig == null) {
            return null;
        }
        return otherConfig.get(key);
    }

}