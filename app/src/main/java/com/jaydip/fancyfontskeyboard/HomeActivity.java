package com.jaydip.fancyfontskeyboard;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.jaydip.fancyfontskeyboard.effect.Attention;
import com.jaydip.fancyfontskeyboard.effect.Render;
import com.jaydip.fancyfontskeyboard.slider.CarouselView;
import com.jaydip.fancyfontskeyboard.slider.ImageListener;
import com.jaydip.fancyfontskeyboard.themes.Utils;
import com.jaydip.fancyfontskeyboard.util.AdManager;
import com.jaydip.fancyfontskeyboard.util.KeyboardSupport;

public class HomeActivity extends AppCompatActivity {
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        /* class com.jaydip.fancyfontskeyboard.HomeActivity.AnonymousClass1 */

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.INPUT_METHOD_CHANGED")) {
                if (KeyboardSupport.INSTANCE.isThisKeyboardSetAsDefaultIME(context)) {
                    Log.e("KeyboardSupport", "true: ");
                    render1.stop();
                    defIV.setBackgroundResource(R.drawable.blue_square_btn);
                    defIV.setColorFilter(ContextCompat.getColor(context, R.color.white), PorterDuff.Mode.MULTIPLY);
                    defTV.setBackgroundResource(R.drawable.blue_rtr_square_btn);
                    defTV.setTextColor(getResources().getColor(R.color.white));
                    return;
                }
                render1.start();
                defIV.setBackgroundResource(R.drawable.white_square_btn);
                defIV.setColorFilter(ContextCompat.getColor(context, R.color.text_def), PorterDuff.Mode.MULTIPLY);
                defTV.setBackgroundResource(R.drawable.white_rtr_square_btn);
                defTV.setTextColor(getResources().getColor(R.color.text_def));
                Log.e("KeyboardSupport", "false: ");
            }
        }
    };
    CarouselView carouselView;
    ImageView defIV;
    TextView defTV;
    LinearLayout defaultBtn;
    LinearLayout emojiBtn;
    LinearLayout enableBtn;
    ImageView enableIV;
    TextView enableTV;
    LinearLayout fancyFontBtn;
    LinearLayout howBtn;
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int i, ImageView imageView) {
            Glide.with(HomeActivity.this).load(Integer.valueOf(images[i])).into(imageView);

        }
    };
    private int[] images = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3, R.drawable.slide4};
    Render render;
    Render render1;
    LinearLayout settingsBtn;
    LinearLayout themeBtn;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_home);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.main_bg));
        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setImageListener(this.imageListener);
        this.carouselView.setPageCount(this.images.length);
        this.enableIV = findViewById(R.id.enableIV);
        this.enableTV = findViewById(R.id.enableTV);
        enableBtn = findViewById(R.id.enableBtn);
        enableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivityForResult(new Intent("android.settings.INPUT_METHOD_SETTINGS"), 102);
                } catch (ActivityNotFoundException unused) {
                    Toast.makeText(getApplicationContext(), "Error: Your device does not support 3rd-party keyboards. ${getString(R.string.app_name)} can not be added.", Toast.LENGTH_LONG).show();
                }
            }
        });
        this.defIV = findViewById(R.id.defIV);
        this.defTV = findViewById(R.id.defTV);
        defaultBtn = findViewById(R.id.defaultBtn);
        defaultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openKeyboardChooser();
            }
        });
        fancyFontBtn = findViewById(R.id.fancyFontBtn);
        fancyFontBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigate(new Intent(HomeActivity.this, FancyFontActivity.class), 0);

            }
        });
        emojiBtn = findViewById(R.id.emojiBtn);
        emojiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigate(new Intent(HomeActivity.this, SignMojiActivity.class), 0);

            }
        });
        themeBtn = findViewById(R.id.themeBtn);
        themeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigate(new Intent(HomeActivity.this, ThemesActivity.class), 0);

            }
        });
        settingsBtn = findViewById(R.id.settingsBtn);
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigate(new Intent(HomeActivity.this, SettingsActivity.class), 0);

            }
        });
        howBtn = findViewById(R.id.howBtn);
        howBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigate(new Intent(HomeActivity.this, HowToUseActivity.class), 0);

            }
        });
        this.render = new Render(this);
        Render render2 = new Render(this);
        this.render1 = render2;
        render2.setAnimation(Attention.RuberBand(this.defaultBtn));
        isKeyboardActive();

    }


    public void navigate(Intent intent, int i) {

        AdManager.startActivity(this, intent, i);

    }


    @Override
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 102) {
            Log.e("onActivityResult", "onActivityResult: " + isThisKeyboardEnabled(this));
            isKeyboardActive();
        }
    }

    private void isKeyboardActive() {
        if (isThisKeyboardEnabled(this)) {
            this.enableBtn.setEnabled(false);
            this.render.stop();
            this.enableIV.setBackgroundResource(R.drawable.blue_square_btn);
            this.enableIV.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.MULTIPLY);
            this.enableTV.setBackgroundResource(R.drawable.blue_rtr_square_btn);
            this.enableTV.setTextColor(getResources().getColor(R.color.white));
            this.defaultBtn.setEnabled(true);
            this.defaultBtn.setAlpha(1.0f);
            if (!KeyboardSupport.INSTANCE.isThisKeyboardSetAsDefaultIME(this)) {
                this.render1.start();
                this.defIV.setBackgroundResource(R.drawable.white_square_btn);
                this.defIV.setColorFilter(ContextCompat.getColor(this, R.color.text_def), PorterDuff.Mode.MULTIPLY);
                this.defTV.setBackgroundResource(R.drawable.white_rtr_square_btn);
                this.defTV.setTextColor(getResources().getColor(R.color.text_def));
            } else {
                this.render1.stop();
                this.defIV.setBackgroundResource(R.drawable.blue_square_btn);
                this.defIV.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.MULTIPLY);
                this.defTV.setBackgroundResource(R.drawable.blue_rtr_square_btn);
                this.defTV.setTextColor(getResources().getColor(R.color.white));
            }
            this.fancyFontBtn.setEnabled(true);
            this.fancyFontBtn.setAlpha(1.0f);
            this.emojiBtn.setEnabled(true);
            this.emojiBtn.setAlpha(1.0f);
            this.themeBtn.setEnabled(true);
            this.themeBtn.setAlpha(1.0f);
            return;
        }
        this.enableBtn.setEnabled(true);
        this.render.setAnimation(Attention.RuberBand(this.enableBtn));
        this.render.start();
        this.enableIV.setBackgroundResource(R.drawable.white_square_btn);
        this.enableIV.setColorFilter(ContextCompat.getColor(this, R.color.text_def), PorterDuff.Mode.MULTIPLY);
        this.enableTV.setBackgroundResource(R.drawable.white_rtr_square_btn);
        this.enableTV.setTextColor(getResources().getColor(R.color.text_def));
        this.defaultBtn.setEnabled(false);
        this.defaultBtn.setAlpha(0.7f);
        this.fancyFontBtn.setEnabled(false);
        this.fancyFontBtn.setAlpha(0.7f);
        this.emojiBtn.setEnabled(false);
        this.emojiBtn.setAlpha(0.7f);
        this.themeBtn.setEnabled(false);
        this.themeBtn.setAlpha(0.7f);
    }

    public void openKeyboardChooser() {
        registerReceiver(this.broadcastReceiver, new IntentFilter("android.intent.action.INPUT_METHOD_CHANGED"));
        Object systemService = getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).showInputMethodPicker();
        }
    }

    public final boolean isThisKeyboardEnabled(Context context) {
        return ((InputMethodManager) getSystemService("input_method")).getEnabledInputMethodList().toString().contains(context.getPackageName());
    }


    @Override
    public void onPause() {
        try {
            unregisterReceiver(this.broadcastReceiver);
        } catch (Exception unused) {
        }
        super.onPause();
    }
}
