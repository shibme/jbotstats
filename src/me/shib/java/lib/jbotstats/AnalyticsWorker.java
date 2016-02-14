package me.shib.java.lib.jbotstats;

import me.shib.java.lib.jtelebot.types.*;

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

    private float getFloat(Object object) {
        float val;
        try {
            val = (float) object;
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

    private TelegramFile getTelegramFile(Object object) {
        TelegramFile telegramFile;
        try {
            telegramFile = (TelegramFile) object;
        } catch (Exception e) {
            telegramFile = null;
        }
        return telegramFile;
    }

    private Update getUpdate(Object object) {
        Update update;
        try {
            update = (Update) object;
        } catch (Exception e) {
            update = null;
        }
        return update;
    }

    private Message getMessage(Object object) {
        Message message;
        try {
            message = (Message) object;
        } catch (Exception e) {
            message = null;
        }
        return message;
    }

    private ReplyMarkup getReplyMarkup(Object object) {
        ReplyMarkup replyMarkup;
        try {
            replyMarkup = (ReplyMarkup) object;
        } catch (Exception e) {
            replyMarkup = null;
        }
        return replyMarkup;
    }

    private boolean getBoolean(Object object) {
        boolean bool;
        try {
            bool = (boolean) object;
        } catch (Exception e) {
            bool = false;
        }
        return bool;
    }

    private ParseMode getParseMode(Object object) {
        ParseMode parseMode;
        try {
            parseMode = (ParseMode) object;
        } catch (Exception e) {
            parseMode = null;
        }
        return parseMode;
    }

    private ChatId getChatId(Object object) {
        ChatId chatId;
        try {
            chatId = (ChatId) object;
        } catch (Exception e) {
            chatId = null;
        }
        return chatId;
    }

    private InlineQueryResult[] getInlineQueryResults(Object object) {
        InlineQueryResult[] results;
        try {
            results = (InlineQueryResult[]) object;
        } catch (Exception e) {
            results = null;
        }
        return results;
    }

    private ChatAction getChatAction(Object object) {
        ChatAction action;
        try {
            action = (ChatAction) object;
        } catch (Exception e) {
            action = null;
        }
        return action;
    }

    private String getString(Object object) {
        String string;
        try {
            string = (String) object;
        } catch (Exception e) {
            string = null;
        }
        return string;
    }

    @Override
    public void run() {
        while (enabled) {
            AnalyticsData analyticsData = analyticsDataQueue.poll();
            if (analyticsData != null) {
                String methodName = analyticsData.getMethodName();
                long message_id = getLong(analyticsData.getValue("message_id"));
                long user_id = getLong(analyticsData.getValue("user_id"));
                int offset = getInt(analyticsData.getValue("offset"));
                int limit = getInt(analyticsData.getValue("limit"));
                int duration = getInt(analyticsData.getValue("duration"));
                int cache_time = getInt(analyticsData.getValue("cache_time"));
                float latitude = getFloat(analyticsData.getValue("latitude"));
                float longitude = getFloat(analyticsData.getValue("longitude"));
                String inline_query_id = getString(analyticsData.getValue("inline_query_id"));
                String next_offset = getString(analyticsData.getValue("next_offset"));
                String file_id = getString(analyticsData.getValue("file_id"));
                String caption = getString(analyticsData.getValue("caption"));
                String title = getString(analyticsData.getValue("title"));
                String performer = getString(analyticsData.getValue("performer"));
                ChatId chat_id = getChatId(analyticsData.getValue("chat_id"));
                String text = getString(analyticsData.getValue("parse_mode"));
                ParseMode parse_mode = getParseMode(analyticsData.getValue("parse_mode"));
                boolean disable_web_page_preview = getBoolean(analyticsData.getValue("disable_web_page_preview"));
                boolean is_personal = getBoolean(analyticsData.getValue("is_personal"));
                long reply_to_message_id = getLong(analyticsData.getValue("reply_to_message_id"));
                ReplyMarkup reply_markup = getReplyMarkup(analyticsData.getValue("reply_markup"));
                ChatId from_chat_id = getChatId(analyticsData.getValue("from_chat_id"));
                TelegramFile photo = getTelegramFile(analyticsData.getValue("photo"));
                TelegramFile audio = getTelegramFile(analyticsData.getValue("audio"));
                TelegramFile document = getTelegramFile(analyticsData.getValue("document"));
                TelegramFile sticker = getTelegramFile(analyticsData.getValue("sticker"));
                TelegramFile video = getTelegramFile(analyticsData.getValue("video"));
                TelegramFile voice = getTelegramFile(analyticsData.getValue("voice"));
                InlineQueryResult[] results = getInlineQueryResults(analyticsData.getValue("results"));
                ChatAction action = getChatAction(analyticsData.getValue("action"));
                switch (methodName) {
                    case "getMe":
                        jBotStats.onGettingMe(getUser(analyticsData.getReturned()));
                        break;
                    case "getUserProfilePhotos":
                        jBotStats.onGettingUserProfilePhotos(user_id, offset, limit, getUserProfilePhotos(analyticsData.getReturned()));
                        break;
                    case "getFile":
                        jBotStats.onGettingFile(file_id, getTelegramFile(analyticsData.getReturned()));
                        break;
                    case "getUpdates":
                        jBotStats.onReceivingUpdate(getUpdate(analyticsData.getReturned()));
                        break;
                    case "sendMessage":
                        jBotStats.onSendingMessage(chat_id, text, parse_mode, disable_web_page_preview, reply_to_message_id, reply_markup, getMessage(analyticsData.getReturned()));
                        break;
                    case "forwardMessage":
                        jBotStats.onForwardingMessage(chat_id, from_chat_id, message_id, getMessage(analyticsData.getReturned()));
                        break;
                    case "sendPhoto":
                        jBotStats.onSendingPhoto(chat_id, photo, caption, reply_to_message_id, reply_markup, getMessage(analyticsData.getReturned()));
                        break;
                    case "sendAudio":
                        jBotStats.onSendingAudio(chat_id, audio, duration, performer, title, reply_to_message_id, reply_markup, getMessage(analyticsData.getReturned()));
                        break;
                    case "sendDocument":
                        jBotStats.onSendingDocument(chat_id, document, reply_to_message_id, reply_markup, getMessage(analyticsData.getReturned()));
                        break;
                    case "sendSticker":
                        jBotStats.onSendingSticker(chat_id, sticker, reply_to_message_id, reply_markup, getMessage(analyticsData.getReturned()));
                        break;
                    case "sendVideo":
                        jBotStats.onSendingVideo(chat_id, video, duration, caption, reply_to_message_id, reply_markup, getMessage(analyticsData.getReturned()));
                        break;
                    case "sendVoice":
                        jBotStats.onSendingVoice(chat_id, voice, duration, reply_to_message_id, reply_markup, getMessage(analyticsData.getReturned()));
                        break;
                    case "sendLocation":
                        jBotStats.onSendingLocation(chat_id, latitude, longitude, reply_to_message_id, reply_markup, getMessage(analyticsData.getReturned()));
                        break;
                    case "answerInlineQuery":
                        jBotStats.onAnsweringInlineQuery(inline_query_id, results, next_offset, is_personal, cache_time, getBoolean(analyticsData.getReturned()));
                        break;
                    case "sendChatAction":
                        jBotStats.onSendingChatAction(chat_id, action, getBoolean(analyticsData.getReturned()));
                        break;
                    default:
                        jBotStats.onOtherData(analyticsData.getMethodName(), analyticsData.getObjectMap());
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