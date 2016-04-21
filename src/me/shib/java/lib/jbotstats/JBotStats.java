package me.shib.java.lib.jbotstats;

import me.shib.java.lib.jtelebot.models.inline.InlineKeyboardMarkup;
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

    public abstract void onSendingMessage(ChatId chat_id, String text, ParseMode parse_mode, boolean disable_web_page_preview, long reply_to_message_id, ReplyMarkup reply_markup, boolean disable_notification, Message response, IOException e, Date accessTime);

    public abstract void onForwardingMessage(ChatId chat_id, ChatId from_chat_id, long message_id, boolean disable_notification, Message response, IOException e, Date accessTime);

    public abstract void onSendingPhoto(ChatId chat_id, InputFile photo, String caption, long reply_to_message_id, ReplyMarkup reply_markup, boolean disable_notification, Message response, IOException e, Date accessTime);

    public abstract void onSendingAudio(ChatId chat_id, InputFile audio, int duration, String performer, String title, long reply_to_message_id, ReplyMarkup reply_markup, boolean disable_notification, Message response, IOException e, Date accessTime);

    public abstract void onSendingDocument(ChatId chat_id, InputFile document, long reply_to_message_id, ReplyMarkup reply_markup, boolean disable_notification, Message response, IOException e, Date accessTime);

    public abstract void onSendingSticker(ChatId chat_id, InputFile sticker, long reply_to_message_id, ReplyMarkup reply_markup, boolean disable_notification, Message response, IOException e, Date accessTime);

    public abstract void onSendingVideo(ChatId chat_id, InputFile video, int duration, String caption, long reply_to_message_id, ReplyMarkup reply_markup, boolean disable_notification, Message response, IOException e, Date accessTime);

    public abstract void onSendingVoice(ChatId chat_id, InputFile voice, int duration, long reply_to_message_id, ReplyMarkup reply_markup, boolean disable_notification, Message response, IOException e, Date accessTime);

    public abstract void onSendingLocation(ChatId chat_id, float latitude, float longitude, long reply_to_message_id, ReplyMarkup reply_markup, boolean disable_notification, Message response, IOException e, Date accessTime);

    public abstract void onAnsweringInlineQuery(String inline_query_id, InlineQueryResult[] results, String next_offset, boolean is_personal, int cache_time, boolean response, IOException e, Date accessTime);

    public abstract void onSendingChatAction(ChatId chat_id, ChatAction action, boolean response, IOException e, Date accessTime);

    public abstract void onSendingContact(ChatId chat_id, String phone_number, String first_name, String last_name, long reply_to_message_id, ReplyMarkup reply_markup, boolean disable_notification, Message response, IOException e, Date accessTime);

    public abstract void onSendingVenue(ChatId chat_id, float latitude, float longitude, String title, String address, String foursquare_id, long reply_to_message_id, ReplyMarkup reply_markup, boolean disable_notification, Message response, IOException e, Date accessTime);

    public abstract void onKickChatMember(ChatId chat_id, long user_id, boolean response, IOException e, Date accessTime);

    public abstract void onUnbanChatMember(ChatId chat_id, long user_id, boolean response, IOException e, Date accessTime);

    public abstract void onAnsweringCallbackQuery(String callback_query_id, String text, boolean show_alert, boolean response, IOException e, Date accessTime);

    public abstract void onEditingMessageText(ChatId chat_id, long message_id, String text, ParseMode parse_mode, boolean disable_web_page_preview, InlineKeyboardMarkup reply_markup, Message response, IOException e, Date accessTime);

    public abstract void onEditingMessageText(String inline_message_id, String text, ParseMode parse_mode, boolean disable_web_page_preview, InlineKeyboardMarkup reply_markup, boolean response, IOException e, Date accessTime);

    public abstract void onEditingMessageCaption(ChatId chat_id, long message_id, String caption, InlineKeyboardMarkup reply_markup, Message response, IOException e, Date accessTime);

    public abstract void onEditingMessageCaption(String inline_message_id, String caption, InlineKeyboardMarkup reply_markup, boolean response, IOException e, Date accessTime);

    public abstract void onEditingMessageReplyMarkup(ChatId chat_id, long message_id, InlineKeyboardMarkup reply_markup, Message response, IOException e, Date accessTime);

    public abstract void onEditingMessageReplyMarkup(String inline_message_id, InlineKeyboardMarkup reply_markup, boolean response, IOException e, Date accessTime);

    public abstract void onOtherData(String methodName, Map<String, Object> objectMap, Object response, IOException e, Date accessTime);
}
