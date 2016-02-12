package me.shib.java.lib.jbotstats;

import me.shib.java.lib.jtelebot.types.*;

public abstract class JBotStats {
    public JBotStats(BotStatsConfig botStatsConfig) {
    }

    public abstract void onReceivingUpdate(Update update);

    public abstract void onGettingMe(User response);

    public abstract void onGettingUserProfilePhotos(long user_id, int offset, int limit, UserProfilePhotos response);

    public abstract void onGettingFile(String file_id, TelegramFile response);

    public abstract void onSendingMessage(ChatId chat_id, String text, ParseMode parse_mode, boolean disable_web_page_preview, long reply_to_message_id, ReplyMarkup reply_markup, Message response);

    public abstract void onForwardingMessage(ChatId chat_id, ChatId from_chat_id, long message_id, Message response);

    public abstract void onSendingPhoto(ChatId chat_id, TelegramFile photo, String caption, long reply_to_message_id, ReplyMarkup reply_markup, Message response);

    public abstract void onSendingAudio(ChatId chat_id, TelegramFile audio, int duration, String performer, String title, long reply_to_message_id, ReplyMarkup reply_markup, Message response);

    public abstract void onSendingDocument(ChatId chat_id, TelegramFile document, long reply_to_message_id, ReplyMarkup reply_markup, Message response);

    public abstract void onSendingSticker(ChatId chat_id, TelegramFile sticker, long reply_to_message_id, ReplyMarkup reply_markup, Message response);

    public abstract void onSendingVideo(ChatId chat_id, TelegramFile video, int duration, String caption, long reply_to_message_id, ReplyMarkup reply_markup, Message response);

    public abstract void onSendingVoice(ChatId chat_id, TelegramFile voice, int duration, long reply_to_message_id, ReplyMarkup reply_markup, Message response);

    public abstract void onSendingLocation(ChatId chat_id, float latitude, float longitude, long reply_to_message_id, ReplyMarkup reply_markup, Message response);

    public abstract void onAnsweringInlineQuery(String inline_query_id, InlineQueryResult[] results, String next_offset, boolean is_personal, int cache_time, boolean response);

    public abstract void onSendingChatAction(ChatId chat_id, ChatAction action, boolean response);

    public abstract void onUnknownData(Object[] objects);
}
