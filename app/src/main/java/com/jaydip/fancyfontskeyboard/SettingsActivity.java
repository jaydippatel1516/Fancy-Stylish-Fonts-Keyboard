package com.jaydip.fancyfontskeyboard;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.jaydip.fancyfontskeyboard.themes.Utils;

import java.util.Set;

public class SettingsActivity extends AppCompatActivity {
    ImageView backIV;
    CardView moreLay;
    CardView policyLay;
    CardView rateLay;
    CardView shareLay;

    
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_settings);
        backIV =  findViewById(R.id.backIV);
        backIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        rateLay =  findViewById(R.id.rateLay);
        rateLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName())));
                } catch (ActivityNotFoundException unused) {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
                }
            }
        });
        shareLay=  findViewById(R.id.shareLay);
        shareLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", "Hey my friend check out this app\n https://play.google.com/store/apps/details?id=" + getPackageName() + " \n");
                startActivity(intent);
            }
        });
        policyLay=  findViewById(R.id.policyLay);
        policyLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingsActivity.this, PrivacyActivity.class));

            }
        });
    }

}
