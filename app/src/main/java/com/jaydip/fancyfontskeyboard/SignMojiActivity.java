package com.jaydip.fancyfontskeyboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jaydip.fancyfontskeyboard.adapters.SignMojiAdapter;
import com.jaydip.fancyfontskeyboard.util.AdManager;
import com.jaydip.fancyfontskeyboard.util.KeyDataHolder;
import com.jaydip.fancyfontskeyboard.util.KeyboardSupport;

public class SignMojiActivity extends AppCompatActivity {
    ImageView backIV;
    public KeyDataHolder keyDataHolder;
    public SignMojiAdapter signMojiAdapter;
    private RecyclerView signMojiRV;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sign_moji);
        backIV = findViewById(R.id.backIV);
        backIV.setOnClickListener(v -> onBackPressed());
        this.keyDataHolder = new KeyDataHolder(this);
        signMojiRV = findViewById(R.id.gradientThemeRV);
        signMojiRV.setLayoutManager(new GridLayoutManager(this, 2));
        signMojiAdapter = new SignMojiAdapter(this, new SignMojiAdapter.OnFontInstall() {
            @Override
            public void onFontInstall(String str) {
                keyDataHolder.putBoolean("font_" + str, true);
                signMojiAdapter.notifyDataSetChanged();
                if (!KeyboardSupport.INSTANCE.isThisKeyboardSetAsDefaultIME(SignMojiActivity.this)) {
                    Toast.makeText(getApplicationContext(), "Please set this keyboard as default to use this Emojis.", 1).show();
                }
                navigate(null, 0);
            }
        });
        this.signMojiRV.setAdapter(signMojiAdapter);

    }


    public void navigate(Intent intent, int i) {
        AdManager.startActivity(this, intent, i);
    }
}
