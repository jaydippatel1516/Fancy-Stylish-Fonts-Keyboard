package com.jaydip.fancyfontskeyboard.util;

import android.content.ComponentName;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.List;

public final class KeyboardSupport {
    public static final KeyboardSupport INSTANCE = new KeyboardSupport();

    private KeyboardSupport() {
    }

    public final boolean isThisKeyboardSetAsDefaultIME(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
        String packageName = context.getPackageName();
        Log.e("keyboard", string + " : " + packageName);
        return isThisKeyboardSetAsDefaultIME(string, packageName);
    }

    public final boolean isThisKeyboardSetAsDefaultIME(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
        if (unflattenFromString != null) {
            return unflattenFromString.getPackageName().equals(str2);
        }
        throw new NullPointerException(unflattenFromString.getClassName());
    }

    public final boolean isThisKeyboardEnabled(Context context) {
        return isThisKeyboardEnabled(Settings.Secure.getString(context.getContentResolver(), "enabled_input_methods"), context.getPackageName());
    }

    private final boolean isThisKeyboardEnabled(String str, String str2) {
        List asList;
        Object[] array;
        if (!(TextUtils.isEmpty(str) || (asList = Arrays.asList(str.toString().split(":"))) == null || (array = asList.toArray(new String[0])) == null)) {
            for (String str3 : (String[]) array) {
                ComponentName unflattenFromString = ComponentName.unflattenFromString(str3);
                if (unflattenFromString != null && unflattenFromString.getPackageName().equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int dpToPx(int i, Context context) {
        return Math.round(((float) i) * (context.getResources().getDisplayMetrics().xdpi / 160.0f));
    }
}
