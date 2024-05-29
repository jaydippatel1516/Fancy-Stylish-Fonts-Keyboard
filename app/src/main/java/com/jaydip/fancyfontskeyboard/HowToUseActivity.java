package com.jaydip.fancyfontskeyboard;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.jaydip.fancyfontskeyboard.themes.Utils;

public class HowToUseActivity extends AppCompatActivity {
    ImageView backIV;

    
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_howto);
        backIV = (ImageView) findViewById(R.id.backIV);
        backIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

}
