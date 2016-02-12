package me.shib.java.lib.jbotstats;

import me.shib.java.lib.jtelebot.types.User;
import me.shib.java.lib.jtelebot.types.UserProfilePhotos;

import java.util.LinkedList;
import java.util.Queue;

public class AnalyticsWorker extends Thread {

    private boolean enabled;
    private JBotStats jBotStats;
    private Queue<AnalyticsData> analyticsDataQueue;

    public AnalyticsWorker(JBotStats jBotStats) {
        this.enabled = true;
        this.jBotStats = jBotStats;
        this.analyticsDataQueue = new LinkedList<>();
    }

    private long getLong(Object object) {
        long val;
        try {
            val = (long) object;
        } catch (Exception e) {
            val = 0;
        }
        return val;
    }

    private int getInt(Object object) {
        int val;
        try {
            val = (int) object;
        } catch (Exception e) {
            val = 0;
        }
        return val;
    }

    private User getUser(Object object) {
        User user;
        try {
            user = (User) object;
        } catch (Exception e) {
            user = null;
        }
        return user;
    }

    private UserProfilePhotos getUserProfilePhotos(Object object) {
        UserProfilePhotos photos;
        try {
            photos = (UserProfilePhotos) object;
        } catch (Exception e) {
            photos = null;
        }
        return photos;
    }

    @Override
    public void run() {
        while (enabled) {
            AnalyticsData analyticsData = analyticsDataQueue.poll();
            if (analyticsData != null) {
                String methodName = analyticsData.getMethodName();
                switch (methodName) {
                    case "getMe":
                        jBotStats.onGettingMe(getUser(analyticsData.getReturned()));
                        break;
                    case "getUserProfilePhotos":
                        long user_id;
                        int offset;
                        int limit;
                        UserProfilePhotos photos = getUserProfilePhotos(analyticsData.getReturned());
                        //botStats.onGettingUserProfilePhotos();
                        break;
                    case "getFile":
                        break;
                    case "downloadToFile":
                        break;
                    case "downloadFile":
                        break;
                    case "getUpdates":
                        break;
                    case "sendMessage":
                        break;
                    case "forwardMessage":
                        break;
                    case "sendPhoto":
                        break;
                    case "sendAudio":
                        break;
                    case "sendDocument":
                        break;
                    case "sendSticker":
                        break;
                    case "sendVideo":
                        break;
                    case "sendVoice":
                        break;
                    case "sendLocation":
                        break;
                    case "answerInlineQuery":
                        break;
                    case "sendChatAction":
                        break;
                    default:
                        System.out.println("Unexpected");
                }
            }
        }
    }

    public void putData(AnalyticsData analyticsData) {
        analyticsDataQueue.add(analyticsData);
    }

    public void disableWorker() {
        enabled = false;
    }

}
