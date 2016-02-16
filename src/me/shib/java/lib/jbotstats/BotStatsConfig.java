package me.shib.java.lib.jbotstats;

import java.util.HashMap;
import java.util.Map;

public class BotStatsConfig {

    private String botStatsClassName;
    private long botUserId;
    private Map<String, String> otherConfig;

    public BotStatsConfig(Class<JBotStats> botStatsClass, long botUserId) {
        this.botStatsClassName = botStatsClass.getName();
        this.botUserId = botUserId;
    }

    public long getBotUserId() {
        return this.botUserId;
    }

    public void setBotUserId(long botUserId) {
        if (botUserId > 0) {
            this.botUserId = botUserId;
        }
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
