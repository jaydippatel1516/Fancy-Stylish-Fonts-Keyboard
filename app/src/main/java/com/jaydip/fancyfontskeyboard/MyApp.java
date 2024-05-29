package com.jaydip.fancyfontskeyboard;

import android.app.Application;
import com.jaydip.fancyfontskeyboard.util.PreferenceManager;

public class MyApp extends Application {
    public void onCreate() {
        super.onCreate();
        PreferenceManager.init(getApplicationContext());
    }
}
