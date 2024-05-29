package com.jaydip.fancyfontskeyboard;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.DefaultStyle;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle4;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle5;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyStyle8;
import com.jaydip.fancyfontskeyboard.util.KeyDataHolder;
import com.jaydip.fancyfontskeyboard.util.KeyboardSupport;

public class SplashActivity extends AppCompatActivity {
    ImageView bgIV;
    ImageView iconIV;

    
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_splash);
        if (getStatusBarHeight() > KeyboardSupport.dpToPx(24, this)) {
            getWindow().setFlags(512, 512);
        } else {
            getWindow().setFlags(1024, 1024);
        }
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.text_blue));
        this.bgIV = (ImageView) findViewById(R.id.bgIV);
        this.iconIV = (ImageView) findViewById(R.id.iconIV);
        Glide.with((FragmentActivity) this).load(Integer.valueOf((int) R.drawable.sp_bg)).into(this.bgIV);
        Glide.with((FragmentActivity) this).load(Integer.valueOf((int) R.drawable.sp_icon)).into(this.iconIV);
        KeyDataHolder keyDataHolder = new KeyDataHolder(this);
        keyDataHolder.putBoolean("font_" + DefaultStyle.class.getCanonicalName(), true);
        keyDataHolder.putBoolean("font_" + FancyStyle4.class.getCanonicalName(), true);
        keyDataHolder.putBoolean("font_" + FancyStyle5.class.getCanonicalName(), true);
        keyDataHolder.putBoolean("font_" + FancyStyle8.class.getCanonicalName(), true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                finish();
            }
        }, 5000);
    }


    public int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
