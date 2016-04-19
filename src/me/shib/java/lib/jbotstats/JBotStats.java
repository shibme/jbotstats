package me.shib.java.lib.jbotstats;

import me.shib.java.lib.jtelebot.models.inline.InlineQueryResult;
import me.shib.java.lib.jtelebot.models.types.*;
import me.shib.java.lib.jtelebot.models.updates.Message;
import me.shib.java.lib.jtelebot.models.updates.Update;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

public abstract class JBotStats {

    private BotStatsConfig botStatsConfig;
    private User botInfo;

    public JBotStats(BotStatsConfig botStatsConfig, User botInfo) {
        this.botStatsConfig = botStatsConfig;
        this.botInfo = botInfo;
    }

    public BotStatsConfig getBotStatsConfig() {
        return this.botStatsConfig;
    }

    public User getBotInfo() {
        return botInfo;
    }

    public abstract String getAnalyticsRedirectedURL(long user_id, String url);

    public abstract void onReceivingUpdate(Update update, IOException e, Date accessTime);

    public abstract void onGettingMe(User response, IOException e, Date accessTime);

    public abstract void onGettingUserProfilePhotos(long user_id, int offset, int limit, UserProfilePhotos response, IOException e, Date accessTime);

    public abstract void onGettingFile(String file_id, TFile response, IOException e, Date accessTime);

    public abstract void onSendingMessage(ChatId chat_id, String text, boolean disable_notification, ParseMode parse_mode, boolean disable_web_page_preview, long reply_to_message_id, ReplyMarkup reply_markup, Message response, IOException e, Date accessTime);

    public abstract void onForwardingMessage(ChatId chat_id, ChatId from_chat_id, long message_id, boolean disable_notification, Message response, IOException e, Date accessTime);

    public abstract void onSendingPhoto(ChatId chat_id, InputFile photo, boolean disable_notification, String caption, long reply_to_message_id, ReplyMarkup reply_markup, Message response, IOException e, Date accessTime);

    public abstract void onSendingAudio(ChatId chat_id, InputFile audio, boolean disable_notification, int duration, String performer, String title, long reply_to_message_id, ReplyMarkup reply_markup, Message response, IOException e, Date accessTime);

    public abstract void onSendingDocument(ChatId chat_id, InputFile document, boolean disable_notification, long reply_to_message_id, ReplyMarkup reply_markup, Message response, IOException e, Date accessTime);

    public abstract void onSendingSticker(ChatId chat_id, InputFile sticker, boolean disable_notification, long reply_to_message_id, ReplyMarkup reply_markup, Message response, IOException e, Date accessTime);

    public abstract void onSendingVideo(ChatId chat_id, InputFile video, boolean disable_notification, int duration, String caption, long reply_to_message_id, ReplyMarkup reply_markup, Message response, IOException e, Date accessTime);

    public abstract void onSendingVoice(ChatId chat_id, InputFile voice, boolean disable_notification, int duration, long reply_to_message_id, ReplyMarkup reply_markup, Message response, IOException e, Date accessTime);

    public abstract void onSendingLocation(ChatId chat_id, float latitude, float longitude, boolean disable_notification, long reply_to_message_id, ReplyMarkup reply_markup, Message response, IOException e, Date accessTime);

    public abstract void onAnsweringInlineQuery(String inline_query_id, InlineQueryResult[] results, String next_offset, boolean is_personal, int cache_time, boolean response, IOException e, Date accessTime);

    public abstract void onSendingChatAction(ChatId chat_id, ChatAction action, boolean response, IOException e, Date accessTime);

    public abstract void onOtherData(String methodName, Map<String, Object> objectMap, Object response, IOException e, Date accessTime);
}
