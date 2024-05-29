package com.jaydip.fancyfontskeyboard.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Date;

public final class SharedPreferenceProvider {
    private final String ADS_COUNT = "adscount";
    private final String CURRENT_FONT = "current_font";
    private final String LAST_USED_DATE = "last_used_date";
    private final String REVIEW_PROMPT = "last_review_prompt";
    private String SHARED_PREFERENCE_FILENAME = "";
    private final String USED_KEYBOARD = "used_keyboard";
    private final SharedPreferences prefs;

    public SharedPreferenceProvider(Context context) {
        String str = context.getPackageName() + ".sharedpref";
        this.SHARED_PREFERENCE_FILENAME = str;
        this.prefs = context.getSharedPreferences(str, 0);
    }

    public final int getCurrentFontIndex() {
        return this.prefs.getInt("current_font", 0);
    }

    public final void setCurrentFontIndex(int i) {
        this.prefs.edit().putInt("current_font", i).apply();
    }

    public final void setADS_COUNT(int i) {
        this.prefs.edit().putInt("adscount", i).apply();
    }

    public final int getADS_COUNT() {
        return this.prefs.getInt("adscount", 0);
    }

    public final int getUsedKeyboardCount() {
        return this.prefs.getInt("used_keyboard", 0);
    }

    public final void setUsedKeyboardCount(int i) {
        this.prefs.edit().putInt("used_keyboard", i).apply();
    }

    public final Date getReviewPromptDate() {
        return new Date(this.prefs.getLong("last_review_prompt", -1));
    }

    public final void setReviewPromptDate(Date date) {
        this.prefs.edit().putLong("last_review_prompt", date.getTime()).apply();
    }

    public final Date getLastUsedDate() {
        return new Date(this.prefs.getLong("last_used_date", -1));
    }

    public final void setLastUsedDate(Date date) {
        this.prefs.edit().putLong("last_used_date", date.getTime()).apply();
    }

    public final void setLanguage(String str) {
        this.prefs.edit().putString("lang", str).apply();
    }

    public final String getLanguage() {
        return this.prefs.getString("lang", "eng");
    }

    public final void isKeyboardChanged(boolean z) {
        this.prefs.edit().putBoolean("isKeyboardChanged", z).apply();
    }

    public final boolean getisKeyboardChanged() {
        return this.prefs.getBoolean("isKeyboardChanged", false);
    }

    public final void isKeyboardunlocked(boolean z) {
        this.prefs.edit().putBoolean("isKeyboardunlocked", z).apply();
    }

    public final boolean getisKeyboardunlocked() {
        return this.prefs.getBoolean("isKeyboardunlocked", false);
    }
}
