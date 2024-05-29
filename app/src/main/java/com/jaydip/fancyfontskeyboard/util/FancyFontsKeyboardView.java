package com.jaydip.fancyfontskeyboard.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;
import com.jaydip.fancyfontskeyboard.service.FancyFontManager;
import java.util.List;

public final class FancyFontsKeyboardView extends KeyboardView {
    public FancyFontsKeyboardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FancyFontsKeyboardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onDraw(Canvas canvas) {
        Keyboard keyboard = getKeyboard();
        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        float f = getResources().getDisplayMetrics().scaledDensity * 22.0f;
        String string = PreferenceManager.getInstance().getString("THEME", "THEME1");
        if (!string.contains("THEME")) {
            paint.setColor(Color.parseColor("#FFFFFF"));
        } else if (string.equals("THEME1")) {
            paint.setColor(Color.parseColor("#252525"));
        } else if (string.equals("THEME2")) {
            paint.setColor(Color.parseColor("#FFFFFF"));
        } else if (string.equals("THEME3")) {
            paint.setColor(Color.parseColor("#FFFFFF"));
        } else if (string.equals("THEME4")) {
            paint.setColor(Color.parseColor("#FFFFFF"));
        } else if (string.equals("THEME5")) {
            paint.setColor(Color.parseColor("#FFFFFF"));
        } else if (string.equals("THEME6")) {
            paint.setColor(Color.parseColor("#FFFFFF"));
        } else if (string.equals("THEME7")) {
            paint.setColor(Color.parseColor("#FFFFFF"));
        } else if (string.equals("THEME8")) {
            paint.setColor(Color.parseColor("#FFFFFF"));
        } else {
            paint.setColor(Color.parseColor("#252525"));
        }
        paint.setTypeface(Typeface.DEFAULT);
        List<Keyboard.Key> keys = keyboard.getKeys();
        super.onDraw(canvas);
        for (Keyboard.Key key : keys) {
            CharSequence letter = FancyFontManager.INSTANCE.getCurrentFont().letter(key.codes[0], isShifted());
            boolean isUpsideDown = FancyFontManager.INSTANCE.getCurrentFont().isUpsideDown();
            if (key.label != null) {
                if (key.label.equals("?")) {
                    key.codes = isUpsideDown ? new int[]{191} : new int[]{63};
                } else if (key.label.equals("¿")) {
                    key.codes = isUpsideDown ? new int[]{63} : new int[]{191};
                } else if (key.label.equals(".")) {
                    key.codes = isUpsideDown ? new int[]{729} : new int[]{46};
                } else if (key.label.equals("˙")) {
                    key.codes = isUpsideDown ? new int[]{46} : new int[]{729};
                } else if (key.label.equals(",")) {
                    key.codes = isUpsideDown ? new int[]{39} : new int[]{44};
                } else if (key.label.equals("'")) {
                    key.codes = isUpsideDown ? new int[]{44} : new int[]{39};
                } else if (key.label.equals("!")) {
                    key.codes = isUpsideDown ? new int[]{161} : new int[]{33};
                } else if (key.label.equals("¡")) {
                    key.codes = isUpsideDown ? new int[]{33} : new int[]{161};
                } else if (key.label.equals("\"")) {
                    key.codes = isUpsideDown ? new int[]{8222} : new int[]{34};
                }
            }
            if (letter != null) {
                key.text = letter.toString();
                String charSequence = letter.toString();
                if (FancyFontManager.INSTANCE.getCurrentFont().isUpsideDown()) {
                    charSequence = String.valueOf((char) key.codes[0]);
                }
                paint.setTextSize(FancyFontManager.INSTANCE.getCurrentFont().getSizeFactorKeys() * f);
                if (canvas != null) {
                    canvas.drawText(charSequence, ((float) key.x) + (((float) key.width) / 2.0f), ((float) key.y) + (((float) key.height) / 2.0f) + ((paint.getTextSize() - paint.descent()) / 2.0f), paint);
                }
            }
        }
    }
}
