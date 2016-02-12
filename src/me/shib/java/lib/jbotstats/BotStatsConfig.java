package me.shib.java.lib.jbotstats;

public class BotStatsConfig {

    private String botStatsClassName;

    public BotStatsConfig(Class<JBotStats> botStatsClass) {
        this.botStatsClassName = botStatsClass.getName();
    }

    public String getBotStatsClassName() {
        return botStatsClassName;
    }
}
