package com.jaydip.fancyfontskeyboard;

import android.os.Bundle;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class PrivacyActivity extends AppCompatActivity {
    
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_privacy);
        getWindow().setFlags(1024, 1024);
        WebView webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/privacy_policy.html");
    }
}
