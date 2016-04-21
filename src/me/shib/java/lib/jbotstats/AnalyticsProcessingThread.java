package me.shib.java.lib.jbotstats;

import me.shib.java.lib.jtelebot.models.inline.InlineKeyboardMarkup;
import me.shib.java.lib.jtelebot.models.inline.InlineQueryResult;
import me.shib.java.lib.jtelebot.models.types.*;
import me.shib.java.lib.jtelebot.models.updates.Message;
import me.shib.java.lib.jtelebot.models.updates.Update;

import java.io.IOException;
import java.util.Date;
import java.util.Queue;
import java.util.logging.Logger;

public final class AnalyticsProcessingThread extends Thread {

    private static final long waitBeforeEndInterval = 1000;
    private static final long maxCallBackCount = 7;

    private static Logger logger = Logger.getLogger(AnalyticsProcessingThread.class.getName());

    private JBotStats jBotStats;
    private Queue<AnalyticsData> analyticsDataQueue;

    public AnalyticsProcessingThread(JBotStats jBotStats, Queue<AnalyticsData> analyticsDataQueue) {
        this.jBotStats = jBotStats;
        this.analyticsDataQueue = analyticsDataQueue;
    }

    private static long getLong(Object object) {
        long val;
        try {
            val = (long) object;
        } catch (Exception e) {
            val = 0;
        }
        return val;
    }

    private static float getFloat(Object object) {
        float val;
        try {
            val = (float) object;
        } catch (Exception e) {
            val = 0;
        }
        return val;
    }

    private static int getInt(Object object) {
        int val;
        try {
            val = (int) object;
        } catch (Exception e) {
            val = 0;
        }
        return val;
    }

    private static User getUser(Object object) {
        User user;
        try {
            user = (User) object;
        } catch (Exception e) {
            user = null;
        }
        return user;
    }

    private static UserProfilePhotos getUserProfilePhotos(Object object) {
        UserProfilePhotos photos;
        try {
            photos = (UserProfilePhotos) object;
        } catch (Exception e) {
            photos = null;
        }
        return photos;
    }

    private static InputFile getInputFile(Object object) {
        InputFile telegramFile;
        try {
            telegramFile = (InputFile) object;
        } catch (Exception e) {
            telegramFile = null;
        }
        return telegramFile;
    }

    private static TFile getTFile(Object object) {
        TFile telegramFile;
        try {
            telegramFile = (TFile) object;
        } catch (Exception e) {
            telegramFile = null;
        }
        return telegramFile;
    }

    private static Update getUpdate(Object object) {
        Update update;
        try {
            update = (Update) object;
        } catch (Exception e) {
            update = null;
        }
        return update;
    }

    private static Message getMessage(Object object) {
        Message message;
        try {
            message = (Message) object;
        } catch (Exception e) {
            message = null;
        }
        return message;
    }

    private static ReplyMarkup getReplyMarkup(Object object) {
        ReplyMarkup replyMarkup;
        try {
            replyMarkup = (ReplyMarkup) object;
        } catch (Exception e) {
            replyMarkup = null;
        }
        return replyMarkup;
    }

    private static InlineKeyboardMarkup getInlineKeyboardMarkup(Object object) {
        InlineKeyboardMarkup replyMarkup;
        try {
            replyMarkup = (InlineKeyboardMarkup) object;
        } catch (Exception e) {
            replyMarkup = null;
        }
        return replyMarkup;
    }

    private static boolean getBoolean(Object object) {
        boolean bool;
        try {
            bool = (boolean) object;
        } catch (Exception e) {
            bool = false;
        }
        return bool;
    }

    private static ParseMode getParseMode(Object object) {
        ParseMode parseMode;
        try {
            parseMode = (ParseMode) object;
        } catch (Exception e) {
            parseMode = null;
        }
        return parseMode;
    }

    private static ChatId getChatId(Object object) {
        ChatId chatId;
        try {
            chatId = (ChatId) object;
        } catch (Exception e) {
            chatId = null;
        }
        return chatId;
    }

    private static InlineQueryResult[] getInlineQueryResults(Object object) {
        InlineQueryResult[] results;
        try {
            results = (InlineQueryResult[]) object;
        } catch (Exception e) {
            results = null;
        }
        return results;
    }

    private static ChatAction getChatAction(Object object) {
        ChatAction action;
        try {
            action = (ChatAction) object;
        } catch (Exception e) {
            action = null;
        }
        return action;
    }

    private static String getString(Object object) {
        String string;
        try {
            string = (String) object;
        } catch (Exception e) {
            string = null;
        }
        return string;
    }

    private boolean processAnalyticsData() {
        boolean processedSomething = false;
        AnalyticsData analyticsData;
        while ((analyticsData = analyticsDataQueue.poll()) != null) {
            processedSomething = true;
            boolean disable_web_page_preview = getBoolean(analyticsData.getValue("disable_web_page_preview"));
            boolean disable_notification = getBoolean(analyticsData.getValue("disable_notification"));
            boolean is_personal = getBoolean(analyticsData.getValue("is_personal"));
            boolean show_alert = getBoolean(analyticsData.getValue("show_alert"));
            long reply_to_message_id = getLong(analyticsData.getValue("reply_to_message_id"));
            long message_id = getLong(analyticsData.getValue("message_id"));
            long user_id = getLong(analyticsData.getValue("user_id"));
            int offset = getInt(analyticsData.getValue("offset"));
            int limit = getInt(analyticsData.getValue("limit"));
            int duration = getInt(analyticsData.getValue("duration"));
            int cache_time = getInt(analyticsData.getValue("cache_time"));
            float latitude = getFloat(analyticsData.getValue("latitude"));
            float longitude = getFloat(analyticsData.getValue("longitude"));
            String methodName = analyticsData.getMethodName();
            String inline_query_id = getString(analyticsData.getValue("inline_query_id"));
            String next_offset = getString(analyticsData.getValue("next_offset"));
            String file_id = getString(analyticsData.getValue("file_id"));
            String caption = getString(analyticsData.getValue("caption"));
            String title = getString(analyticsData.getValue("title"));
            String performer = getString(analyticsData.getValue("performer"));
            String text = getString(analyticsData.getValue("parse_mode"));
            String phone_number = getString(analyticsData.getValue("phone_number"));
            String first_name = getString(analyticsData.getValue("first_name"));
            String last_name = getString(analyticsData.getValue("last_name"));
            String address = getString(analyticsData.getValue("address"));
            String foursquare_id = getString(analyticsData.getValue("foursquare_id"));
            String callback_query_id = getString(analyticsData.getValue("callback_query_id"));
            String inline_message_id = getString(analyticsData.getValue("inline_message_id"));
            ChatId chat_id = getChatId(analyticsData.getValue("chat_id"));
            ChatId from_chat_id = getChatId(analyticsData.getValue("from_chat_id"));
            ParseMode parse_mode = getParseMode(analyticsData.getValue("parse_mode"));
            ReplyMarkup reply_markup = getReplyMarkup(analyticsData.getValue("reply_markup"));
            InputFile photo = getInputFile(analyticsData.getValue("photo"));
            InputFile audio = getInputFile(analyticsData.getValue("audio"));
            InputFile document = getInputFile(analyticsData.getValue("document"));
            InputFile sticker = getInputFile(analyticsData.getValue("sticker"));
            InputFile video = getInputFile(analyticsData.getValue("video"));
            InputFile voice = getInputFile(analyticsData.getValue("voice"));
            InlineQueryResult[] results = getInlineQueryResults(analyticsData.getValue("results"));
            ChatAction action = getChatAction(analyticsData.getValue("action"));
            IOException ioException = analyticsData.getIoException();
            Date accessTime = analyticsData.getAccessTime();
            switch (methodName) {
                case "getMe":
                    jBotStats.onGettingMe(getUser(analyticsData.getReturned()), ioException, accessTime);
                    break;
                case "getUserProfilePhotos":
                    jBotStats.onGettingUserProfilePhotos(user_id, offset, limit, getUserProfilePhotos(analyticsData.getReturned()), ioException, accessTime);
                    break;
                case "getFile":
                    jBotStats.onGettingFile(file_id, getTFile(analyticsData.getReturned()), ioException, accessTime);
                    break;
                case "getUpdates":
                    jBotStats.onReceivingUpdate(getUpdate(analyticsData.getReturned()), ioException, accessTime);
                    break;
                case "sendMessage":
                    jBotStats.onSendingMessage(chat_id, text, parse_mode, disable_web_page_preview, reply_to_message_id, reply_markup, disable_notification, getMessage(analyticsData.getReturned()), ioException, accessTime);
                    break;
                case "forwardMessage":
                    jBotStats.onForwardingMessage(chat_id, from_chat_id, message_id, disable_notification, getMessage(analyticsData.getReturned()), ioException, accessTime);
                    break;
                case "sendPhoto":
                    jBotStats.onSendingPhoto(chat_id, photo, caption, reply_to_message_id, reply_markup, disable_notification, getMessage(analyticsData.getReturned()), ioException, accessTime);
                    break;
                case "sendAudio":
                    jBotStats.onSendingAudio(chat_id, audio, duration, performer, title, reply_to_message_id, reply_markup, disable_notification, getMessage(analyticsData.getReturned()), ioException, accessTime);
                    break;
                case "sendDocument":
                    jBotStats.onSendingDocument(chat_id, document, reply_to_message_id, reply_markup, disable_notification, getMessage(analyticsData.getReturned()), ioException, accessTime);
                    break;
                case "sendSticker":
                    jBotStats.onSendingSticker(chat_id, sticker, reply_to_message_id, reply_markup, disable_notification, getMessage(analyticsData.getReturned()), ioException, accessTime);
                    break;
                case "sendVideo":
                    jBotStats.onSendingVideo(chat_id, video, duration, caption, reply_to_message_id, reply_markup, disable_notification, getMessage(analyticsData.getReturned()), ioException, accessTime);
                    break;
                case "sendVoice":
                    jBotStats.onSendingVoice(chat_id, voice, duration, reply_to_message_id, reply_markup, disable_notification, getMessage(analyticsData.getReturned()), ioException, accessTime);
                    break;
                case "sendLocation":
                    jBotStats.onSendingLocation(chat_id, latitude, longitude, reply_to_message_id, reply_markup, disable_notification, getMessage(analyticsData.getReturned()), ioException, accessTime);
                    break;
                case "sendContact":
                    jBotStats.onSendingContact(chat_id, phone_number, first_name, last_name, reply_to_message_id, reply_markup, disable_notification, getMessage(analyticsData.getReturned()), ioException, accessTime);
                    break;
                case "sendVenue":
                    jBotStats.onSendingVenue(chat_id, latitude, longitude, title, address, foursquare_id, reply_to_message_id, reply_markup, disable_notification, getMessage(analyticsData.getReturned()), ioException, accessTime);
                    break;
                case "kickChatMember":
                    jBotStats.onKickChatMember(chat_id, user_id, getBoolean(analyticsData.getReturned()), ioException, accessTime);
                    break;
                case "unbanChatMember":
                    jBotStats.onUnbanChatMember(chat_id, user_id, getBoolean(analyticsData.getReturned()), ioException, accessTime);
                    break;
                case "answerInlineQuery":
                    jBotStats.onAnsweringInlineQuery(inline_query_id, results, next_offset, is_personal, cache_time, getBoolean(analyticsData.getReturned()), ioException, accessTime);
                    break;
                case "answerCallbackQuery":
                    jBotStats.onAnsweringCallbackQuery(callback_query_id, text, show_alert, getBoolean(analyticsData.getReturned()), ioException, accessTime);
                    break;
                case "editMessageText":
                    if (chat_id != null) {
                        jBotStats.onEditingMessageText(chat_id, message_id, text, parse_mode, disable_web_page_preview, getInlineKeyboardMarkup(reply_markup), getMessage(analyticsData.getReturned()), ioException, accessTime);
                    } else if (inline_message_id != null) {
                        jBotStats.onEditingMessageText(inline_message_id, text, parse_mode, disable_web_page_preview, getInlineKeyboardMarkup(reply_markup), getBoolean(analyticsData.getReturned()), ioException, accessTime);
                    }
                    break;
                case "editMessageCaption":
                    if (chat_id != null) {
                        jBotStats.onEditingMessageCaption(chat_id, message_id, caption, getInlineKeyboardMarkup(reply_markup), getMessage(analyticsData.getReturned()), ioException, accessTime);
                    } else if (inline_message_id != null) {
                        jBotStats.onEditingMessageCaption(inline_message_id, caption, getInlineKeyboardMarkup(reply_markup), getBoolean(analyticsData.getReturned()), ioException, accessTime);
                    }
                    break;
                case "editMessageReplyMarkup":
                    if (chat_id != null) {
                        jBotStats.onEditingMessageReplyMarkup(chat_id, message_id, getInlineKeyboardMarkup(reply_markup), getMessage(analyticsData.getReturned()), ioException, accessTime);
                    } else if (inline_message_id != null) {
                        jBotStats.onEditingMessageReplyMarkup(inline_message_id, getInlineKeyboardMarkup(reply_markup), getBoolean(analyticsData.getReturned()), ioException, accessTime);
                    }
                    break;
                case "sendChatAction":
                    jBotStats.onSendingChatAction(chat_id, action, getBoolean(analyticsData.getReturned()), ioException, accessTime);
                    break;
                default:
                    jBotStats.onOtherData(analyticsData.getMethodName(), analyticsData.getObjectMap(), analyticsData.getReturned(), ioException, accessTime);
            }
        }
        return processedSomething;
    }

    @Override
    public void run() {
        int callbackMade = 0;
        while (callbackMade <= maxCallBackCount) {
            if (processAnalyticsData()) {
                callbackMade = 0;
            } else {
                callbackMade++;
                try {
                    Thread.sleep(waitBeforeEndInterval);
                } catch (InterruptedException e) {
                    logger.throwing(this.getClass().getName(), "run", e);
                }
            }
        }
    }
}
