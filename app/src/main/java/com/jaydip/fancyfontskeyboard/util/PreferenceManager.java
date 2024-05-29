package com.jaydip.fancyfontskeyboard.util;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {
    private static final String PREF_NAME = "font_face_stylish";
    private static SharedPreferences.Editor editor;
    private static PreferenceManager mManager;
    private static SharedPreferences mShare;

    public static void init(Context context) {
        mManager = new PreferenceManager();
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(PREF_NAME, 0);
        mShare = sharedPreferences;
        editor = sharedPreferences.edit();
    }

    public void remove(String str) {
        if (mShare.contains(str)) {
            editor.remove(str);
            editor.commit();
        }
    }

    public static PreferenceManager getInstance() {
        return mManager;
    }

    public void putBoolean(String str, boolean z) {
        mShare.edit().putBoolean(str, z).apply();
    }

    public void putInt(String str, int i) {
        mShare.edit().putInt(str, i).apply();
    }

    public void putLong(String str, long j) {
        mShare.edit().putLong(str, j).apply();
    }

    public boolean getBoolean(String str) {
        return mShare.getBoolean(str, false);
    }

    public int getInt(String str) {
        return mShare.getInt(str, 0);
    }

    public long getLong(String str) {
        return mShare.getLong(str, 0);
    }

    public void putString(String str, String str2) {
        mShare.edit().putString(str, str2).apply();
    }

    public String getString(String str, String str2) {
        return mShare.getString(str, str2);
    }

    public void setIsPhotoTheme(boolean z) {
        mShare.edit().putBoolean("photo_theme", z).apply();
    }

    public boolean getIsPhotoTheme() {
        return mShare.getBoolean("photo_theme", false);
    }
}
